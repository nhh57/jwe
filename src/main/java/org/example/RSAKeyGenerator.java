package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.*;

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
}
