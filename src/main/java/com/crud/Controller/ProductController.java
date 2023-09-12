package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.Repository.ProductRepository;
import com.crud.model.Product;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
 @Autowired
 private ProductRepository productRepository; 
 
 @GetMapping("/products")
 public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
     Page<Product> products = productRepository.findAll(pageable);
     return new ResponseEntity<>(products, HttpStatus.OK);
}
 @PostMapping("/products")
 public ResponseEntity<Product> createProduct(@RequestBody Product product) {
     Product createdProduct = productRepository.save(product);
     return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
 }
 @GetMapping("products/{id}")
 public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
     Optional<Product>prod=productRepository.findById(id);
     if (prod.isPresent()) {
         return ResponseEntity.ok(prod.get());
     } else {
         return ResponseEntity.notFound().build();
     }
 }
 @PutMapping("/products/{id}")
 public String updateProductById(@PathVariable Integer id, @RequestBody Product product) {
	 Optional<Product>prod=productRepository.findById(id);
     if (prod.isPresent()) {
         Product existProd=prod.get();
         existProd.setName(product.getName());
         existProd.setPrice(product.getPrice());
         productRepository.save(existProd);
     return "Product Details against Id" +id + "updated";
     }
     else {
     return "Product Details does not exist for Id" +id;
     }
 }

 @DeleteMapping("/products/{id}")
 public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
     Optional<Product> product = productRepository.findById(id);

     if (product.isPresent()) {
         productRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}


