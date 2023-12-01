/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dao.Oficial;

import PersonaDTO.DtoOficial;

/**
 *
 * @author wendy
 */
public class PruebaOficial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
          // Supongamos que tienes estos datos
        double salario = 50000.0; // Ejemplo de salario
        String contrasena = "hashDeLaContrasena";
        String cedula = "123456789";
        String nombre = "Juan Perez";
        java.sql.Date fechaNacimiento = java.sql.Date.valueOf("1990-01-01");
        String telefono = "1234567890";
        String correo = "juan@example.com";

        // Crear un objeto DtoOficial con salario
        DtoOficial oficial = new DtoOficial(salario,contrasena, cedula, nombre, fechaNacimiento, telefono, correo);

        // Resto del código para interactuar con DaoBDOficial
    
        // Crear una instancia de DaoBDOficial y llamar al método create
        DaoBDOficial daoOficial = new DaoBDOficial();
        boolean result = daoOficial.create(oficial);

        // Mostrar el resultado de la operación
        if (result) {
            System.out.println("Oficial creado exitosamente.");
        } else {
            System.out.println("Error al crear el oficial.");
        }
    }
}
    
