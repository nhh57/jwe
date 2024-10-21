package org.example;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Map;

public class hainh {
    public static void main(String[] args) throws Exception {
        // Tạo KeyPair cho thuật toán RSA
        RSAKeyGenerator rsaKeyGenerator = new RSAKeyGenerator();
        PublicKey publicKey = rsaKeyGenerator.readPublicKey("publicKey");
        // Đọc khóa riêng từ file
        PrivateKey privateKey = rsaKeyGenerator.readPrivateKey("privateKey");

        // Lấy khóa công khai và khóa riêng
        System.out.println("Public Key: " + publicKey);
        System.out.println("Private Key: " + privateKey);

        // Tạo nội dung cho JWT (claims)
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject("1234567890")      // ID của người dùng
                .issuer("your-app")         // Ứng dụng phát hành
                .expirationTime(new Date(new Date().getTime() + 60 * 1000)) // Token hết hạn sau 1 phút
                .claim("role", "admin")     // Thêm các claims tùy chỉnh
                .claim("username", "hainh")
                .build();
        System.out.println("claimsSet: " + claimsSet);


        // Tạo Signed JWT
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);
        System.out.println("signedJWT: " + signedJWT);


        // Ký JWT bằng PrivateKey
        JWSSigner signer = new RSASSASigner(privateKey);
        signedJWT.sign(signer);

        JWEHeader header = new JWEHeader.Builder(
                JWEAlgorithm.RSA_OAEP_256,
                EncryptionMethod.A256GCM
        ).contentType("JWT").keyID("VNPAY").build();
        System.out.println("header: " + header);

        // Mã hóa bằng RSA public key
        JWEObject jweObject = new JWEObject(header,new Payload(signedJWT));
        System.out.println("jweObject: " + jweObject);
//
//        // Mã hóa JWE
        jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));

        // Tạo JWE token
        String jweString = jweObject.serialize();
        System.out.println("JWE Token: " + jweString);
// ===============================================================

        // --- Giải mã JWE ---
        // Tạo JWEObject từ chuỗi JWE Token
        JWEObject jweObjectDecrypt = JWEObject.parse(jweString);

        // Giải mã JWE với PrivateKey
        jweObjectDecrypt.decrypt(new RSADecrypter(privateKey));

        // Lấy lại SignedJWT từ JWE
        SignedJWT signedJWTDecrypt = jweObjectDecrypt.getPayload().toSignedJWT();

        // Lấy claims từ JWT
        JWTClaimsSet claims = signedJWTDecrypt.getJWTClaimsSet();
        Map<String, Object> claimsdata = claims.getClaims();

        // In tất cả các claims
        for (Map.Entry<String, Object> entry : claimsdata.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
