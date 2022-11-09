package es.televoip.backend.controller;

import es.televoip.backend.entity.Person;
import es.televoip.backend.exception.ControllerExceptions;
import es.televoip.backend.service.implement.PersonServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/persons")
@ResponseBody
@RequiredArgsConstructor // genera un constructor con cada uno de los atributos final no inicializados
@CrossOrigin(origins = "*") // permitimos todos los orígenes para hacer uso de la APIrest
@Slf4j // nos permite enviar texto a la consola mediante "log"
public class PersonController extends BaseControllerImpl<Person, PersonServiceImpl> {

    // @RequestParam y @PathVariable se pueden usar para extraer valores del URI de solicitud, pero son un poco diferentes.
    // @RequestParam: extrae valores de la cadena de consulta, está codificado
    // @PathVariable: extrae valores de la ruta URI, no está codificado
    @GetMapping("/search")
    public List<Person> search(@RequestParam String filter) {
        try {
            log.info("Use API-REST search[Person]");
            return service.search(filter);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new ControllerExceptions("Error in search method", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchPaged")
    public Page<Person> searchPageable(@RequestParam String filter, Pageable page) {
        try {
            log.info("Use API-REST searchPageable[Person]");
            return service.searchPageable(filter, page);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new ControllerExceptions("Error in search method", HttpStatus.NOT_FOUND);
        }
    }

}
