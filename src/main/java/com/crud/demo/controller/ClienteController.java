package com.crud.demo.controller;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.crud.demo.classes.Cliente;
import com.crud.demo.classes.Endereco;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    // Buscar todos os clientes - getAll
    @GetMapping
    public String getAll() {
        if (Cliente.clientes.isEmpty()) {
            return "Não há clientes cadastrados.";
        } else {
            String resposta = Cliente.clientes.toString();
            return resposta;
        }
    }

    // Criar um cliente - create
    @PostMapping
    public String create(@RequestBody Cliente cliente) {
        Endereco endereco = Endereco.getEnderecoByCep(cliente.getEndereco().getCep());
        cliente.setEndereco(endereco);
        
        Cliente.clientes.add(cliente);
        return "Cliente cadastrado com sucesso!";
    }

    // Buscar um cliente por id - getById
    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    // Atualizar um cliente - update
    @PutMapping("/{id}")
    public String update(@PathVariable UUID id, @RequestBody Cliente clienteAtualizado) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                cliente.setEndereco(clienteAtualizado.getEndereco());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
                // Atualize outros campos conforme necessário
                return "Cliente atualizado com sucesso!";
            }
        }
        return "Cliente não encontrado.";
    }
    // Deletar um cliente - delete
    public String delete(@PathVariable UUID id) {
        List<Cliente> clientesRemover = Cliente.clientes.stream()
            .filter(cliente -> cliente.getId().equals(id))
            .collect(Collectors.toList());
        
        if (!clientesRemover.isEmpty()) {
            Cliente.clientes.removeAll(clientesRemover);
            return "Cliente deletado com sucesso!";
        }
        return "Cliente não encontrado.";
    }
}
