package es.televoip.backend.controller;

import es.televoip.backend.entity.Base;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<E extends Base, ID extends Serializable> {

    /*
    ** Para controlar la seguridad de las API hacemos uso de HttpServletRequest
    ** Nos permitirá conocer información como la URL y Host de quien no hace peticiones
    ** En caso de detectar muchas peticiones desde el mismo Host podemos "bloquear"
     */
    public E getId(@PathVariable ID id, HttpServletRequest request);

    public List<E> getAll(HttpServletRequest request);

    public Page<E> getAllPageable(Pageable page, HttpServletRequest request);

    public void save(@RequestBody E entity, HttpServletRequest request);

    public void update(@PathVariable ID id, @RequestBody E entity, HttpServletRequest request);

    public void delete(@PathVariable ID id, HttpServletRequest request);

}
