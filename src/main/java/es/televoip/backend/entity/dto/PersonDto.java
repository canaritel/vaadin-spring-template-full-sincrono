package es.televoip.backend.entity.dto;

import es.televoip.backend.entity.embeded.Address;
import es.televoip.backend.entity.Book;
import es.televoip.backend.entity.City;
import es.televoip.backend.entity.Country;
import es.televoip.backend.entity.embeded.UserAccess;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

// Para el proceso de validación de campos y https://refactorizando.com/validadores-spring-boot/
@Data   // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
public class PersonDto {

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 50)
    private String firstName;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 80)
    private String lastName;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 9, max = 9)
    private String dni;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 5, max = 60)
    @Email
    private String email;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 9, max = 20)
    private String phone;

    private LocalDate dateOfBirth;

    private boolean important;

    // Objetos de las Relaciones 
    private UserAccess userAccess;
    private Address address;
    private City city;
    private Country country;
    private List<Book> books;

}
