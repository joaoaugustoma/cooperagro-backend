package com.ueg.cooperagro.business.usuario.repositories;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorRepository  extends JpaRepository<Agricultor, Long> {

}
