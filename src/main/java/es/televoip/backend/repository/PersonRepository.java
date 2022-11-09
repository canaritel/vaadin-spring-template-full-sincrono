package es.televoip.backend.repository;

import es.televoip.backend.entity.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, String> {

    List<Person> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String name, String lastname);

    Page<Person> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String name, String lastname, Pageable page);

    //Métodos para contar registros de las Query!. Perfectos y rápidos
    Long countByFirstNameContainingOrLastNameContainingAllIgnoreCase(String name, String lastname);

    //Método para comorobar si existe un dato específico
    // boolean existByDni(String dni);
    
    // Implementar QUERYS para los DTO
}
