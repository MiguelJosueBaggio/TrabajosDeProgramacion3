package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // Cargar la clase Persona
        Class<?> clazz = Class.forName("Persona");

        // ---- Obtener e imprimir constructores ----
        System.out.println("Constructores:");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println("-> " + c.getName() + " con parámetros: "
                    + Arrays.toString(c.getParameterTypes()));
        }

        // ---- Instanciar un objeto usando reflection ----
        Constructor<?> cons = clazz.getConstructor(String.class, int.class);
        Object persona = cons.newInstance("Miguel", 25);

        // ---- Modificar el valor de nombre en tiempo de ejecución ----
        Field nombreField = clazz.getDeclaredField("nombre");
        nombreField.setAccessible(true); // romper el private
        nombreField.set(persona, "Juan"); // cambiar valor

        // ---- Invocar un método público mostrarInfo() ----
        Method mostrarInfo = clazz.getMethod("mostrarInfo");
        mostrarInfo.invoke(persona);

        // ---- Acceder e invocar un método privado saludar() ----
        Method saludar = clazz.getDeclaredMethod("saludar");
        saludar.setAccessible(true); // romper el private
        String saludo = (String) saludar.invoke(persona);
        System.out.println("Método privado invocado: " + saludo);
    }
}
