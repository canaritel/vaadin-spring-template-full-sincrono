package es.televoip.backend.repository;

import es.televoip.backend.entity.Base;
import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

// En este método declaramos los tipos de datos que vamos a permitir < Base, Serializable>
@NoRepositoryBean // no requerimos este repositorio se pueda instanciar
public interface BaseRepository<E extends Base, ID extends Serializable> extends MongoRepository<E, ID> {
    
}
