package shop4Fun.service;

import org.springframework.beans.factory.annotation.Autowired;
import shop4Fun.dao.CustomerDao;
import shop4Fun.model.Customer;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    // methods need to be implement
    @Autowired
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        return customerDao.getCustomerByUserName(userName);
    }
}
