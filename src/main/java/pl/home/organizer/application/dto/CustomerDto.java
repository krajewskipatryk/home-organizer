package pl.home.organizer.application.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private static final long serialVersionUID = -5778383570944591732L;
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private boolean emailVerificationStatus = false;
}
