package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ProductImages;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImages, Integer> {
    List<ProductImages> findByProduct_ProductId(Integer productId);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM ProductImages pi WHERE pi.product.productId = :productId")
    void deleteByProductId(Integer productId);
}
