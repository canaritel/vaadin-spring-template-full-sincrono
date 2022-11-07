package es.televoip.backend.entity.audit;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/*
*** Más información sobre Auditable en este enlace:
*** https://medium.com/codex/spring-data-mongodb-auditing-b4a874442a6
 */
public class AuditorAwareImpl implements org.springframework.data.domain.AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getName);
    }

}
