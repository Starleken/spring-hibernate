package by.Starleken.services;

import by.Starleken.entities.User;
import by.Starleken.repositories.interfaces.UserRepository;
import by.Starleken.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RealizationUserService implements UserService {
    private UserRepository userRepository;

    @Autowired
    public RealizationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User entity) {
        return userRepository.create(entity);
    }

    @Override
    public void update(User entity) {
        userRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findUsersSortByComments() {
        List<User> users = userRepository.findAll();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.getComments().size(), o1.getComments().size());
            }
        });

        return users;
    }
}
