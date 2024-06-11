package com.ueg.cooperagro.business.usuario.repositories;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgricultorRepository  extends JpaRepository<Agricultor, Long> {

    Optional<Agricultor> findByUsuarioId(Long id);
}
