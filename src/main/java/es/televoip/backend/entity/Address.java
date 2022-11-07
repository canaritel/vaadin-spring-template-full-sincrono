package es.televoip.backend.entity;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
*** Este métono no tendrá *Repository* ni *Sercices* [[Embebido]]
*** Para el acceso a estos datos se realizará desde el documento que lo tiene relacionado
 */
@Data  // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
@NoArgsConstructor  // genera un constructor sin parámetros
@AllArgsConstructor  // genera un constructor con un parámetro para cada campo en su clase
@Builder  // se utiliza en clases, constructores y métodos para proporcionarle API de compilador complejas
public class Address {

    @Nonnull
    private String street;

    @Nonnull
    private int number;

    @Nonnull
    private int postalCode;

}
