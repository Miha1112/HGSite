package com.galagandevelopment.HGSite.services;

import com.galagandevelopment.HGSite.models.User;
import com.galagandevelopment.HGSite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> findByUsername(String userName) {
      return Optional.ofNullable(userRepository.findByUsername(userName));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    public void addStudent(User teacher, User student) {
        student.setTeacher(teacher);
        save(student);
    }
}
