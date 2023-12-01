package PersonaDTO;


import java.sql.Date;

/**
 *
 * @author abiga
 */
public class DtoCustomer extends PersonaDTO{
    
    private boolean active;
    private boolean desactive;

    public DtoCustomer(boolean active, boolean desactive,String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.active = active;
        this.desactive = desactive;
    }

    public boolean isActive() {
        return active;
    }
 
    public boolean isDesactive() {
        return desactive;
    }
    
    
}

