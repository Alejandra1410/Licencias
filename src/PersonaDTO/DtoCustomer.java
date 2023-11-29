package PersonaDTO;


import java.sql.Date;

/**
 *
 * @author abiga
 */
public class DtoCustomer extends PersonaDTO{
    
    private boolean active;
    private boolean desactive;

    public DtoCustomer(int id, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, nombre, fechaNacimiento, telefono, correo);
    }

    public boolean isActive() {
        return active;
    }
 
    public boolean isDesactive() {
        return desactive;
    }
    
    
}

