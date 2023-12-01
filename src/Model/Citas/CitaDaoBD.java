package Model.Citas;

import Dao.Dao;
import DaoBD.DaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaDaoBD implements Dao<CitaDTO> {

    private DaoBD daoBD;

    public CitaDaoBD() {
        this.daoBD = new DaoBD();
    }

   @Override
   public boolean create(CitaDTO citaDTO) {

    daoBD.createStatement("call CitasInsert(null,?,?,?)");
    daoBD.set(1, citaDTO.getFecha());
    daoBD.set(2, citaDTO.getHora());
    daoBD.set(3, citaDTO.getDtoCustomer().getId()); // Asegúrate de que el cliente esté configurado correctamente

    return daoBD.execute(true);
}


    @Override
  public CitaDTO read(String id) {
    String sql = "{CALL crear_cita(?, ?, ?)}";
    daoBD.createStatement(sql);
    daoBD.set(1, id);
    daoBD.execute(true);

    CitaDTO citaDTO = null;
    try {
        if (daoBD.getData().next()) {
            CitaDTO cita = new CitaDTO(daoBD.getData().getInt(1),daoBD.getData().getDate(2),daoBD.getData().getString(3));
            return cita;
        }
    } catch (SQLException ex) {
        System.out.println("Error al leer cita por ID: " + ex.getMessage());
    }
    return citaDTO;
}


    @Override
    public List<CitaDTO> readAll() {

        daoBD.createStatement("call CitasReadAll(?, ?, ?)");
        daoBD.execute(true);
        List<CitaDTO> citas = new ArrayList<>();
        try {
            while (daoBD.getData().next()) {
                CitaDTO citaDTO = new CitaDTO(daoBD.getData().getInt(1),daoBD.getData().getDate(2),daoBD.getData().getString(3));
                // Puedes necesitar cargar el cliente asociado aquí
                citas.add(citaDTO);
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer todas las citas: " + ex.getMessage());
        }
        return citas;
    }

    @Override
    public boolean update(CitaDTO citaDTO) {
        String sql = "{CALL crear_cita(?, ?, ?)}";
        daoBD.createStatement(sql);
        daoBD.set(1, citaDTO.getId());
        daoBD.set(2, citaDTO.getFecha());
        daoBD.set(3, citaDTO.getHora());
//        daoBD.set(4, citaDTO.getCliente().getId());
        
        return daoBD.execute(false);
    }

    @Override
    public boolean delete(CitaDTO citaDTO) {
        String sql = "{CALL crear_cita(?, ?, ?)}";
        daoBD.createStatement(sql);
        daoBD.set(1, citaDTO.getId());
        return daoBD.execute(false);
    }

    
   //Validaciones
    
//    public boolean conteoDeCitas(Date fecha, String hora) {
//    DaoBD bd = new DaoBD();
//
//    // Lógica para verificar si ya existen cuatro citas en la misma fecha y hora
//    try {
//        // Consulta la base de datos para contar las citas en la misma fecha y hora
//        bd.createStatement("SELECT COUNT(*) FROM tu_tabla_citas WHERE fecha = ? AND hora = ?");
//        bd.set(1, fecha);
//        bd.set(2, hora);
//
//        bd.execute(true);
//
//        if (bd.getData().next()) {
//            int cantidadCitas = bd.getData().getInt(1);
//
//            // Devuelve true si ya existen cuatro citas, false en caso contrario
//            return cantidadCitas >= 4;
//        }
//    } catch (SQLException e) {
//        // Manejar la excepción, por ejemplo, imprimir el error
//        e.printStackTrace();
//    }
//
//    return false;
//}
    
//    Necesito lo de Abigail
//    public boolean conteoCitasClientes(Cliente cliente) {
//    DaoBD bd = new DaoBD();
//
//    // Lógica para verificar si el cliente tiene más de una cita activa
//    try {
//        // Consulta la base de datos para contar las citas activas del cliente
//        bd.createStatement("SELECT COUNT(*) FROM tu_tabla_citas WHERE cliente_id = ? AND activa = 1");
//        bd.set(1, cliente.getId());
//
//        bd.execute(true);
//
//        if (bd.getData().next()) {
//            int cantidadCitasActivas = bd.getData().getInt(1);
//
//            // Devuelve true si el cliente tiene más de una cita activa, false en caso contrario
//            return cantidadCitasActivas > 1;
//        }
//    } catch (SQLException e) {
//        // Manejar la excepción, por ejemplo, imprimir el error
//        e.printStackTrace();
//    }
//
//    return false;
//}


}
