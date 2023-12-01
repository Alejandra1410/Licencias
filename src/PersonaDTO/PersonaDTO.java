/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaDTO;

import java.sql.Date;

/**
 *
 * @author wendy
 */
public abstract class PersonaDTO {
    private String id;
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;

    public PersonaDTO(String id, String nombre, Date fechaNacimiento, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
    


}
