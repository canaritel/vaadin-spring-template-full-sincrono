package es.televoip.backend.service.implement;

import es.televoip.backend.entity.Base;
import es.televoip.backend.repository.BaseRepository;
import es.televoip.backend.service.BaseService;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j // nos permite enviar texto a la consola mediante "log"
@Transactional // anotar que revierte los procesos en caso de falla en el ciclo del método
@Service
public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public E getById(ID id) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);
            return optional.get();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E setSave(E entity) throws Exception {
        try {
            return baseRepository.insert(entity);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E setUpdate(ID id, E entity) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);
            E objectTmp = optional.get(); // Inicializamos el objeto, sino existe saltará error
            return baseRepository.save(entity);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean setDelete(ID id) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);
            baseRepository.delete(optional.get());
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public long getCountAll() throws Exception {
        try {
            return baseRepository.count();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<E> getAll() throws Exception {
        try {
            return baseRepository.findAll();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<E> getAllSort(Sort sort) throws Exception {
        try {
            return baseRepository.findAll(sort);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<E> getAllPageable(Pageable page) throws Exception {
        try {
            return baseRepository.findAll(page);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception(e.getMessage());
        }
    }

}
