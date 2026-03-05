package com.evendri.makhana.service;

import com.evendri.makhana.model.Product;
import com.evendri.makhana.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // showcase the list of the products on the frontend
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // to add a new product to the database
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // fetch product by id for product details page
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // udpate the products details by admin
    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setImageUrl(productDetails.getImageUrl());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setNutritionalInfo(productDetails.getNutritionalInfo());

        return productRepository.save(existingProduct);
    }

    // delete a product by id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}