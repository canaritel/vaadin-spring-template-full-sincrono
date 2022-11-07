package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Person;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.repository.PersonRepository;
import es.televoip.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, String> implements PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonServiceImpl(BaseRepository<Person, String> baseRepository) {
        super(baseRepository);
    }

}
