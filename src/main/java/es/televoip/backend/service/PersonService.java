package es.televoip.backend.service;

import es.televoip.backend.entity.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService extends BaseService<Person, String> {

    List<Person> search(String filter) throws Exception;

    Page<Person> searchPageable(String filter, Pageable page) throws Exception;

}
