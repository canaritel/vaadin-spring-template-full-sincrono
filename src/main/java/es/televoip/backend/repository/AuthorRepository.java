package es.televoip.backend.repository;

import es.televoip.backend.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<Author, String> {

}
