package com.example.joyeria.business;

import com.example.joyeria.commons.constants.ErrorConstant;
import com.example.joyeria.entities.ProductEntity;
import com.example.joyeria.exceptions.custom.BusinessException;
import com.example.joyeria.models.response.ProductResponse;
import com.example.joyeria.repository.ProductRepository;
import com.example.joyeria.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
