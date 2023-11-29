package Dao.Customer;


import PersonaDTO.DtoCustomer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoBD implements Dao<DtoCustomer> {

    @Override
    public boolean create(DtoCustomer customer) {
        if (customer == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerInsert(?,?,?)"); // Reemplaza "CustomerInsert()" con tu procedimiento almacenado real
        bd.set(1, customer.getIdentification());
        bd.set(2, customer.getName());
        bd.set(3, customer.getEmail());
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
                            bd.getData().getString(1),
                            bd.getData().getString(2),
                            bd.getData().getString(3)
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
                    DtoCustomer customer = new DtoCustomer(
                            bd.getData().getString(1),
                            bd.getData().getString(2),
                            bd.getData().getString(3)
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
        if (customer == null || customer.getIdentification() == null || customer.getIdentification().isEmpty()) {
            return false;
        }

        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerUpdate(?,?,?)"); // Reemplaza "CustomerUpdate()" con tu procedimiento almacenado real
        bd.set(1, customer.getIdentification());
        bd.set(2, customer.getName());
        bd.set(3, customer.getEmail());
        return bd.execute(true);
    }

    @Override
    public boolean delete(DtoCustomer customer) {
        if (customer == null || customer.getIdentification() == null || customer.getIdentification().isEmpty()) {
            return false;
        }

        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerDelete(?)"); // Reemplaza "CustomerDelete()" con tu procedimiento almacenado real
        bd.set(1, customer.getIdentification());
        return bd.execute(true);
    }
}
