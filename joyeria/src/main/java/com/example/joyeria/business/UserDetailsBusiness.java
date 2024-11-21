package com.example.joyeria.business;

import com.example.joyeria.commons.enums.Identifier;
import com.example.joyeria.commons.utilities.Utils;
import com.example.joyeria.entities.CustomerEntity;
import com.example.joyeria.entities.RoleEntity;
import com.example.joyeria.models.request.AuthCreateUserRequest;
import com.example.joyeria.models.request.AuthLoginRequest;
import com.example.joyeria.models.response.AuthResponse;
import com.example.joyeria.repository.CustomerRepository;
import com.example.joyeria.repository.RoleRepository;
import com.example.joyeria.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsBusiness implements UserDetailsService {

    private final JwtUtils jwtUtils;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<CustomerEntity> findCustomer = customerRepository.findCustomerByEmail(email);

        if (findCustomer.isEmpty()) {
            throw new UsernameNotFoundException("El cliente con el correo " + email + " no existe.");
        }

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        findCustomer.get().getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())));
        findCustomer.get().getRoles().stream().flatMap(role -> role.getAuthorities().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getAuthorityName())));

        return new User(findCustomer.get().getUsername(), findCustomer.get().getPassword(), authorityList);
    }

    public AuthResponse createUser(AuthCreateUserRequest createUserRequest) {

        String username = createUserRequest.getUsername();
        String password = createUserRequest.getPassword();

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        roleEntitySet.add(this.roleRepository.findByRoleName("USER"));

        if (roleEntitySet.isEmpty()) {
            throw new IllegalArgumentException("The roles specified does not exist.");
        }

        CustomerEntity userEntity = CustomerEntity.builder()
                .customerId(Utils.generateRandomId(Identifier.CUSTOMER.getValue()))
                .username(username)
                .lastname(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(passwordEncoder.encode(password))
                .phone(createUserRequest.getPhone())
                .roles(roleEntitySet)
                .address(createUserRequest.getAddress())
                .build();

        CustomerEntity userSaved = this.customerRepository.save(userEntity);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userSaved.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleName()))));
        userSaved.getRoles().stream().flatMap(role -> role.getAuthorities().stream())
                .forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getAuthorityName())));

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = new UsernamePasswordAuthenticationToken(userSaved, password, authorities);

        String accessToken = jwtUtils.createToken(auth);

        return AuthResponse.builder()
                .username(username)
                .email(createUserRequest.getEmail())
                .message("User created successfully")
                .token(accessToken)
                .build();
    }


    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        String email = authLoginRequest.getEmail();
        String password = authLoginRequest.getPassword();

        Authentication authentication = this.authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        if(authentication.isAuthenticated()) {
            Optional<CustomerEntity> customerEntity = this.customerRepository.findCustomerByEmail(email);
            List<String> roles = customerEntity.get().getRoles()
                    .stream().map(RoleEntity::getRoleName).toList();
            String accessToken = jwtUtils.createToken(authentication);

            return AuthResponse.builder()
                    .customerId(customerEntity.get().getCustomerId())
                    .username(customerEntity.get().getUsername())
                    .email(email)
                    .roles(roles)
                    .message("Login successfully")
                    .token(accessToken)
                    .build();
        }
        return null;
    }

    public Authentication authenticate(String email, String password) {
        UserDetails userDetails = loadUserByUsername(email);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        return new UsernamePasswordAuthenticationToken(email, password, userDetails.getAuthorities());
    }

}
