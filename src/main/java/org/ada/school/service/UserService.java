package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService
{
    User create(User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User updateById( UserDto userDto, String id );


    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);


}
