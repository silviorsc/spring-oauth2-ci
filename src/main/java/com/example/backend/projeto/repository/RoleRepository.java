package com.example.backend.projeto.repository;

import com.example.backend.projeto.entity.Role;
import com.example.backend.projeto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {



}
