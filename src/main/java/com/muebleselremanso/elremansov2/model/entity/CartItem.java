package com.muebleselremanso.elremansov2.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem implements Serializable {
    private Long id;
    private Product product;
    private Integer quantity;
}
