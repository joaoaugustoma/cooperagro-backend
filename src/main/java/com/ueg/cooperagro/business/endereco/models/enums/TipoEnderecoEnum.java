package com.ueg.cooperagro.business.endereco.models.enums;

import lombok.Getter;

@Getter
public enum TipoEnderecoEnum {

    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    RURAL("Rural");

    private final String descricao;

    TipoEnderecoEnum(String descricao) {
        this.descricao = descricao;
    }

}
