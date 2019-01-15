package repository;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kfrak on 14.01.2019.
 */
public class UserDTOTest {
    @Test
    public void getPassword() throws Exception {
        UserDTO user = new UserDTO();
        user.setUsername("Joey");
        user.setPassword("456");
        Assert.assertEquals("456", user.getPassword());
        Assert.assertEquals("Joey", user.getUsername());
    }
}