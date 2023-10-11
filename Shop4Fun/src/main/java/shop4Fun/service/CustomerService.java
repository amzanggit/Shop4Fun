package shop4Fun.service;

import shop4Fun.model.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);

    Customer getCustomerByUserName(String userName);
}
