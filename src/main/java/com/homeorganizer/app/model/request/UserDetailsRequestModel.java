package com.homeorganizer.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsRequestModel {
    String firstName;
    String lastName;
    String email;
    String password;
}
