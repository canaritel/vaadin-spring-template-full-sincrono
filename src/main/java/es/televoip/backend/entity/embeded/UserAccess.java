package es.televoip.backend.entity.embeded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.televoip.backend.entity.enums.Role;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data  // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
@NoArgsConstructor  // genera un constructor sin parámetros
@AllArgsConstructor  // genera un constructor con un parámetro para cada campo en su clase
@Builder  // se utiliza en clases, constructores y métodos para proporcionarle API de compilador complejas
public class UserAccess {

    // Documento embebido, no requiero declarar id
    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 20)
    @Indexed(unique = true)
    private String username;

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 64)
    @JsonIgnore
    private String hashedPassword;

    @NotNull(message = "No puede estar vacío")
    private Role roles;
    //private Set<Role> roles;

}
