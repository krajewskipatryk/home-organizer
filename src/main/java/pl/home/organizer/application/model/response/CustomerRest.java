package pl.home.organizer.application.model.response;

import lombok.Data;

@Data
public class CustomerRest {
    String userId;
    String firstName;
    String lastName;
    String email;
}
