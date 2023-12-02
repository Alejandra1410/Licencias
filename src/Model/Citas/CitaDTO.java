package Model.Citas;


import java.sql.Date;
/**
 *
 * @author ekard
 */
public class CitaDTO {
    private int id;
    private Date fecha;
    private String hora;
    private String Customer;
    private boolean activa;

    public CitaDTO(int id, Date fecha, String hora, String Customer) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.Customer = Customer;
    }

    public CitaDTO(Date fecha, String hora, String Customer) {
        this.id = 0; 
        this.fecha = fecha;
        this.hora = hora;
        this.Customer = Customer;
    }

    public CitaDTO(int id, Date fecha, String hora, String Customer, boolean activa) { 
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.Customer = Customer;
        this.activa = activa;
    }
    
    

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

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

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    
   

    @Override
    public String toString() {
        return "CitaDTO{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", Customer=" + Customer + '}';
    }

   
}