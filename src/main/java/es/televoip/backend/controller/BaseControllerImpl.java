package es.televoip.backend.controller;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import es.televoip.backend.entity.Base;
import es.televoip.backend.exception.ControllerExceptions;
import es.televoip.backend.mapper.PersonDtoToPerson;
import es.televoip.backend.service.implement.BaseServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j // nos permite enviar texto a la consola mediante "log"
@Component // lo anoto como Component (permite a Spring detectar los beans y colocarlos dentro de su contexto para ser utilizados) **************************
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, String>> implements BaseController<E, String> {

    // @RequestParam y @PathVariable se pueden usar para extraer valores del URI de solicitud, pero son un poco diferentes.
    // @RequestParam:s extrae valores de la cadena de consulta, está codificado
    // @PathVariable: extrae valores de la ruta URI, no está codificado 
    @Autowired
    protected S service;

    @Autowired
    private PersonDtoToPerson PersonMapper;

    /*
    ** Método de EJEMPLO con los tipos de inyecciones de parámetros **
    ** En las peticiones nos llegan datos: en Cabecera, en URL, como Parámetros o en el Cuerpo
     */
    @GetMapping("/echo/{id}")
    public String echo(
            @RequestHeader(value = "token", required = false) String token,
            @PathVariable(value = "id") int id,
            @RequestParam(defaultValue = "Non") String param,
            @RequestBody(required = false) String body) {
        String response = "{\"id\":%d,\"token\":\"%s\",\"param\":\"%s\",\"body\":\"%s\"}";
        log.info(String.format(response, id, token, param, body) + "{}", this.service);
        return String.format(response, id, token, param, body);
    }

    /*
    ****************  Fin Método EJEMPLO **************
     */
    //
    /*
    ** Para controlar la seguridad de las API hacemos uso de HttpServletRequest
    ** Nos permitirá conocer información como la URL y Host de quien no hace peticiones
     */
    @GetMapping("/{id}") // solicitud GET, obtener datos
    @Override
    public E getId(@PathVariable String id, HttpServletRequest request) {
        try {
            E entity = service.getById(id);
            log.info("API-REST getId {} {}", request.getRequestURI(), request.getRemoteHost());
            return entity;
        } catch (Exception e) {
            throw new ControllerExceptions("Error in getId method", HttpStatus.NOT_FOUND, requestError(request));
        }
    }

    @GetMapping("") // solicitud GET, obtener datos
    @Override
    public List<E> getAll(HttpServletRequest request) {
        try {
            log.info("API-REST getAll {} {}", this.service, request.getRemoteHost());
            return service.getAll();
        } catch (Exception e) {
            throw new ControllerExceptions("Error in getAll method", HttpStatus.NOT_FOUND, requestError(request));
        }
    }

    @GetMapping("/paged") // solicitud GET, obtener datos
    @Override
    public Page<E> getAllPageable(Pageable page, HttpServletRequest request) {
        try {
            log.info("API-REST getAllPageable {} {}", this.service, request.getRemoteHost());
            return service.getAllPageable(page);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in getAllPageable method", HttpStatus.NOT_FOUND, requestError(request));
        }
    }

    @PostMapping("") // solicitud POST, enviar datos
    @Override
    public void save(@RequestBody E entity, HttpServletRequest request) {
        try {
            log.info("API-REST save {} {}", entity, request.getRemoteHost());
            service.setSave(entity);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in save method", HttpStatus.NOT_FOUND, requestError(request));
        }
    }

    @PutMapping("/{id}") // solicitud PUT, actualizar datos
    @Override
    public void update(@PathVariable String id, @RequestBody E entity, HttpServletRequest request) {
        try {
            log.info("API-REST update {} {}", entity, request.getRemoteHost());
            service.setUpdate(id, entity);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in update method", HttpStatus.NOT_FOUND, requestError(request));
        }
    }

    @DeleteMapping("/{id}") // solicitud DELETE, eliminar datos
    @Override
    public void delete(@PathVariable String id, HttpServletRequest request) {
        try {
            E entity = service.getById(id);
            log.info("API-REST delete {} {}", entity, request.getRemoteHost());
            service.setDelete(id);
        } catch (Exception e) {
            throw new ControllerExceptions("Error in delete method", HttpStatus.NOT_FOUND, requestError(request));
        }
    }

    private String requestError(HttpServletRequest request) {
        return request.getRequestURI() + " | " + request.getRemoteHost();
    }

}
