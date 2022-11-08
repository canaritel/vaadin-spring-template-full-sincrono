package es.televoip.backend.controller;

import es.televoip.backend.entity.Base;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<E extends Base, ID extends Serializable> {

    public E getId(@PathVariable ID id);

    public List<E> getAll();

    public Page<E> getAllPageable(Pageable page);

    public void save(@RequestBody E entity);

    public void update(@PathVariable ID id, @RequestBody E entity);

    public void delete(@PathVariable ID id);

}
