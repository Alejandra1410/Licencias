package Dao.Customer;

import Dao.Dao;
import DaoBD.DaoBD;
import PersonaDTO.DtoCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abiga
 */
public class CustomerDao implements Dao<DtoCustomer> {

    @Override
    public boolean create(DtoCustomer customer) {
        if (customer == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerInsert(?,?,?)"); 
        bd.set(1, customer.getIdentification());
        bd.set(2, customer.getName());
        bd.set(3, customer.getEmail());
        return bd.execute(false);
    }

    @Override
    public DtoCustomer read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerRead(?)"); 
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
            }
        }
        return null;
    }

    @Override
    public List<DtoCustomer> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerReadAll()"); 

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
        }

        return customerList;
    }

    @Override
    public boolean update(DtoCustomer customer) {
        if (customer == null || customer.getIdentification() == null || customer.getIdentification().isEmpty()) {
            return false;
        }

        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerUpdate(?,?,?)"); 
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
        bd.createStatement("call CustomerDelete(?)"); 
        bd.set(1, customer.getIdentification());
        return bd.execute(true);
    }
}


