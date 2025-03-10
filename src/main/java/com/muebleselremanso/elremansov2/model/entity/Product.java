package com.muebleselremanso.elremansov2.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double promotionalPrice;
    private String mainImage;
    private Boolean visible;
    private Boolean activePromotion;
    private List<String> imagesList;
    private Category category; // ¡Requiere la clase Category!
}