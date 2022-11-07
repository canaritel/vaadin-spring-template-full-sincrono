package es.televoip.backend.service;

import es.televoip.backend.entity.Base;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//@Service
public interface BaseService<E extends Base, ID extends Serializable> {

    public E getById(ID id) throws Exception;

    public E setSave(E entity) throws Exception;

    public E setUpdate(ID id, E entity) throws Exception;

    public boolean setDelete(ID id) throws Exception;

    public long getCountAll() throws Exception;

    public List<E> getAll() throws Exception;

    public List<E> getAllSort(Sort sort) throws Exception;

    public List<E> getAllPageable(Pageable page) throws Exception;

}
