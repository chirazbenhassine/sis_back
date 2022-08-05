package com.projet.securite.authUser.security;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JWTUTIL {
    public static final byte[] SECRET = "secret.uyzgdy.sdhsjgjs.dschjsdgcusd".getBytes();
    public static final String AUTH_HEADER = AUTHORIZATION;
    public static final String PREFIX = "Bearer ";
    public static  final int EXPIRE_ACCESS_TOKEN = 1000 * 60 * 60 *10000;
    public static  final int EXPIRE_REFRESH_TOKEN = 10000 * 60 *1000;



}
