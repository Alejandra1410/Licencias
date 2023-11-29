package Controller.Customer;


import Model.Customer.Customer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerController {
    private List<Customer> customerList;

    public CustomerController() {
        customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }

    public Customer getCustomerId(String identification) {
        for (Customer customer : customerList) {
            if (customer.getIdentification().equals(identification)) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            if (customer.getIdentification().equals(updatedCustomer.getIdentification())) {
                customerList.set(i, updatedCustomer);
                break;
            }
        }
    }

    public void activateLicense(String identification) {
    Customer customer = getCustomerId(identification);
    if (customer != null) {
        customer.setActive(true);
        customer.setDesactive(false);
    }
}

    public void deactivateLicense(String identification) {
    Customer customer = getCustomerId(identification);
    if (customer != null) {
        customer.setActive(false);
        customer.setDesactive(true);
    }
}

    public void deleteCustomer(String identification) {
        Customer customer = getCustomerId(identification);
        if (customer != null) {
            customerList.remove(customer);
        }
    }

}

