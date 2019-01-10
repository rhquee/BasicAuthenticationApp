package service.authenticationStrategies;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kfrak on 10.01.2019.
 */
public interface ResourceAccessStrategy {

    boolean canAccessResource(HttpServletRequest request);
}
