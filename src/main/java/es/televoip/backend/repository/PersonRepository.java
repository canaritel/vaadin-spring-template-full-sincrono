package es.televoip.backend.repository;

import es.televoip.backend.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, String> {

}
