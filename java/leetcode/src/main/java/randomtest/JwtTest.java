package randomtest;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    public static void main(String[] args) {
        String token = genToken();
        verifyToken(token);
    }

    public static String genToken() {
        Map<String, Object> headerPayload = new HashMap<>();
        headerPayload.put("typ", "JWT");
        headerPayload.put("alg",  "HS384");

        Map<String, Object> claims = new HashMap<>();
        claims.put("tenantId", "TNT0");
        claims.put("usernmame", "yanan");

        JWTCreator.Builder claimHandler = com.auth0.jwt.JWT.create().withHeader(headerPayload);
        claimHandler.withClaim("tenantId", "TNT0").withClaim("usernmame", "yanan");
        Algorithm alg = Algorithm.HMAC256("secret");
        String s = claimHandler.sign(alg);
        System.out.println(s);
        return s;
    }

    public static void verifyToken(String token) {
        String algorithm = com.auth0.jwt.JWT.decode(token).getHeaderClaim("alg").asString();
        System.out.println(algorithm);
        Algorithm algo = Algorithm.HMAC256("secret");
        JWTVerifier verifier = com.auth0.jwt.JWT.require(algo).build();

        DecodedJWT decodedJWT  = verifier.verify(token);
        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getToken());


    }
}
