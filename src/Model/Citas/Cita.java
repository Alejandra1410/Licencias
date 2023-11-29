/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Citas;

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
    //private Cliente cliente;

//    public Cita(int id, String fecha, String hora, Cliente cliente) {
//        this.id = id;
//        this.fecha = fecha;
//        this.hora = hora;
//        this.cliente = cliente;
//    }

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
    //NECESITO CLASE CLIENTE
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

    @Override //Falta Cliente
    public String toString() {
        return "Cita{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

   
}

