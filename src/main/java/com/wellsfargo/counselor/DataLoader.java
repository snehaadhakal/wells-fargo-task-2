package com.wellsfargo.counselor;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.entity.Security;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.time.LocalDate; // <-- import LocalDate

/**
 * This class loads sample data into the H2 database when the app starts.
 * It inserts an Advisor, a Client, a Portfolio, and a Security to test relationships.
 */
@Component
public class DataLoader implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // 1. Create an Advisor
        Advisor advisor = new Advisor("Alice", "Johnson", "123 Main St", "555-1234", "alice@example.com");
        em.persist(advisor);

        // 2. Create a Client for the Advisor
        Client client = new Client("Bob Smith", "bob@example.com", "555-5678", advisor);
        em.persist(client);

        // 3. Create a Portfolio for the Client
        Portfolio portfolio = new Portfolio(client);
        em.persist(portfolio);

        // 4. Add a Security to the Portfolio
        Security security = new Security(
                "Apple Stock",
                "Equity",
                LocalDate.of(2026, 2, 5), // <-- FIXED: Use LocalDate instead of String
                150.0,
                10,
                portfolio
        );
        em.persist(security);

        System.out.println("Sample data loaded successfully!");
    }
}
