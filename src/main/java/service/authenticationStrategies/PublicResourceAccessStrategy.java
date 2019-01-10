package service.authenticationStrategies;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Component
public class PublicResourceAccessStrategy implements ResourceAccessStrategy {

    List<String> allowedURIs = Arrays.asList("/resource/", "/login");

    @Override
    public boolean canAccessResource(HttpServletRequest request) {
        return allowedURIs.stream().anyMatch(uri -> request.getRequestURI().startsWith(uri));
    }
}
