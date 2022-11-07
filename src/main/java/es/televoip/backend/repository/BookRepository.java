package es.televoip.backend.repository;

import es.televoip.backend.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book, String> {

}
