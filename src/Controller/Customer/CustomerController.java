package Controller.Customer;

import Controller.Controller;
import Model.Citas.CitaDTO;
import Model.Customer.Customer;
import Model.Customer.CustomerDaoBD;
import PersonaDTO.DtoCustomer;
import View.Interface.FrmCitas;
import View.Interface.TablaClientes;
import java.util.ArrayList;
import java.util.List;




public class CustomerController implements Controller<Customer> {

    private FrmCitas view;
    private TablaClientes viewC;

    public CustomerController(FrmCitas view) {
        this.view = view;
    }
    
    @Override
    public boolean create(Customer customer) {
    CustomerDaoBD dao = new CustomerDaoBD();
    DtoCustomer customerdto = new DtoCustomer(customer.getId(),customer.getNombre(),customer.getFechaNacimiento(),customer.getTelefono(),customer.getCorreo());
    boolean success = dao.create(customerdto);

    if (success) {
        view.displayMessage("Cliente creado exitosamente.");
    } else {
        view.displayMessage("Error al crear el cliente. Por favor, inténtalo de nuevo.");
    }

    return success;
}


    @Override
    public Customer read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    @Override
    public List<Customer> readAll() {
    CustomerDaoBD dao = new CustomerDaoBD();
    List<Customer> List = new ArrayList<>();
    List<DtoCustomer> userDTOs = dao.readAll();
    for (DtoCustomer dto : userDTOs) {
        Customer customer = new Customer(dto.getId(),dto.getNombre(),dto.getFechaNacimiento(),dto.getTelefono(),dto.getCorreo());
        List.add(customer);
    }

    return List;
       }
 

    @Override
    public boolean update(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

