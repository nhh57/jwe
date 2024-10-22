//package org.example;
//
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.util.Map;
//
//public class JWEExample {
//    public static final String TOKEN = "eyJjdHkiOiJTdHJpbmciLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.opqfiHhZRGVPcODj-R7pOSh_351yURCdWyQzhVkV4fkRXyvmGIJk7Pv50sPiNXcqoCYQQ67Wt5CL0BwFojTksyJnEWAKm54Qucdo1l1K5MP_TYYGyr5rjOUIa-128DlWPKn3Dq-QeDMVForhENpSKACWEBFK-ABT4fFI8qMdh8_qjOQS3pLP1htMriYXQ1qUr6EDriIlmdcyGKXnu8YXCK60-XrlysjWMP90DHqPFtU7qG2rr2SbuhjYHxruMWZSbN-s67Y4ihHcACGXqd-WQroJGP3p2T6vRf2NMcHIVetp-pl4_gGoJ09r2VABW3guL9SoEBvkmb4u7TA16aWNZg.hRpldBtY0qHjh_DN.eylLk4Un-k7kT173XJRf7Dx6_CX2v6Izx0w4JOaZiZBd8UI.mo9FDMgu20kTUvZBMZcjCA";
//
//    public static void main(String[] args) throws Exception {
//        // Tạo cặp khóa RSA chỉ một lần
//        PublicKey publicKey = RSAKeyGenerator.readPublicKey("publicKey");
//        // Đọc khóa riêng từ file
//        PrivateKey privateKey = RSAKeyGenerator.readPrivateKey("privateKey");
//
//        // Giải mã JWE (ở phía nhận, sử dụng khóa riêng)
////        JWEObject parsedJWE = JWEObject.parse(TOKEN);
////        parsedJWE.decrypt(new RSADecrypter(privateKey));
////        System.out.println("JWE đã được giải mã: " + parsedJWE.getPayload().toString());
//
//        Map<String, Object> data = RSAKeyGenerator.SolveJWE(privateKey, TOKEN);
//        // Lấy dữ liệu từ Payload
//        for (Map.Entry<String, Object> entry : data.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//    }
//}
