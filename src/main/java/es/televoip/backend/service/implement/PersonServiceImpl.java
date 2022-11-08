package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Person;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.repository.PersonRepository;
import es.televoip.backend.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, String> implements PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonServiceImpl(BaseRepository<Person, String> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Person> search(String filter) throws Exception {
        try {
            List<Person> persons = repository.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(filter, filter);
            return persons;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Person> searchPageable(String filter, Pageable page) throws Exception {
        try {
            Page<Person> persons = repository.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(filter, filter, page);
            return persons;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
