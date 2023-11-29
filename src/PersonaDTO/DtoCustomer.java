package PersonaDTO;


import java.sql.Date;

/**
 *
 * @author abiga
 */
public class DtoCustomer {
    private String identification;
    private String Name;
    private Date dateOfBirth;
    private int telephone;
    private String email;
    private boolean active;
    private boolean desactive;

    public String getIdentification() {
        return identification;
    }

    public String getName() {
        return Name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }
 
    public boolean isDesactive() {
        return desactive;
    }
    
    
}

