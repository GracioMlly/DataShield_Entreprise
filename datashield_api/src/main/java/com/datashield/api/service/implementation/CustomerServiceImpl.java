package com.datashield.api.service.implementation;

import com.datashield.api.entities.Customer;
import com.datashield.api.repository.CustomerRepo;
import com.datashield.api.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    @PostConstruct
    public void init() {
        if (customerRepo.count() == 0) {
            // Ajouter plusieurs clients
            Customer customer1 = new Customer();
            customer1.setActivity("Courrier");
            customer1.setEmail("infos@laposte.tg");
            customer1.setSocietyName("La Poste");
            customer1.setAddress("Lome");

            Customer customer2 = new Customer();
            customer2.setActivity("Transport");
            customer2.setEmail("contact@transport.tg");
            customer2.setSocietyName("Transport Co.");
            customer2.setAddress("Kara");

            // Ajouter d'autres clients selon vos besoins
            Customer customer3 = new Customer();
            customer3.setActivity("Retail");
            customer3.setEmail("info@retail.tg");
            customer3.setSocietyName("Retail Inc.");
            customer3.setAddress("Sokodé");

            Customer customer4 = new Customer();
            customer4.setActivity("IT Services");
            customer4.setEmail("support@itservices.tg");
            customer4.setSocietyName("IT Services Ltd.");
            customer4.setAddress("Atakpamé");

            Customer customer5 = new Customer();
            customer5.setActivity("Consulting");
            customer5.setEmail("consult@consulting.tg");
            customer5.setSocietyName("Consulting Group");
            customer5.setAddress("Kpalimé");

            Customer customer6 = new Customer();
            customer6.setActivity("Education");
            customer6.setEmail("info@education.tg");
            customer6.setSocietyName("Education Center");
            customer6.setAddress("Tsévié");

            Customer customer7 = new Customer();
            customer7.setActivity("Healthcare");
            customer7.setEmail("contact@healthcare.tg");
            customer7.setSocietyName("Healthcare Services");
            customer7.setAddress("Aného");

            Customer customer8 = new Customer();
            customer8.setActivity("Finance");
            customer8.setEmail("info@finance.tg");
            customer8.setSocietyName("Finance Corp.");
            customer8.setAddress("Dapaong");

            Customer customer9 = new Customer();
            customer9.setActivity("Agriculture");
            customer9.setEmail("agri@agriculture.tg");
            customer9.setSocietyName("Agriculture Co.");
            customer9.setAddress("Sotouboua");

            Customer customer10 = new Customer();
            customer10.setActivity("Tourism");
            customer10.setEmail("info@tourism.tg");
            customer10.setSocietyName("Tourism Inc.");
            customer10.setAddress("Notsé");

            customerRepo.save(customer1);
            customerRepo.save(customer2);
            customerRepo.save(customer3);
            customerRepo.save(customer4);
            customerRepo.save(customer5);
            customerRepo.save(customer6);
            customerRepo.save(customer7);
            customerRepo.save(customer8);
            customerRepo.save(customer9);
            customerRepo.save(customer10);
        }}
}
