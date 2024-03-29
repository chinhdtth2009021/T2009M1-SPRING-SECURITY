package com.example.t2009m1springsecurity.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.t2009m1springsecurity.entity.Account;

import java.util.Date;

public class JwtUtil {
    public static Algorithm algorithm;
    private static JWTVerifier verifier;
    /*this is jwt secret key use to encode jwt token only backend server hold this key
     * if an attacker know this key his can modify jwt token in the right way to grant access to api
     */
    public static String JWT_SECRET_KEY = "secret-changed";
    //some time units constant
    public static final int ONE_SECOND = 1000;
    public static final int ONE_MINUTE = ONE_SECOND * 60;
    public static final int ONE_HOUR = ONE_MINUTE * 60;
    public static final int ONE_DAY = ONE_HOUR * 24;
    public static final String ROLE_CLAIM_KEY = "role";
    private static final String DEFAULT_ISSUER = "T2009M1";

    public static Algorithm getAlgorithm() {
        if (algorithm == null) {
            algorithm = Algorithm.HMAC256(JWT_SECRET_KEY.getBytes());
        }
        return algorithm;
    }

    public static JWTVerifier getVerifier() {
        if(verifier == null) {
            verifier = JWT.require(getAlgorithm()).build();
        }
        return verifier;
    }

    public static DecodedJWT getDecodedJwt(String token){
        DecodedJWT decodedJWT = getVerifier().verify(token);
        return decodedJWT;
    }

    public static String generateToken(String subject, String role, String issuer, int expireAfter) {
        if(role == null || role.length() == 0) {
            return JWT.create()
                    .withSubject(subject)
                    .withExpiresAt(new Date(System.currentTimeMillis() + expireAfter))
                    .withIssuer(issuer)
                    .sign(getAlgorithm());
        }
        return JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + expireAfter))
                .withIssuer(issuer)
                // when role n -> n user
                //.withClaim(JwtUtil.ROLE_CLAIM_KEY, user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                //when role n -> 1 user
                .withClaim(JwtUtil.ROLE_CLAIM_KEY, role) //get first role in Authorities
                .sign(getAlgorithm());
    }

    public static String generateTokenByAccount(Account account, int expireAfter) {
        return JWT.create()
                .withSubject(String.valueOf(account.getId()))
                .withExpiresAt(new Date(System.currentTimeMillis() + expireAfter))
                .withIssuer(DEFAULT_ISSUER)
                // when role n -> n user
                //.withClaim(JwtUtil.ROLE_CLAIM_KEY, user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                //when role n -> 1 user
                .withClaim(JwtUtil.ROLE_CLAIM_KEY, account.getRole() == 1 ? "ADMIN" : "USER") //get first role in Authorities
                .withClaim("username", account.getUsername()) //get first role in Authorities
                .sign(getAlgorithm());
    }
}