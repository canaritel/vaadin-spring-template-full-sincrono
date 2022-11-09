package es.televoip.backend.entity.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data   // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
public class PersonDto {

    @NotNull(message = "No puede estar vacío")
    @Size(min = 4, max = 50)
    private String firstName;

    @NotNull(message = "No puede estar vacío")
    @Size(min = 4, max = 80)
    private String lastName;

    @NotNull(message = "No puede estar vacío")
    @Size(min = 9, max = 9)
    private String dni;

    @NotNull(message = "No puede estar vacío")
    @Size(min = 5, max = 60)
    @Email
    private String email;

    @NotNull(message = "No puede estar vacío")
    @Size(min = 5, max = 20)
    private String phone;

    private LocalDate dateOfBirth;

    private boolean important;

//    @Pattern(regexp = "[0-9]{5}")
//    private String postalCode;
}
