package cisco;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
public class SecureUtil {
    public static String getSecurePassword(String password, byte[] salt) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }




    public static void main(String[] args) throws NoSuchAlgorithmException {

        // same salt should be passed
        byte[] salt = getSalt();
        String password1 = getSecurePassword("Password", salt);
        String password2 = getSecurePassword("Password", salt);


        String sha256hex = Hashing.sha256()
            .hashString("Password", StandardCharsets.UTF_8)
            .toString();

        String a = Integer.toString((1 & 0xff) + 0x100, 16);
        System.out.println(a);


        System.out.println(" Password 1 -> " + password1);
        System.out.println(" Password 2 -> " + sha256hex);
        if (password1.equals(password2)) {
            System.out.println("passwords are equal");
        }
    }
}
