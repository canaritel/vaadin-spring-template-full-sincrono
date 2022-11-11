package es.televoip.backend.controller;

import es.televoip.backend.entity.City;
import es.televoip.backend.service.implement.CityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/citys")
@ResponseBody
@RequiredArgsConstructor // genera un constructor con cada uno de los atributos final no inicializados
@CrossOrigin(origins = "*") // permitimos todos los orígenes para hacer uso de la APIrest
public class CityController extends BaseControllerImpl<City, CityServiceImpl> {

}
