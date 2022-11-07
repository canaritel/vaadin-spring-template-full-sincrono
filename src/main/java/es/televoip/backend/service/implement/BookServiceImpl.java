package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Book;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.repository.BookRepository;
import es.televoip.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, String> implements BookService {

    @Autowired
    private BookRepository repository;

    public BookServiceImpl(BaseRepository<Book, String> baseRepository) {
        super(baseRepository);
    }

}
