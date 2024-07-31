package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.demo.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

}

