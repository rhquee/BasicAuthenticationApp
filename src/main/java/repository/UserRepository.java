package repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Thinking of Java:
 * Zalecane rzutowanie kontenera na typ w górę (stosowanie ogólniejszego interfejsu)
 * w celu zostawienia furtki dla ewentualnej przyszłej zmiany implementacji, np.:
 * List<Apple> a = new ArrayList<Apple>(); możliwa zamiana na:
 * List<Apple> a = new LinkedList<Apple>();
 */

@Repository
public class UserRepository {

    private Map<String, Object> users = new HashMap<>();


    @PostConstruct
    public void defineUserInRepository() {
        users.put("Joe", new User("Joe", "123"));
        users.put("Jenny", new User("Jenny", "123"));
    }


    public User findByUsername(String username) {
        return (User) users.get(username);
    }
}
