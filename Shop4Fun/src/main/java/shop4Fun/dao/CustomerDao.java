package shop4Fun.dao;

import shop4Fun.model.Customer;

public interface CustomerDao {
    // methods need to implement
    void addCustomer(Customer customer);

    Customer getCustomerByUserName(String userName);
}
