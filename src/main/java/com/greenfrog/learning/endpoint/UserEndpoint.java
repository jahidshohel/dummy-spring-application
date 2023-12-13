package com.greenfrog.learning.endpoint;


import com.greenfrog.learning.manager.user.UserManager;
import com.greenfrog.learning.manager.user.UserNotFoundException;
import com.greenfrog.learning.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = UserEndpoint.USER_ENDPOINT)
public class UserEndpoint {
    public static final String USER_ENDPOINT = "/api/user";

    private final UserManager userManager;

    public UserEndpoint(UserManager userManager) {
        this.userManager = userManager;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User userDto) {
        User user = userManager.createUser(userDto.getMail(), userDto.getFirstName(), userDto.getLastName());
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) throws UserNotFoundException {
        User user = userManager.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) throws UserNotFoundException {
        userManager.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
