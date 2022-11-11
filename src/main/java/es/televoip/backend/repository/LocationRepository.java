package es.televoip.backend.repository;

import es.televoip.backend.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends BaseRepository<City, String> {

}
