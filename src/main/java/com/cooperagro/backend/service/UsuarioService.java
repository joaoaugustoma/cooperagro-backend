package com.cooperagro.backend.service;

import com.cooperagro.backend.annotation.RepositoryName;
import com.cooperagro.backend.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@RepositoryName("UsuarioRepository")
public class UsuarioService extends AbstractService<Usuario, Long> {

    @Override
    protected void prepararEdicao(Usuario tabela) {

    }

    @Override
    protected void prepararInclusao(Usuario tabela) {

    }

    @Override
    protected void depoisSalvar(Usuario tabela) {

    }
}
