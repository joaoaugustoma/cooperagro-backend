package com.ueg.cooperagro.business.endereco.models.enums;

public enum TipoEnderecoEnum {

    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    RURAL("Rural");

    private String descricao;

    TipoEnderecoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
