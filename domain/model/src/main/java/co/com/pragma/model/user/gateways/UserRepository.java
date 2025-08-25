package co.com.pragma.model.user.gateways;

import co.com.pragma.model.user.User;
import java.util.List;

// Here you can define the methods that an external adapter must implement to interact with the User model
public interface UserRepository {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserByIdNumber(Long idNumber);
    User editUser(User user);
    void deleteUser(Long idNumber);
}
