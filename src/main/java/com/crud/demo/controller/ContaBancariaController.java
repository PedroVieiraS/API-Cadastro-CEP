package com.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.demo.classes.ContaBancaria;
import com.crud.demo.clienteservice.ContaBancariaService;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public ResponseEntity<List<ContaBancaria>> getAll() {
        List<ContaBancaria> contas = contaBancariaService.getAll();
        return ResponseEntity.ok(contas);
    }

    @PostMapping
    public ResponseEntity<ContaBancaria> addContaBancaria(@RequestBody ContaBancaria contaBancaria) {
        ContaBancaria contaSalva = contaBancariaService.addContaBancaria(contaBancaria);
        return ResponseEntity.ok(contaSalva);
    }
}