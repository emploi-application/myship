package tn.poste.myship.bootstrap;

import tn.poste.myship.user.Role;
import tn.poste.myship.user.UserAccount;
import tn.poste.myship.user.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.security.admin-email}")
    private String adminEmail;

    @Value("${app.security.admin-password}")
    private String adminPassword;

    @Override
    public void run(String... args) {
        userAccountRepository.findByEmail(adminEmail).ifPresentOrElse(
            u -> {},
            () -> {
                UserAccount admin = new UserAccount();
                admin.setEmail(adminEmail);
                admin.setPasswordHash(passwordEncoder.encode(adminPassword));
                admin.setRole(Role.ADMIN);
                admin.setActive(true);
                userAccountRepository.save(admin);
            }
        );
    }
}

