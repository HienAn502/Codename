package personal.codename.services;

import personal.codename.domain.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
    User getUserById(Long id);
}
