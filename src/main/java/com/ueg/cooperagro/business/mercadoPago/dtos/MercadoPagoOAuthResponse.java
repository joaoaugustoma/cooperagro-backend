package com.ueg.cooperagro.business.mercadoPago.dtos;

import lombok.Data;

@Data
public class MercadoPagoOAuthResponse {
    private String access_token;
    private String token_type;
    private Long expires_in;
    private String scope;
    private Long user_id;
    private String refresh_token;
    private String public_key;
    private boolean live_mode;
}
