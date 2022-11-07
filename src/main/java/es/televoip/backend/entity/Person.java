package es.televoip.backend.entity;

import java.time.LocalDate;
import java.util.List;
import javax.annotation.Nonnull;
import javax.validation.constraints.Email;
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

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    @Nonnull
    //@Indexed(unique = true)
    private String dni;

    @Email
    @Nonnull
    //@Indexed(unique = true)
    private String email;

    @Nonnull
    private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Nonnull
    private String occupation;

    private boolean important;

    // -------------------------------- //
    @DBRef(lazy = true)
    private Location location; // es como One-To-Many

    @DBRef(lazy = true)
    private List<Book> books; // es como One-To-Many
}
