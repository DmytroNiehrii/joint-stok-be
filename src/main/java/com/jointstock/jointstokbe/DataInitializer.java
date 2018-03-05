package com.jointstock.jointstokbe;

import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.CommunityRepository;
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
    private final @NonNull
    CommunityRepository groups;

    @Transactional("transactionManager")
    public void initializeUser() {
        User user1 = new User("John", "Smith");
        users.save(user1);
        User user2 = new User("Bill", "Johns");
        users.save(user2);
        User user3 = new User("Kelly", "Minoug");
        users.save(user3);

        Community community1 = new Community("Car washing station", user1);
        community1.getMembers().add(user2);
        groups.save(community1);

        Community community2 = new Community("Music Store", user1);
        community2.getMembers().add(user2);
        community2.getMembers().add(user3);
        groups.save(community2);

        Community community3 = new Community("Clothes shop", user3);
        community3.getMembers().add(user1);
        community3.getMembers().add(user2);
        groups.save(community3);
    }
}
