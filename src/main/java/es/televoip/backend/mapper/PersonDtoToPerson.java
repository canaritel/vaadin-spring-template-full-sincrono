package es.televoip.backend.mapper;

import es.televoip.backend.entity.Person;
import es.televoip.backend.entity.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPerson implements IMapper<PersonDto, Person> {
    
    @Override
    public Person map(PersonDto in) {
        Person person = new Person();
        person.setFirstName(in.getFirstName());
        person.setLastName(in.getLastName());
        person.setDni(in.getDni());
        person.setEmail(in.getEmail());
        person.setPhone(in.getPhone());
        person.setDateOfBirth(in.getDateOfBirth());
        person.setImportant(in.isImportant());
        // Añadimos las relaciones
        person.setUserAccess(in.getUserAccess());
        person.setAddress(in.getAddress());
        person.setCity(in.getCity());
        person.setCountry(in.getCountry());
        person.setBooks(in.getBooks());
        
        return person;
    }
    
}
