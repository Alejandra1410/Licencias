/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Oficial;
import Model.Persona;
import java.sql.Date;
public class Oficial extends Persona {

    public Oficial(double salario, String contrasena,String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = salario;
        this.contrasena = contrasena;
    }

   
    private double salario;
    private String contrasena;

 
    public double deducciones() {
        double deduccionesSeguridadSocial = salario * (5.5 + 3.84 + 1 + 3.3) / 100;
        double impuestoRenta = impuestoSobreRenta();
        return deduccionesSeguridadSocial + impuestoRenta;
    }

    private double impuestoSobreRenta() {
        if (salario <= 817000) {
            return 0;
        } else if (salario <= 1226000) {
            return (salario - 817000) * 0.10;
        } else {
            return (salario - 1226000) * 0.15 + 40500; // 10% de 817000 a 1226000 = 40500
        }
    }
    public double salarioNeto() {
        return salario - deducciones();
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }   
     public boolean cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (this.contrasena.equals(contrasenaActual)) {
            this.contrasena = nuevaContrasena;
            return true; 
        }
        return false; 
    }

    public boolean autenticar(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

}
