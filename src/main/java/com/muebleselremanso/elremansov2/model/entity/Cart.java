package com.muebleselremanso.elremansov2.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart implements Serializable {
    private Long id;
    private List<CartItem> items;
}
