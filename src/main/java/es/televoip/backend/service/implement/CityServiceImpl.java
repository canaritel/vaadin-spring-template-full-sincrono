package es.televoip.backend.service.implement;

import es.televoip.backend.entity.City;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.repository.CityRepository;
import es.televoip.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends BaseServiceImpl<City, String> implements CityService {

    @Autowired
    private CityRepository repository;

    public CityServiceImpl(BaseRepository<City, String> baseRepository) {
        super(baseRepository);
    }

}
