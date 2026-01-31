package com.example.correct.Easy.infra.security.validation;

import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.GetVersionTokenByIdContract;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.infra.exception.typo.secundaries.security.GenericSecurityException;
import com.example.correct.Easy.infra.exception.typo.secundaries.security.TokenExpiredException;
import com.example.correct.Easy.infra.exception.typo.secundaries.security.TokenSignatureInvalidException;
import com.example.correct.Easy.infra.exception.typo.secundaries.security.VersionTokenNotEqualsException;
import com.example.correct.Easy.infra.security.tokens.GenerateKeySecret;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

@Component
public class ValidateToken{

    private final GenerateKeySecret keySecret;
    private final GetVersionTokenByIdContract getVersionToken;

    public ValidateToken(GenerateKeySecret keySecret, GetVersionTokenByIdContract getVersionToken) {
        this.keySecret = keySecret;
        this.getVersionToken = getVersionToken;
    }

    private Claims validateTokenBasic(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(keySecret.execute())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (ExpiredJwtException e){
            throw new TokenExpiredException("o token está expirado. por favor logue novamente para prosseguir.");
        }catch (SignatureException e){
            throw new TokenSignatureInvalidException("a assinatura do token está invalida. por favor logue novamente para prosseguir.");
        }catch (Exception e){
            throw new GenericSecurityException("não foi possível validar o token pois: "+e.getMessage());
        }

    }

    public void execute(String token){
        Claims tokenCorrect=validateTokenBasic(token);
        Integer versionTokenInPayload=tokenCorrect.get("versionToken",Integer.class);
        Long idUser=tokenCorrect.get("id",Long.class);

        VersionTokenDomain versionTokenRegistered=getVersionToken.execute(idUser);

        if (!versionTokenRegistered.getTokenVersion().equals(versionTokenInPayload)){
            throw new VersionTokenNotEqualsException("a versão do token não é a mais atual. por favor efetue novamente o login e insira " +
                    "o token retornado no corpo da resposta, no header Authorization");
        }

    }
}
