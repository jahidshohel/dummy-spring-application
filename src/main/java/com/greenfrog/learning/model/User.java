package com.greenfrog.learning.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends Model {
    @NotEmpty
    private String mail;
    private String firstName;
    private String lastName;

    public User(String mail, String firstName, String lastName) {
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
