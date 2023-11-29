/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Citas;


import Controller.Controller;
import Model.Citas.Cita;
import Model.Citas.CitaDTO;
import Model.Citas.CitaDaoBD;
import View.Interface.FrmCitas;
import java.util.List;

/**
 *
 * @author ekard
 */
public class CitaController implements Controller<Cita> {

    private FrmCitas view;

    public CitaController(FrmCitas view) {
        this.view = view;
    }
    @Override
    public boolean create(Cita cita) {
    CitaDaoBD dao = new CitaDaoBD();

    // Validar si el cliente tiene más de una cita activa
//    Cliente cliente = cita.getCliente(); // Asegúrate de que la clase Cita tenga un método getCliente()
//    if (dao.conteoCitasClientes(cliente)) {
//        view.displayMessage("Error: El cliente ya tiene una cita activa.");
//        return false;
//    }

    // Validar si ya existen cuatro citas en la misma fecha y hora con clientes diferentes
//    Date fecha = cita.getFecha();
//    String hora = cita.getHora();
//    if (dao.conteoDeCitas(fecha, hora)) {
//        view.displayMessage("Error: Ya existen cuatro citas registradas en la misma fecha y hora.");
//        return false;
//    }

    // Convertir la Cita a CitaDTO para usar en el método create del Dao
    CitaDTO citadto = new CitaDTO(cita.getId(), cita.getFecha(),cita.getHora());

    // Llama al método correspondiente en tu Dao para agregar la cita
    boolean success = dao.create(citadto);

    if (success) {
        view.displayMessage("Cita agregada exitosamente.");
    } else {
        view.displayMessage("Error al agregar la cita. Por favor, inténtalo de nuevo.");
    }

    return success;
}

    @Override
    public Cita read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cita> readAll() {
//         CitaDaoBD dao = new CitaDaoBD();
//            ArrayList<CitaDTO> lista = new ArrayList();
//          if(lista!=null){
//             view.mostrarTodo(lista);
//    
//    }
        return null;
          
    }

    @Override
    public boolean update(Cita obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Cita obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
           
}
