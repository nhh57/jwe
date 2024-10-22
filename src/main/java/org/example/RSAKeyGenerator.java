package org.example;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Map;

public class RSAKeyGenerator {

    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Kích thước khóa 2048 bit
        return keyGen.generateKeyPair();
    }

    // Phương thức đọc khóa công khai từ file
    public static PublicKey readPublicKey(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (PublicKey) ois.readObject();
        }
    }

    // Phương thức đọc khóa riêng từ file
    public static PrivateKey readPrivateKey(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (PrivateKey) ois.readObject();
        }
    }

    public static Map<String, Object> SolveJWE(PrivateKey privateKey, String JWEToken) throws Exception {
        // Tạo JWEObject từ chuỗi JWE Token
        JWEObject jweObject = JWEObject.parse(JWEToken);
        // Giải mã JWE với PrivateKey
        jweObject.decrypt(new RSADecrypter(privateKey));

        String payload = jweObject.getPayload().toString();

        SignedJWT signedJWT = SignedJWT.parse(payload);

        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

        return claimsSet.getClaims();
    }

    public String CreateJWE(PrivateKey privateKey, PublicKey publicKey, String subject, String issuer, long expirationTimeInMillis, Map<String, Object> additionalClaims) throws Exception {
        JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
                .subject(subject)
                .issuer(issuer)
                .expirationTime(new Date(new Date().getTime() + expirationTimeInMillis));

        // Thêm các claim từ Map
        if (additionalClaims != null) {
            additionalClaims.forEach(builder::claim);
        }
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), builder.build());

        // Ký JWT bằng PrivateKey
        JWSSigner signer = new RSASSASigner(privateKey);
        signedJWT.sign(signer);


        JWEHeader header = new JWEHeader.Builder(
                JWEAlgorithm.RSA_OAEP_256,
                EncryptionMethod.A256GCM
        ).contentType("JWT").build();
        System.out.println("header: " + header);

        JWEObject jweObject = new JWEObject(header, new Payload(signedJWT));
        jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));
        String jweString = jweObject.serialize();
        return jweString;
    }
}
