package es.televoip;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import es.televoip.backend.entity.audit.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@EnableAsync
@PWA(name = "Async", shortName = "Async")
@JsModule("@vaadin/vaadin-lumo-styles/utility.js")
@CssImport(value = "./views/main/main-view.css", include = "lumo-utility")
@Theme(value = "myapptopmenu")
@NpmPackage(value = "line-awesome", version = "1.3.0")
@Push
@EnableMongoAuditing // Anotación para auditar fecha de creación y modificación de los documentos
public class Application implements AppShellConfigurator {

    @Bean
    public AuditorAware<String> myAuditorProvider() {
        return new AuditorAwareImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
