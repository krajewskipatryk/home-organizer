package pl.home.organizer.application.model.response;

import lombok.Data;

@Data
public class UserRest {
    String userId;
    String firstName;
    String lastName;
    String email;
}
