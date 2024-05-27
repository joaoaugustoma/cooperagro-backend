package com.ueg.cooperagro.business.endereco.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TipoEnderecoEnum fromDescricao(String descricao) {
        for (TipoEnderecoEnum tipo : TipoEnderecoEnum.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de endereço inválido: " + descricao);
    }
}
