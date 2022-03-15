package pl.home.organizer.application.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel {
    String firstName;
    String lastName;
    String email;
    String password;
}
