package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.commons.enums.Identifier;
import com.example.joyeria.commons.utilities.Utils;
import com.example.joyeria.entities.ProductEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.request.ProductRequest;
import com.example.joyeria.models.response.ProductResponse;
import com.example.joyeria.repository.ProductRepository;
import com.example.joyeria.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductBusiness implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        return this.productRepository.findAll().stream().map(this::toResponse)
                .toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        try {
            ProductEntity productEntity = ProductEntity.builder()
                    .productId(Utils.generateRandomId(Identifier.PRODUCT.getValue()))
                    .productName(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .stock(productRequest.getQuantity())
                    .img(productRequest.getImg().getBytes())
                    .build();
            return this.toResponse(this.productRepository.save(productEntity));
        } catch (Exception e){
            log.info(e.getMessage());
            throw new BusinessException(ErrorConstant.GENERIC_ERROR_CODE, ErrorConstant.GENERIC_ERROR_MESSAGE);
        }
    }

    @Override
    public ProductResponse getByProductId(String id) {
        Optional<ProductEntity> productEntity = this.productRepository.findById(id);
        if(productEntity.isEmpty()) {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.PRODUCT_NOT_FOUND);
        }
        return toResponse(productEntity.get());
    }

    @Override
    public void deleteByProductId(String id) {
        Optional<ProductEntity> productEntity = this.productRepository.findById(id);
        if(productEntity.isEmpty()) {
            throw new BusinessException(ErrorConstant.NOT_FOUND_CODE, ErrorConstant.PRODUCT_NOT_FOUND);
        }
        this.productRepository.delete(productEntity.get());
    }

    private ProductResponse toResponse(ProductEntity entity){
        return new ModelMapper().map(entity, ProductResponse.class);
    }

}
