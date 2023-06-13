package com.cooperagro.backend.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api.base}/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioService usuarioService;

    @Operation(description = "Persiste um usuário no Banco",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = CredencialDTO.class)))),
                    @ApiResponse(responseCode = "403", description = "Proibido",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = MessageResponse.class)))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = MessageResponse.class))))
            })
    @PostMapping(path = "/incluir", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> incluir(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toModelo(usuarioDTO);
        usuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuarioMapper.toDTO(usuario));
    }
}
