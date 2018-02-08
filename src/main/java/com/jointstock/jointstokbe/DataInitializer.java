package com.jointstock.jointstokbe;

import com.jointstock.jointstokbe.model.User;
import com.jointstock.jointstokbe.model.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final @NonNull UserRepository users;

    /**
     * Initializes a {@link User}.
     *
     * @return
     */
    @Transactional("userTransactionManager")
    public void initializeUser() {
        users.save(new User("John", "Smith"));
    }
}
