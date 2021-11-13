package com.ivanshestakov.rest_api.rest.repository;

import com.ivanshestakov.rest_api.rest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
