package es.televoip.backend.repository;

import es.televoip.backend.entity.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends BaseRepository<Country, String> {

}
