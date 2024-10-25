package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.commons.enums.Identifier;
import com.example.joyeria.commons.utilities.Utils;
import com.example.joyeria.entities.CustomerEntity;
import com.example.joyeria.entities.ShipmentEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.request.ShipmentRequest;
import com.example.joyeria.models.response.ShipmentResponse;
import com.example.joyeria.repository.CustomerRepository;
import com.example.joyeria.repository.ShipmentRepository;
import com.example.joyeria.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentBusiness implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<ShipmentResponse> getAllShipments() {
        return this.shipmentRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public void createShipment(ShipmentRequest shipmentRequest) {
        Optional<CustomerEntity> findCustomer = this.customerRepository.findCustomerByUsername(shipmentRequest.getCustomerName());
        if (findCustomer.isPresent()) {
            ShipmentEntity newShipment = ShipmentEntity.builder()
                    .shipmentId(Utils.generateRandomId(Identifier.SHIPMENT.getValue()))
                    .address(shipmentRequest.getAddress())
                    .shipmentDate(shipmentRequest.getDate())
                    .city(shipmentRequest.getCity())
                    .customer(findCustomer.get())
                    .build();
            this.shipmentRepository.save(newShipment);
        } else {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.CUSTOMER_NOT_FOUND);
        }
    }

    @Override
    public ShipmentResponse getShipmentById(String shipmentId) {
        Optional<ShipmentEntity> findShipment = this.shipmentRepository.findById(shipmentId);
        if(findShipment.isEmpty()){
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.SHIPMENT_NOT_FOUND);
        }
        return this.toResponse(findShipment.get());
    }

    @Override
    public void updateShipment(ShipmentRequest shipmentRequest) {

    }

    @Override
    public void deleteByShipmentId(String shipmentId) {
        Optional<ShipmentEntity> findShipment = this.shipmentRepository.findById(shipmentId);
        if(findShipment.isEmpty()){
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.SHIPMENT_NOT_FOUND);
        }
        this.shipmentRepository.deleteById(shipmentId);
    }

    private ShipmentResponse toResponse(ShipmentEntity entity){
        return new ModelMapper().map(entity, ShipmentResponse.class);
    }

}
