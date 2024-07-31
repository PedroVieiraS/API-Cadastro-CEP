package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.demo.classes.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>  {
}
