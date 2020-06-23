package com.tgt.myRetail.service;

import com.tgt.myRetail.entity.Pricing;
import com.tgt.myRetail.entity.Role;
import com.tgt.myRetail.entity.User;
import com.tgt.myRetail.repository.PricingRepository;
import com.tgt.myRetail.repository.RoleRepository;
import com.tgt.myRetail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service

public class InitDBService {

    @Autowired
    private PricingRepository pricingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public InitDBService() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
        addPricing();
        addUsers();
    }

    private void addPricing() {
        if (pricingRepository != null) {

            Pricing pricing1 = new Pricing("13860428", "11.4", "USD");
            Pricing pricing2 = new Pricing("13860427", "15.4", "USD");
            Pricing pricing3 = new Pricing("13860426", "16", "USD");
            Pricing pricing4 = new Pricing("13860425", "19.9", "ISD");

            // Delete old data
            this.pricingRepository.deleteAll();


           // List<Pricing> pricings = Arrays.asList(pricing1, pricing2, pricing3, pricing4);
            this.pricingRepository.save(pricing1);
            this.pricingRepository.save(pricing2);
            this.pricingRepository.save(pricing3);
            this.pricingRepository.save(pricing4);

        }
    }


    private void addUsers() {
        if (userRepository != null) {
            // delete previous data
            this.roleRepository.deleteAll();

            Role roleUser = new Role("1", "USER");
            roleRepository.save(roleUser);

            Role roleAdmin = new Role("2", "ADMIN");
            roleRepository.save(roleAdmin);


            //*********Add user and admin role *****************************
            List<Role> roles2 = new ArrayList<>();
            roles2.add(roleUser);
            roles2.add(roleAdmin);

            List<User> accounts = new ArrayList<>();

            User account1 = new User("1", "admin", passwordEncoder.encode("admin"), roles2);

            List<Role> roles1 = new ArrayList<>();
            roles1.add(roleUser);
            User account2 = new User("2", "normaluser", passwordEncoder.encode("normalUser"), roles1);
            User account3 = new User("3", "dbuser", passwordEncoder.encode("dbuser"), roles1);

            accounts.add(account1);
            accounts.add(account2);
            accounts.add(account3);

            // delete previous data
            this.userRepository.deleteAll();

            //Save
            this.userRepository.save(account1);
            this.userRepository.save(account2);
            this.userRepository.save(account3);


        }
    }
}
