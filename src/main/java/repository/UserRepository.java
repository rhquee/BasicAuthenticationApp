package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kfrak on 15.12.2018.
 */

//tutaj będą przechowywane dane użytowników
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String userName);
}
