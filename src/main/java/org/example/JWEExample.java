//package org.example;
//
//import com.nimbusds.jose.JWEObject;
//import com.nimbusds.jose.crypto.RSADecrypter;
//import com.nimbusds.jose.shaded.json.JSONObject;
//
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.util.Map;
//
//public class JWEExample {
//    public static final String TOKEN = "eyJraWQiOiJWTlBBWSIsImN0eSI6IkpXVCIsImVuYyI6IkEyNTZHQ00iLCJhbGciOiJSU0EtT0FFUC0yNTYifQ.ae5piQmhBej36v92yAZkC2qdL0uvvA4dTg4plobuRqV4ofOGCJ8AHBcDN3ZCshgM2rMzWulWrMUN0rur-YaDu5iz1tOYpiOAIoaajBDZNUBI5GYPyw3r45hd9ajN9JrPUa8Hz5voQuQo0Dt_vs_kO072DVhrqCRwCO2NC6rJ3VSQsNNUOz_eQVTDx_VGX0yUbThOOHSAW8TBp5MEWGUA20HrrCM0OqzIGCI-rBeWZTYkuUhDQw8HseMu5hhFa5FyqX-enaeSzJRUSjyTTXNyPp-ANDuwb72GxRKh7VZaEfEMVnk_anDq5Prj5VSs18v2_bkC-lQNckNF5TXrKiS5-w.9mOntj7MqFCd9A4s.bgg-28AolsXCrfSwk9kbBN_xxccRwqPEmbsUi_v4rXhnfSFcLriC9XKDq_GuXJp6Cm8y4O8j1LBaNHhE1Lai1n9aZPEvtmTI2eOhFfjJ1eUsmcwj1Iq-LjGpabk2c9VLUde3GTW9z29AnkByIw9TdTinNltAeHCRj8BtLKFYOEuxX5IdnxNiPx_3wMpXc-88fILm_W7NvD5b76kDxoiALpJCwSGwmQFBj9YGmsuAHpKQaDCm8VxdqOEEe-_8oFKAFg0cWPprm8doyBdBgt1gbvVDD6QoC-g9_bIOOrFr0hHtzVdChIUmN64R4WP43Q4bZ3KWny3O1ApTnwzYCFamx32-_hkcJGr6iWOx6HcluB4xRFi7EdN_yXyoANK5-9RK_16aUBqj593mK-CJHj1u_umxIWsXue_TTBjEUMe-BQQHNWgpyUD9MBPdq5unTjvHKswsuJTRp0uDFWZrxVxadipj-udWx3SSM9zlfJ1O34IXWghEB-YoKSnCUnzpcj0Dtpv92PajemlcPSkK3wMYV12UBGKa-OgMBB_YNhyLCzLpnffcV_XJhtn_xaigYkIAhI-OQW2Dk8YxoMFsNrsMn_cncvNiBCJlnBdwUHv3_bH2eoGM_6eTsHINKVJ83NzMp6A.C0u3mobkg2p1_gVrLsytrg";
//
//    public static void main(String[] args) throws Exception {
//        // Tạo cặp khóa RSA chỉ một lần
//        PublicKey publicKey = RSAKeyGenerator.readPublicKey("publicKey");
//        // Đọc khóa riêng từ file
//        PrivateKey privateKey = RSAKeyGenerator.readPrivateKey("privateKey");
//        System.out.println("Public Key: " + publicKey);
//        System.out.println("Private Key: " + privateKey);
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
