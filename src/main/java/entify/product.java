/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entify;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity 
@Table(name = "products")
@Data 
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @NotBlank(message = "El nombre es obligatorio") 
    private String name; 

    private String description; 

    @Positive(message = "El precio debe ser positivo") 
    private Double price; 

    @Min(value = 0, message = "El stock mínimo es 0") 
    private Integer stock; 

    @NotBlank(message = "La categoría es obligatoria") 
    private String category; 

    private LocalDateTime createdAt; 

    @PrePersist 
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}