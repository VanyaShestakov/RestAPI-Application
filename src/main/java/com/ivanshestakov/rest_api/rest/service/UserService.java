package com.ivanshestakov.rest_api.rest.service;

import com.ivanshestakov.rest_api.rest.entity.User;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String username);


}
