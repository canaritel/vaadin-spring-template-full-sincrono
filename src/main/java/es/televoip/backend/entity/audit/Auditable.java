package es.televoip.backend.entity.audit;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/*
*** Más información sobre Auditable en este enlace:
*** https://medium.com/codex/spring-data-mongodb-auditing-b4a874442a6
 */
@Data
@EqualsAndHashCode
@ToString
public abstract class Auditable {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    private String createdByUser;

    @LastModifiedBy
    private String modifiedByUser;

}
