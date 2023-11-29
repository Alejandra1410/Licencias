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
//  private ClienteDTO cliente;

//    public CitaDTO(int id, Date fecha, Time hora, ClienteDTO cliente) {
//        this.id = id;
//        this.fecha = fecha;
//        this.hora = hora;
//        this.cliente = cliente;
//    }
//    
    
    
    public CitaDTO(int id, Date fecha, String hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
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

    @Override
    public String toString() {
        return "CitaDTO{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
}