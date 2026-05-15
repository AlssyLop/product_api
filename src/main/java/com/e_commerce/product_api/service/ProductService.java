package com.e_commerce.product_api.service;

import com.e_commerce.product_api.dto.ProductRequestDTO;
import com.e_commerce.product_api.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductResponseDTO> getAllProducts(Pageable pageable);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO request);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO request);
    void deleteProduct(Long id);
}
