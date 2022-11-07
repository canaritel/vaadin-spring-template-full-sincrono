package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Author;
import es.televoip.backend.repository.AuthorRepository;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, String> implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    public AuthorServiceImpl(BaseRepository<Author, String> baseRepository) {
        super(baseRepository);
    }

}
