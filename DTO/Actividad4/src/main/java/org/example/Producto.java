package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString

public class Producto {
    private String codigo;
    private String nombre;
    private String proveedor;
    private double precio;
}
