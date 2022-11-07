package es.televoip.backend.entity;

import javax.annotation.Nonnull;
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

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    @Nonnull
    private String biografia;

}
