package es.televoip.backend.controller;

import es.televoip.backend.entity.Author;
import es.televoip.backend.service.implement.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authors")
@ResponseBody
@RequiredArgsConstructor // genera un constructor con cada uno de los atributos final no inicializados
@CrossOrigin(origins = "*") // permitimos todos los orígenes para hacer uso de la APIrest
public class AuthorController extends BaseControllerImpl<Author, AuthorServiceImpl> {

}
