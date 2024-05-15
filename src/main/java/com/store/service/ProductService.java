package com.store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.model.Product;
import com.store.model.dto.ProductDto;
import com.store.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private Page<ProductDto> getProducts(Pageable pageable) {
        try {
            Page<Product> products = productRepository.findAll(pageable);
            return products.map(p -> {
                ProductDto dto = new ProductDto();
                dto.setProductId(p.getProductId());
                if (p.getCategory() != null) {
                    dto.setCategoryName(p.getCategory().getCategoryName());
                }
                return dto;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
       
    }

}
