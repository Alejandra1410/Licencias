package Model.Customer;

import Model.Persona;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.sql.Date;

/**
 *
 * @author abiga
 */
public class Customer extends Persona {
   
    private boolean active;
    private boolean desactive;

    public Customer(String id, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(id, nombre, fechaNacimiento, telefono, correo);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDesactive() {
        return desactive;
    }

    public void setDesactive(boolean desactive) {
        this.desactive = desactive;
    }
    
    private int calculateAge() {
        return Period.between(
                this.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                LocalDate.now()
        ).getYears();
    }

    public int getAge() {
        return calculateAge();
    }

    public String getDateOfBirthAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(getFechaNacimiento());
    }
}



