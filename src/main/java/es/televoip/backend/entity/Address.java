package es.televoip.backend.entity;

import javax.annotation.Nonnull;
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

    @Nonnull
    private String street;

    @Nonnull
    private int number;

    @Nonnull
    private int postalCode;

}
