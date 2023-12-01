package PersonaDTO;


import java.sql.Date;

/**
 *
 * @author abiga
 */
public class DtoCustomer extends PersonaDTO{
    private boolean active;
    private boolean desactive;
    private int edad;

    public DtoCustomer( String id, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, nombre, fechaNacimiento, telefono, correo);
    }
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

    
    public boolean isActive() {
        return active;
    }
 
    public boolean isDesactive() {
        return desactive;
    }
    
    
}

