package es.televoip.backend.entity;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@EqualsAndHashCode(callSuper = false)
@Document
public class Book extends Base {

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 5, max = 80)
    private String title;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 5, max = 20)
    @Indexed(unique = true)
    private String isbn;

    @NotNull(message = "No puede estar vacío")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBook;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 5, max = 20)
    private String gender;

    @NotNull(message = "No puede estar vacío")
    @Min(1)
    @Max(1000000)
    private int pages;

    // ------------------- //
    @DBRef(lazy = true)
    private List<Author> authores;  // similar a Many-To-Many

}
