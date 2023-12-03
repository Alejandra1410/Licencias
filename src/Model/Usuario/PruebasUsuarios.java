/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model.Usuario;

import Model.Oficial.Oficial;
import java.util.Date;

/**
 *
 * @author wendy
 */
public class PruebasUsuarios{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
java.sql.Date fecha = java.sql.Date.valueOf("1980-01-01");

    // Luego, crea la instancia de Oficial con la fecha asignada
    Oficial oficial = new Oficial(1000000, "12345678", "Juan Pérez", fecha, "88888888", "juan@example.com");

    // Imprimir las deducciones y el salario neto
    System.out.println("Deducciones: " + oficial.deducciones());
    System.out.println("Salario Neto: " + oficial.salarioNeto());
}
}
