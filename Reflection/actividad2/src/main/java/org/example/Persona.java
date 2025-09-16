package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Persona {
    private String nombre;
    private int edad;




    public void Saludar (){
        System.out.println("Hola");
    }
}
