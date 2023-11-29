package Model.Customer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.sql.Date;

/**
 *
 * @author abiga
 */
public class Customer {
    private String identification;
    private String Name;
    private Date dateOfBirth;
    private int telephone;
    private String email;
    private boolean active;
    private boolean desactive;

    public Customer(String identification, String Name, Date dateofBirth, int telephone, String email) {
        this.identification = identification;
        this.Name = Name;
        this.dateOfBirth = dateofBirth;
        this.telephone = telephone;
        this.email = email;
    }
    

    public Customer(String identification, String Name, Date dateofBirth) {
        this.identification = identification;
        this.Name = Name;
        this.dateOfBirth = dateofBirth;
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
    
    public String getIdentification() {
        return identification;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDateofBirth() {
        return dateOfBirth;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   private int calculateAge() {
    return Period.between(
            this.dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            LocalDate.now()
    ).getYears();
}


    public int getAge(){
         return calculateAge();
   }
     public String getDateOfBirthAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOfBirth);
    }
}
    



