/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaDTO;
import java.sql.Date;

public class DtoOficial extends PersonaDTO {
  
    private double salario;
    private String contrasena;

    public DtoOficial(double salario, String contrasena, String id, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, nombre, fechaNacimiento, telefono, correo);
        this.salario = salario;
        this.contrasena = contrasena;
    }

   
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getContrasena() {
        return contrasena;
    }

    
 
}
