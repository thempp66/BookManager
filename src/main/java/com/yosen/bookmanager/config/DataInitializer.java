package com.yosen.bookmanager.config;

import com.yosen.bookmanager.model.Role;
import com.yosen.bookmanager.model.BookUser;
import com.yosen.bookmanager.repository.RoleRepository;
import com.yosen.bookmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role guestRole = new Role();
        guestRole.setName("GUEST");
        roleRepository.save(guestRole);

        BookUser admin = new BookUser();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("adminpass"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        admin.setRoles(adminRoles);
        userRepository.save(admin);

        BookUser guest = new BookUser();
        guest.setUsername("guest");
        guest.setPassword(passwordEncoder.encode("guestpass"));
        Set<Role> guestRoles = new HashSet<>();
        guestRoles.add(guestRole);
        guest.setRoles(guestRoles);
        userRepository.save(guest);

        logger.info("Role and user prepared.");
    }
}
