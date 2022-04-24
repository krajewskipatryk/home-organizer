package pl.home.organizer.application.model.response;

import lombok.Data;

@Data
public class UserRest {
    String id;
    String firstName;
    String lastName;
    String email;
}
