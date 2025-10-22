package util;

import java.security.MessageDigest;

import javax.management.RuntimeErrorException;

public class Funcoes {
    
    public static String gerarHashSH256(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeErrorException(e);
        }
    }
}
