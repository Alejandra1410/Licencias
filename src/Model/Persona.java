package Model;
import java.sql.Date;

public abstract class Persona {
    private int id; 
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;

    public Persona() {
    }

    public Persona(String id, String nombre, Date fechaNacimiento, String telefono, String correo) {
        this.id = 0;
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
