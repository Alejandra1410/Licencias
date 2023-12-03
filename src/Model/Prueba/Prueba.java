/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Prueba;

import Model.Citas.Cita;
import Model.Customer.Customer;
import Model.Oficial.Oficial;

/**
 *
 * @author wendy
 */
public class Prueba {
    private int idPrueba;
    private Cita cita; // Suponiendo que tienes una clase Cita
    private Oficial oficial; // Suponiendo que tienes una clase Oficial
    private Customer Customer; // Suponiendo que tienes una clase Cliente
    private String observaciones;
    private int nota;
    private String estado; 

    public Prueba(int idPrueba, Cita cita, Oficial oficial, Customer Customer, String observaciones, int nota, String estado) {
        this.idPrueba = idPrueba; //Revisar bien el id cómo se va a menejar 
        this.cita = cita;
        this.oficial = oficial;
        this.Customer = Customer;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
    }
    

    public void calcularEstado() {
        if (this.nota >= 80) {          //Controlar que solo reprobado o Aprobado ya que la BD tiene un checkConstraint
            this.estado = "Aprobado";
        } else {
            this.estado = "Reprobado";
        }
    }

    public void agregarObservacion(String observacion) {
        this.observaciones += observacion; //Esto concatena pero no sé si hace falta ya que es un textArea
    }

}
