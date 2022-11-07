package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Location;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.repository.LocationRepository;
import es.televoip.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends BaseServiceImpl<Location, String> implements LocationService {

    @Autowired
    private LocationRepository repository;

    public LocationServiceImpl(BaseRepository<Location, String> baseRepository) {
        super(baseRepository);
    }

}
