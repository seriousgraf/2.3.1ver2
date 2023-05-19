package web.repositories;

import web.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    void add(User user);

    void delete(int id);

    void edit(User user);

    User getById(int id);
}
