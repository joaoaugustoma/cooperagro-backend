package com.cooperagro.backend.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import com.cooperagro.backend.dto.UsuarioDTO;
import com.cooperagro.backend.mapper.UsuarioMapper;
import com.cooperagro.backend.model.Usuario;
import com.cooperagro.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api.base}/usuario")
public class UsuarioController extends CrudController<Usuario, UsuarioDTO, Long, UsuarioMapper, UsuarioService> {

}
