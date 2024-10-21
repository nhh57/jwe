package org.example;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
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

    public static Map<String, Object> SolveJWE(PrivateKey privateKey, String JWEToken) throws JOSEException, ParseException {
        // Tạo JWEObject từ chuỗi JWE Token
        JWEObject parsedJWE = JWEObject.parse(JWEToken);
        // Giải mã JWE với PrivateKey
        parsedJWE.decrypt(new RSADecrypter(privateKey));
        // Lấy lại SignedJWT từ JWE
        SignedJWT signedJWTDecrypt = parsedJWE.getPayload().toSignedJWT();
        // Lấy claims từ JWT
        JWTClaimsSet claims = signedJWTDecrypt.getJWTClaimsSet();
        return claims.getClaims();
    }


    // Method for creating JWE with JSONObject as payload
    public String CreateJWE(PublicKey publicKey, JSONObject data) throws JOSEException {
        JWEHeader header = new JWEHeader.Builder(
                JWEAlgorithm.RSA_OAEP_256,
                EncryptionMethod.A256GCM
        ).contentType("JWT").build();

        Payload payload = new Payload(data);
        JWEObject jweObject = new JWEObject(header, payload);
        jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));
        return jweObject.serialize();
    }

    // Method for creating JWE with byte array as payload
    public String CreateJWE(PublicKey publicKey, byte[] data) throws JOSEException {
        JWEHeader header = new JWEHeader.Builder(
                JWEAlgorithm.RSA_OAEP_256,
                EncryptionMethod.A256GCM
        ).contentType("JWT").build();

        Payload payload = new Payload(data);
        JWEObject jweObject = new JWEObject(header, payload);
        jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));
        return jweObject.serialize();
    }

    public String CreateJWE(PublicKey publicKey, String data) throws JOSEException {
        JWEHeader header = new JWEHeader.Builder(
                JWEAlgorithm.RSA_OAEP_256,
                EncryptionMethod.A256GCM
        ).contentType("String").build();

        Payload payload = new Payload(data);
        JWEObject jweObject = new JWEObject(header, payload);
        jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));
        return jweObject.serialize();
    }

    public String CreateJWE(PublicKey publicKey, SignedJWT data) throws JOSEException {
        JWEHeader header = new JWEHeader.Builder(
                JWEAlgorithm.RSA_OAEP_256,
                EncryptionMethod.A256GCM
        ).contentType("JWT").build();

        Payload payload = new Payload(data);
        JWEObject jweObject = new JWEObject(header, payload);
        jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));
        return jweObject.serialize();
    }

}
