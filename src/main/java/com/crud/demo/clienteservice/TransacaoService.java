package com.crud.demo.clienteservice;

import org.springframework.stereotype.Service;

import com.crud.demo.repository.TransacaoRepository;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }
}
