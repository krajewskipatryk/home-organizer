package pl.home.organizer.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private static final long serialVersionUID = -5778383570944591732L;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String emailVerificationToken;
    private boolean emailVerificationStatus = false;
}
