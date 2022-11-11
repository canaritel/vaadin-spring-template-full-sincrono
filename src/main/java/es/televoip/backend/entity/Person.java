package es.televoip.backend.entity;

import es.televoip.backend.entity.embeded.Address;
import es.televoip.backend.entity.embeded.UserAccess;
import es.televoip.backend.entity.enums.Gender;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


/*
*** Más información sobre Auditable en este enlace:
*** https://medium.com/codex/spring-data-mongodb-auditing-b4a874442a6
 */
@Data  // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
@NoArgsConstructor  // genera un constructor sin parámetros
@AllArgsConstructor  // genera un constructor con un parámetro para cada campo en su clase
@Builder  // se utiliza en clases, constructores y métodos para proporcionarle API de compilador complejas
@EqualsAndHashCode(callSuper = false)  // el método equals y el método hashCode se generan automáticamente
@Document
public class Person extends Base {

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 60)
    private String firstName;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 80)
    private String lastName;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 9, max = 9)
    @Indexed(unique = true)
    private String dni;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 60)
    @Email
    @Indexed(unique = true)
    private String email;

    private Gender gender;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 9, max = 17)
    private String phone;

    @NotNull(message = "No puede estar vacío")
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Builder.Default
    private boolean important = false;

    // -------------------------------- //
    // Embebido no lleva la anotación @DBRef
    private UserAccess userAccess; // es **Embebido**

    private Address address; // es **Embebido**

    @DBRef(lazy = true)
    private City city; // similar a One-To-One

    @DBRef(lazy = true)
    private Country country; // similar a One-To-One

    @DBRef(lazy = true)
    private List<Book> books; // es como One-To-Many (también podría ser un Many-To-Many)
}
