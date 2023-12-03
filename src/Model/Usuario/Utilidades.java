package Model.Usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilidades {
 public static String encriptarContrasena(String contrasena) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contrasena.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }}
