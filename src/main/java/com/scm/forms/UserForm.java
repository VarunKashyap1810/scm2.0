package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3,message = "Min 3 Character Is Required")
    private String name;
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email Is Required")
    private String email;
    @NotBlank(message = "Password Is Required")
    @Size(min = 6, message = "Min 6 Character Is Required")
    private String password;
    @NotBlank(message = "About Is Required")
    private String about;
    @Size(min = 8, max = 12, message = "Invalid Phone Number")
    private String phoneNumber;

}
