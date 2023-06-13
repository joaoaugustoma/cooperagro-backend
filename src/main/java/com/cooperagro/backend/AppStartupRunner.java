package com.cooperagro.backend;

import com.cooperagro.backend.model.Endereco;
import com.cooperagro.backend.model.Usuario;
import com.cooperagro.backend.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    public static final String NONE="none";
    public static final String CREATE_DROP="create-drop";
    public static final String CREATE = "create";
    public static final String UPDATE = "update";

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void initDados(){

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Administrador");
        usuario1.setCpfCpnj("000.000.000-00");
        usuario1.setEmail("admin@admin.com");
        usuario1.setSenha("123456");
        usuario1.setStatus(true);
        usuarioRepository.save(usuario1);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.initDados();
    }
}
