package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;


  public Product addproduct(Product prod) {

    return repo.save(prod);

  }


  public Product dispalyProduct(int id) {
    return repo.findById(id).orElse(null);
  }


  public List<Product> dispalyall() {
    return repo.findAll();
    }


  public void updatePro(int id, Product updatedProduct) {
    Optional<Product> productid= repo.findById(id);
      if(productid.isPresent()){
        Product productcurr=productid.get();
        productcurr.setName(updatedProduct.getName());
        productcurr.setDescription(updatedProduct.getDescription());
        productcurr.setDescription(updatedProduct.getDescription());
        productcurr.setCategory(updatedProduct.getCategory());

        repo.save(productcurr);
      }else{
        throw new RuntimeException("Product not found with id: " + id);
      }
    

  }


  public void Deleteproduct(int id) {
    Optional<Product> productid= repo.findById(id);
    Product productcur=productid.get();
    repo.delete(productcur);
  }


  
  public Page<Product> getAllProducts(Pageable pageable) {
      return repo.findAll(pageable);
  }
  
  
}
