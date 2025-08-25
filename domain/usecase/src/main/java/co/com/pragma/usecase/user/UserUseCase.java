package co.com.pragma.usecase.user;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

// Methods you want to expose
// Call to the port that expose the required functionality
// Here you can implement business logic if needed
@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserByIdNumber(Long idNumber) {
        return userRepository.getUserByIdNumber(idNumber);
    }

    public User editUser(User user) {
        return userRepository.editUser(user);
    }

    public void deleteUser(Long idNumber) {
        userRepository.deleteUser(idNumber);
    }
}
