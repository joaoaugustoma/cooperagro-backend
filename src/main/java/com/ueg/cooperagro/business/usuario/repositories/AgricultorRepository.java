package com.ueg.cooperagro.business.usuario.repositories;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AgricultorRepository  extends JpaRepository<Agricultor, Long> {

    Optional<Agricultor> findByUsuarioId(Long id);

    @Query("SELECT a.id FROM Agricultor a WHERE a.usuario.email = ?1")
    Long getAgricultorIdByEmail(String email);
}
