package org.example;

import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.RSADecrypter;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JWEExample {
    public static final String TOKEN = "eyJraWQiOiJWTlBBWSIsImN0eSI6IkpXVCIsImVuYyI6IkEyNTZHQ00iLCJhbGciOiJSU0EtT0FFUC0yNTYifQ.ZwMHYhE_shmBL0mmE-WsfsZtHGtv0ek0Fo3C-qVFGpF2Xd3hOryzNjFmAJ-l6sHQa6fOV9Mui7MckWrr3GAj4E7-0qKncZ2D3bEySDq-cfJHGPpMEO5DUtpud3z3xjJ2VPEVcz88wM1Fsgebr57FDVrEb9WYNlfl7j00ZPTpQSKR4aMjwuzoBDWaxGIeTOns0BHd3DxiydnR-7MDmXzqXJ2hdGcFTCPf-yOnCnXYROrWZkbxAc-Ojr2e0qOlMrLtc_UdwMV6S2ezC98aQebogtXxZuoJxsWBr-7go3UzwjJ_ClKw8xe_fCrTagtf0wdLU1YWoqB5OsD2pWkaWJcrDA.cnWKQMzn0y-sBIHL.3GjL4NZin6vuVQ0oP7hKO4JNy7a1XtYrp3GmH1i3cJE_AUO1-Yf1_C2undBYIZiu0q5MF2OC5FL6m_abLhm_7ioksEdiyBOe5kLTZbKUaYsb1cqosI2e0mHJ_FBaETNVZFQ6QTBNAB-70gxCpLHTtqYZUHHp_TlC9j-QxmU2ukiEcuvOy8HeN2slwSDHKUUo2zOL5sDAK_nCVsAqY2PnK4irVWxnb3T9yST4ilDuCGaZPoH03TToy6LHq6Uz5zXr12UbFAhM-Kunyxk2N3sqsz9PmmKqfHrIBiEDz4JVcD2vdQzxWBBymRdFWe8iluilrERHUHrYCW1SmznpVpyj1LLqmAbg5f1IWR5lhxoAvGYq5Tgli_pBUhYl5REXMSRAvFsoRlhC_5obABfSak13fJGy0o-VBL_qUqO79Fe1HfoTBPu3_GDaMKFxjo-AroIWN14DYavZjDYFpM4ohaweX4mwYA0qBkj5sF2KjAIVBwqKL5EeXE40yWrwjxF07CxHLuUpBn-qpGmfRr7P1jCrce1R3VB2LpqYdeQoLsG3MZE6MKMOtNaTRGe2uSeQWvxbR2F2wMMnxGDNpaoy4nRybChkWvXg4DtBHsKeVj7YfeCP6zYBXHkHxKFfigADAra6XL4.4Me0RvbSrfTCx2fPW34mRg";

    public static void main(String[] args) throws Exception {
        // Tạo cặp khóa RSA chỉ một lần
        PublicKey publicKey = RSAKeyGenerator.readPublicKey("src/main/resources/publicKey");
        // Đọc khóa riêng từ file
        PrivateKey privateKey = RSAKeyGenerator.readPrivateKey("src/main/resources/privateKey");
        System.out.println("Public Key: " + publicKey);
        System.out.println("Private Key: " + privateKey);

        // Giải mã JWE (ở phía nhận, sử dụng khóa riêng)
        JWEObject parsedJWE = JWEObject.parse(TOKEN);
        parsedJWE.decrypt(new RSADecrypter(privateKey));

        System.out.println("JWE đã được giải mã: " + parsedJWE.getPayload().toString());
    }


}
