package com.projet.securite.domain.dto.user;import lombok.AllArgsConstructor;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;import java.io.Serializable;@NoArgsConstructor@AllArgsConstructor@Getter@Setterpublic class TokensDto implements Serializable {    private String access_token;    private String refresh_token;}