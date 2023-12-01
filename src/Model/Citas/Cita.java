/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Citas;

import Model.Customer.Customer;
import java.sql.Date;
/**
 *
 * @author ekard
 */
// Cita.java
public class Cita {
    private int id;
    private Date fecha;
    private String hora;
    private Customer customer;

    public Cita(int id, Date fecha, String hora, Customer customer) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.customer = customer;
    }


    public Cita(int id, Date fecha, String hora) { //Este constructor es para probar crud
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }
    

    // Getter and Setter methods for id, fecha, hora, and cliente

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", customer=" + customer + '}';
    }
  
   
}

