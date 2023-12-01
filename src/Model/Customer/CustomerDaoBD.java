package Model.Customer;


import Dao.Dao;
import DaoBD.DaoBD;
import PersonaDTO.DtoCustomer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoBD implements Dao<DtoCustomer> {

    @Override
    public boolean create(DtoCustomer customer) {
        if (customer == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerInsert(?,?,?)"); // Reemplaza "CustomerInsert
        //Pendiente perro caliente que el orden de las tablas cambian.
        bd.set(2, customer.getNombre());
        bd.set(3, customer.getFechaNacimiento());
        bd.set(4, customer.getTelefono());
        bd.set(5, customer.getCorreo());
        return bd.execute(false);
    }

    @Override
    public DtoCustomer read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerRead(?)"); // Reemplaza "CustomerRead()" con tu procedimiento almacenado real
        bd.set(1, id);
        if (bd.execute(true)) {
            try {
                if (bd.getData().next()) {
                    DtoCustomer customer = new DtoCustomer(
                           // Cambiar  bd.getData().getInt(1),
                            bd.getData().getString(2),
                            bd.getData().getDate(3),
                            bd.getData().getString(4),
                            bd.getData().getString(5)
                    );
                    return customer;
                } else {
                    return null;
                }
            } catch (SQLException ex) {
                // Manejar la excepción, si es necesario
            }
        }
        return null;
    }

    @Override
    public List<DtoCustomer> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerReadAll()"); // Reemplaza "CustomerReadAll()" con tu procedimiento almacenado real

        List<DtoCustomer> customerList = new ArrayList<>();

        try {
            if (bd.execute(true)) {
                while (bd.getData().next()) {
              // CAMBIAR      DtoCustomer customer = new DtoCustomer(
                            bd.getData().getInt(1),
                            bd.getData().getString(2),
                            bd.getData().getDate(3),
                            bd.getData().getString(4),
                            bd.getData().getString(5)
                    );
                    customerList.add(customer);
                }
            }
        } catch (SQLException ex) {
            // Manejar la excepción, si es necesario
        }

        return customerList;
    }

    @Override
    public boolean update(DtoCustomer customer) {
//        if (customer == null || customer.getId() == null || customer.getId().isEmpty()) {
//            return false;
//        }
//
//        DaoBD bd = new DaoBD();
//        bd.createStatement("call CustomerUpdate(?,?,?)"); // Reemplaza "CustomerUpdate()" con tu procedimiento almacenado real
//        bd.set(1, customer.getId());
//        bd.set(2, customer.getNombre()); //RevisarESTA MALO NO SE TIENE QUE PODER ACTUALIZAR ESTOS VALORES SOLO TELEFONO, CORREO
//        bd.set(3, customer.getCorreo());
//        return bd.execute(true);
        return false;
//        
    }

    @Override
    public boolean delete(DtoCustomer customer) {
//       if (customer == null || customer.getId()== null || customer.getId().isEmpty()) {
//            return false;
//        }
//
//        DaoBD bd = new DaoBD();
//        bd.createStatement("call CustomerDelete(?)"); // Reemplaza "CustomerDelete()" con tu procedimiento almacenado real
//        bd.set(1, customer.GER);
//        return bd.execute(true);
        return false;
       
    }
}
