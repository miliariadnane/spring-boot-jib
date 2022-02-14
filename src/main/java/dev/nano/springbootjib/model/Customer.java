package dev.nano.springbootjib.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
public class Customer {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String phone;
    private String dob;
}
