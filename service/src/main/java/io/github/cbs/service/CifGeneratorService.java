package io.github.cbs.service;

import io.github.cbs.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class CifGeneratorService {

    private final CustomerRepository customerRepository;
    private final SecureRandom random = new SecureRandom();

    private static final String CIF_PREFIX = "98";
    private static final int MAX_ATTEMPTS = 10;

    /**
     * Generates a unique 10-digit CIF (Customer Information File) number.
     * Format: 98 + 8 random digits (e.g., 9812345678).
     */
    public String generateUniqueCifNumber() {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            // Generate 8-digit random number between 10000000 and 99999999
            int randomSuffix = 10000000 + random.nextInt(90000000);
            String candidateCif = CIF_PREFIX + randomSuffix;

            if (!customerRepository.existsByCifNumber(candidateCif)) {
                log.info("Generated unique CIF number: {}", candidateCif);
                return candidateCif;
            }
        }
        throw new IllegalStateException("Failed to generate unique CIF number after " + MAX_ATTEMPTS + " attempts");
    }
}
