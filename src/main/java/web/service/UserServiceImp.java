package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repositories.UserRepository;
import web.repositories.UserRepositoryImp;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserRepositoryImp userRepositoryImp;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.add(user);
    }


    @Transactional
    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.edit(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        return userRepository.getById(id);
    }
}

