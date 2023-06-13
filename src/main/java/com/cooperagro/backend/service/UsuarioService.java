package com.cooperagro.backend.service;

import br.ueg.prog.webi.api.service.CrudService;
import com.cooperagro.backend.annotation.RepositoryName;
import com.cooperagro.backend.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@RepositoryName("UsuarioRepository")
public class UsuarioService implements CrudService<Usuario, Long> {


    @Override
    public Usuario incluir(Usuario ENTIDADE) {
        return null;
    }

    @Override
    public Usuario alterar(Usuario ENTIDADE, Long id) {
        return null;
    }

    @Override
    public Usuario excluir(Long id) {
        return null;
    }

    @Override
    public Usuario obterPeloId(Long id) {
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        return null;
    }
}
