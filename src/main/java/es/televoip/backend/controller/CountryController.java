package es.televoip.backend.controller;

import es.televoip.backend.entity.Country;
import es.televoip.backend.service.implement.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/countrys")
@ResponseBody
@RequiredArgsConstructor // genera un constructor con cada uno de los atributos final no inicializados
@CrossOrigin(origins = "*") // permitimos todos los orígenes para hacer uso de la APIrest
public class CountryController extends BaseControllerImpl<Country, CountryServiceImpl> {

}
