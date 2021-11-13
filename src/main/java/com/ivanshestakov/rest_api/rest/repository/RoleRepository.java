package com.ivanshestakov.rest_api.rest.repository;

import com.ivanshestakov.rest_api.rest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);

}
