package pl.home.organizer.application.model.request;

import lombok.Data;

@Data
public class CustomerRequestDataModel {
    String firstName;
    String lastName;
    String email;
    String password;
}
