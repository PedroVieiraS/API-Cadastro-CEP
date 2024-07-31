package com.crud.demo.clienteservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.classes.ContaBancaria;
import com.crud.demo.repository.ContaBancariaRepository;

import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancaria> getAll() {
        return contaBancariaRepository.getAll();
    }

    public ContaBancaria getByNumeroConta(String numeroConta) {
        return contaBancariaRepository.findByNumeroConta(numeroConta);
    }

    public ContaBancaria addContaBancaria(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public void deleteContaBancaria(Long id) {
        contaBancariaRepository.deleteById(id);
    }

}
