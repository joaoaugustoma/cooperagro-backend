package com.cooperagro.backend.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.api.dto.CredencialDTO;
import br.ueg.prog.webi.api.exception.MessageResponse;
import com.cooperagro.backend.dto.UsuarioDTO;
import com.cooperagro.backend.mapper.UsuarioMapper;
import com.cooperagro.backend.model.Usuario;
import com.cooperagro.backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api.base}/usuario")
public class UsuarioController extends CrudController<Usuario, UsuarioDTO, Long, UsuarioMapper, UsuarioService> {

}
