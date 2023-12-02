package Model.Customer;


import Dao.Dao;
import DaoBD.DaoBD;
import PersonaDTO.DtoCustomer;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoBD implements Dao<DtoCustomer> {

    @Override
    public boolean create(DtoCustomer customer) {
        if (customer == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerInsert(?,?,?,?,?)"); // Reemplaza "CustomerInsert()" con tu procedimiento almacenado real
        bd.set(1, customer.getCedula());
        bd.set(2, customer.getNombre());
        bd.set(3, customer.getFechaNacimiento());
        bd.set(4, customer.getTelefono());
        bd.set(5, customer.getCorreo());
        return bd.execute(false);
    }

    @Override
    public DtoCustomer read(String id) {
        try {
            DaoBD bd = new DaoBD();

            bd.createStatement("call CustomerRead(?)");
            bd.set(1, id);
            bd.execute(true);

            if (bd.getData().next()) {
                String nombre = bd.getData().getString("NombreCliente");
                Date fechanacimiento = bd.getData().getDate("Fecha_de_NacimientoCliente");
                String telefono = bd.getData().getString("Telefono");
                String correo = bd.getData().getString("Correo");

                return new DtoCustomer(id,nombre, fechanacimiento,telefono,correo);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<DtoCustomer> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerReadAll()"); // Reemplaza "CustomerReadAll()" con tu procedimiento almacenado real

        ArrayList<DtoCustomer> customerList = new ArrayList<>();

        try {
            if (bd.execute(true)) {
                while (bd.getData().next()) {
                      DtoCustomer customer = new DtoCustomer(
                            bd.getData().getString(1),
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
        DaoBD bd = new DaoBD();
        bd.createStatement("UPDATE clientes SET Cedula = ?, NombreCliente = ?, Fecha_de_NacimientoCliente = ?, Telefono = ?, Correo = ?");
        bd.set(1, customer.getCedula());
        bd.set(2, customer.getNombre());
        bd.set(3, customer.getFechaNacimiento());
        bd.set(4, customer.getTelefono());
        bd.set(5, customer.getCorreo());
        
        return bd.execute(false); 
    }

    @Override
    public boolean delete(DtoCustomer customer) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerDelete(?)");
        bd.set(1, customer);
        return bd.execute(false);
       
    }

}
