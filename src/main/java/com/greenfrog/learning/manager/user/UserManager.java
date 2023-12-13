package com.greenfrog.learning.manager.user;

import com.greenfrog.learning.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class UserManager {

    private Map<String, User> users = new HashMap<>();

    public User createUser(String mail, String firstName, String lastName) {
        String uuid = UUID.randomUUID().toString();
        if (users.containsKey(uuid)) {
            uuid = UUID.randomUUID().toString();
        }
        User user = new User(mail, firstName, lastName);
        user.setId(uuid);
        users.put(uuid, user);
        log.debug("Created new user with id: " + user.getId());
        return user;
    }

    public User findUserById(String id) throws UserNotFoundException {
        if (!users.containsKey(id)) {
            throw new UserNotFoundException("No user found by id: " + id);
        }
        return users.get(id);
    }

    public void deleteUser(String id) throws UserNotFoundException {
        if (users.containsKey(id)) {
            users.remove(id);
            log.debug("Deleted user found by id: " + id);
            return;
        }
        throw new UserNotFoundException("No user found by id: " + id);
    }
}
