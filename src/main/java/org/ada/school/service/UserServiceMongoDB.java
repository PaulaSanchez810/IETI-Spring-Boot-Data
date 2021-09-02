package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

//@Service
//@Component
public class UserServiceMongoDB implements UserService
{

    private final UserRepository userRepository;


    public UserServiceMongoDB(@Autowired UserRepository userRepository)
    {

        this.userRepository = userRepository;
    }

    @Override
    public User create(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User findById( String id )
    {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
         if ( userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
         }
         return false;
    }

    @Override
    public User updateById(UserDto userDto, String id )
    {

        if ( userRepository.existsById(id)){
            User user = userRepository.findById(id).get();
            user.update(userDto);
            userRepository.save(user);
            return user;
        }
        return null;

    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return userRepository.findUsersWithNameOrLastNameLike(queryText);

    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findUsersCreatedAfter(startDate);

    }
}

