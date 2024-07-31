package com.crud.demo.repository;

import com.crud.demo.classes.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    ContaBancaria findByNumeroConta(String numeroConta);
    List<ContaBancaria> getAll();
}
