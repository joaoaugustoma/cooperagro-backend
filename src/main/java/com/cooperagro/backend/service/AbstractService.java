package com.cooperagro.backend.service;

import br.ueg.prog.webi.api.exception.BusinessException;
import com.cooperagro.backend.annotation.RepositoryName;
import com.cooperagro.backend.exception.SistemaMessageCode;
import com.cooperagro.backend.model.generic.GenericTabela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<TABELA extends GenericTabela, TYPE_PK> {

    @Autowired
    private ApplicationContext appContext;

    public TABELA salvar(TABELA tabela){
        if(validarIdNull(tabela)){
            prepararInclusao(tabela);
        }else {
            prepararEdicao(tabela);
        }

        executarSalvar(tabela);
        depoisSalvar(tabela);
        return tabela;
    }

    public void excluir(TYPE_PK typePk) {
        getRepository().deleteById(typePk);
    }

    public TABELA listarById(TYPE_PK typePk ) {
        Optional<TABELA> tabela = getRepository().findById(typePk);
        if(tabela.isPresent()){
            return tabela.get();
        }else {
            throw new BusinessException(SistemaMessageCode.ERRO_NENHUM_REGISTRO_ENCONTRADO);
        }
    }

    public List<TABELA> listarTudo(){
        List<TABELA> tabelas = getRepository().findAll();

        if(tabelas.isEmpty()){
            throw new BusinessException(SistemaMessageCode.ERRO_NENHUM_REGISTRO_ENCONTRADO);
        }

        return tabelas;
    };

    private void executarSalvar(TABELA tabela) {
        getRepository().save(tabela);
    }

    private boolean validarIdNull(TABELA tabela) {
        return tabela.getIdValue(tabela) == null;
    };

    protected JpaRepository<TABELA, TYPE_PK> getRepository(){
        Class clazz = null;
        String className = this.getClass().getAnnotation(RepositoryName.class).value();
        try {
            clazz = Class.forName("com.ueg.nutshellbackend.application.repository." + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível encontrar o repository: " + className);
        }
        return (JpaRepository<TABELA, TYPE_PK>) appContext.getBean(clazz);
    };

    protected abstract void prepararEdicao(TABELA tabela);

    protected abstract void prepararInclusao(TABELA tabela);

    protected abstract void depoisSalvar(TABELA tabela);

}