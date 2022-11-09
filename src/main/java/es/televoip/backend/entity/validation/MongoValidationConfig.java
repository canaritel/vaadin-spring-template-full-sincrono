package es.televoip.backend.entity.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/*
* Método para la validación de los campos de los documentos, más información en:
* https://bootify.io/mongodb/document-validation-in-spring-boot-mongodb.html
 */
@Configuration
public class MongoValidationConfig {

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener(LocalValidatorFactoryBean factory) {
        return new ValidatingMongoEventListener(factory);
    }
}
