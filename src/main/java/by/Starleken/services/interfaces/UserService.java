package by.Starleken.services.interfaces;

import by.Starleken.entities.User;
import by.Starleken.interfaces.CRUD;

import java.util.List;

public interface UserService extends CRUD<User, Long> {
    public List<User> findUsersSortByComments();
}
