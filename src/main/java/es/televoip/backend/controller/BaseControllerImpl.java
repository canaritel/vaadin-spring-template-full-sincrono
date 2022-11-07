package es.televoip.backend.controller;

import es.televoip.backend.entity.Base;
import es.televoip.backend.exception.ControllerExceptions;
import es.televoip.backend.service.implement.BaseServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, String>> implements BaseController<E, String> {

    @Autowired
    protected S service;

    @GetMapping("/{id}") // solicitud GET, obtener datos
    @Override
    public E getId(@PathVariable String id) {
        try {
            E entity = service.getById(id);
            log.info("Use API-REST getId {}", entity);
            return entity;
        } catch (Exception e) {
            throw new ControllerExceptions("Error in getId method", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("") // solicitud GET, obtener datos
    @Override
    public List<E> getAll() {
        try {
            log.info("Use API-REST getAll");
            return service.getAll();
        } catch (Exception e) {
            throw new ControllerExceptions("Error in getAll method", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/page/{page}") // solicitud GET, obtener datos
    @Override
    public List<E> getAllPageable(Pageable page) {
        try {
            log.info("Use API-REST getAllPageable");
            return service.getAllPageable(page);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in getAllPageable method", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("") // solicitud POST, enviar datos
    @Override
    public void save(@RequestBody E entity) {
        try {
            log.info("Use API-REST save {}", entity);
            service.setSave(entity);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            //throw new ControllerExceptions("Error in save method", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}") // solicitud PUT, actualizar datos
    @Override
    public void update(@PathVariable String id, @RequestBody E entity) {
        try {
            log.info("Use API-REST update {}", entity);
            service.setUpdate(id, entity);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in update method", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}") // solicitud DELETE, eliminar datos
    @Override
    public void delete(@PathVariable String id) {
        try {
            E entity = service.getById(id);
            log.info("Use API-REST delete {}", entity);
            service.setDelete(id);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in delete method", HttpStatus.NOT_FOUND);
        }
    }

}
