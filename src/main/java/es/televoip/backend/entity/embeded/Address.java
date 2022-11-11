package es.televoip.backend.entity.embeded;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
*** Este métono no tendrá *Repository* ni *Sercices* ya que lo vamos hacer [[Embebido]]
*** Para el acceso a estos datos se realizará desde el documento que lo tiene relacionado
 */
@Data  // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
@NoArgsConstructor  // genera un constructor sin parámetros
@AllArgsConstructor  // genera un constructor con un parámetro para cada campo en su clase
@Builder  // se utiliza en clases, constructores y métodos para proporcionarle API de compilador complejas
public class Address {  //No lo hacemos que extienda de Base al ser **Embebido**

    @NotNull(message = "No puede estar vacío")
    @NotBlank(message = "Este campo es requerido")
    @Size(min = 4, max = 100)
    private String street;

    @NotNull(message = "No puede estar vacío")
    @Min(10000)
    @Max(99999)
    private int postalCode;

    // @Pattern(regexp = "[0-9]{5}")
    // private String postalCode;
}
