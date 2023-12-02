package PersonaDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class DtoCustomer extends PersonaDTO {
    private int edad;

    public DtoCustomer(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        calcularEdad(fechaNacimiento.toLocalDate());
    }

    public DtoCustomer(String cedula, String nombre, Date fechaNacimiento, int edad, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private void calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        this.edad = periodo.getYears();
    }
    
}
