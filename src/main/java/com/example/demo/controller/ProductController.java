package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

  @Autowired
  ProductService prodSer;
  
  @PostMapping("/add")
  public void adding_Product(Product prod){

    prodSer.addproduct(prod);
  }

  @GetMapping("/{id}")
  public Product dispalyingProduct(@PathVariable int id ){
    return prodSer.dispalyProduct(id);
  }

  @GetMapping("products")
  public List<Product> diaplayAll(){
    return prodSer.dispalyall();
  }

    @PutMapping("/{id}")
public void updatingProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
  prodSer.updatePro(id, updatedProduct);
}
@DeleteMapping("/{id}")
public void Deleting(@PathVariable int id){
  prodSer.Deleteproduct(id);
}

@GetMapping("/products")
public Page<Product> getProducts(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size,
    @RequestParam(defaultValue = "id,asc") String[] sort
) {
    PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort[1]), sort[0]));
    return prodSer.getAllProducts(pageable);
}


}
