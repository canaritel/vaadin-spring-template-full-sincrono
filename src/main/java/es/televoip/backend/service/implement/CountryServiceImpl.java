package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Country;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.repository.CountryRepository;
import es.televoip.backend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, String> implements CountryService {

    @Autowired
    private CountryRepository repository;

    public CountryServiceImpl(BaseRepository<Country, String> baseRepository) {
        super(baseRepository);
    }

}
