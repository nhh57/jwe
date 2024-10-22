//package org.example;
//
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.util.HashMap;
//import java.util.Map;
//
//public class CreateJWE {
//    public static void main(String[] args) throws Exception {
//        // Tạo KeyPair cho thuật toán RSA
//        RSAKeyGenerator rsaKeyGenerator = new RSAKeyGenerator();
//        PublicKey publicKey = RSAKeyGenerator.readPublicKey("publicKey");
//        PrivateKey privateKey = RSAKeyGenerator.readPrivateKey("privateKey");
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", "admin");
//        claims.put("username", "hainh");
//        String jwetoken = rsaKeyGenerator.CreateJWE(privateKey, publicKey, "1234567890", "your-app", 60 * 1000, claims);
//        System.out.println("jwetoken: " + jwetoken);
//        // Giải mã JWE, không phải JWT
//        Map<String, Object> data = RSAKeyGenerator.SolveJWE(privateKey, jwetoken);  // Phải truyền tokenJWE
//        for (Map.Entry<String, Object> entry : data.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//    }
//}
