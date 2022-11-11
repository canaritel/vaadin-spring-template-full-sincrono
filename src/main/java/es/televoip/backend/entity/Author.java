package es.televoip.backend.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


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
public class Author extends Base {

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
    @Size(min = 10, max = 8000)
    private String biografia;

}
