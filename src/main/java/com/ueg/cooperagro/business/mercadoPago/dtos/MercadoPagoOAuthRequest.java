package com.ueg.cooperagro.business.mercadoPago.dtos;

import lombok.Data;

@Data
public class MercadoPagoOAuthRequest {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String code;
    private String redirect_uri;
    private String refresh_token;
    private boolean test_token;
}
