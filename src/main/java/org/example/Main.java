//package org.example;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Tạo KeyPairGenerator cho thuật toán RSA
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            keyPairGenerator.initialize(2048); // Độ dài khóa (2048 bit)
//
//            // Tạo cặp khóa (KeyPair)
//            KeyPair keyPair = keyPairGenerator.generateKeyPair();
//
//            // Lấy khóa công khai và khóa riêng
//            PublicKey publicKey = keyPair.getPublic();
//            PrivateKey privateKey = keyPair.getPrivate();
//
//            // Xuất khóa công khai ra file
//            try (FileOutputStream publicKeyFile = new FileOutputStream("publicKey")) {
//                ObjectOutputStream publicKeyOut = new ObjectOutputStream(publicKeyFile);
//                publicKeyOut.writeObject(publicKey);
//                publicKeyOut.close();
//                System.out.println("Public Key saved to publicKey file.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // Xuất khóa riêng ra file
//            try (FileOutputStream privateKeyFile = new FileOutputStream("privateKey")) {
//                ObjectOutputStream privateKeyOut = new ObjectOutputStream(privateKeyFile);
//                privateKeyOut.writeObject(privateKey);
//                privateKeyOut.close();
//                System.out.println("Private Key saved to privateKey file.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}