package Model;
import java.sql.Date;

public abstract class Persona {
    private int id; 
    private String cedula;
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;

    public Persona() {
    }

    public Persona(int id, String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    

    public int getId() {
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
    public String getCedula(){
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
