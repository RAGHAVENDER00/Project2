package com.example.demo.model;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Product {
 
  @Id
  private int ID;
  private String name;
  private String description;
  private Double price;
  private String category;


}
