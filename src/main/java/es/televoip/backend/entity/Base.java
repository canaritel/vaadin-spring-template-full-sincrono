package es.televoip.backend.entity;

import es.televoip.backend.entity.audit.Auditable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data  // es equivalente a usar @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrutor al mismo tiempo
@NoArgsConstructor  // genera un constructor sin parámetros
@AllArgsConstructor  // genera un constructor con un parámetro para cada campo en su clase
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)  // el método equals y el método hashCode se generan automáticamente
public class Base extends Auditable implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;

}
