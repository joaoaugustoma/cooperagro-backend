package com.ueg.cooperagro.business.endereco.repositories;

import com.ueg.cooperagro.business.endereco.models.Endereco;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByUsuarioEmail(String email);
}
