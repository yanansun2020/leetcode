package algorithm;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Base64Test {
    @Test
    public void test() {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println(encodedString);



        String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
        String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
        System.out.println(encodedUrl);

        try {
            byte[]  bytesOfMessage = "abc".getBytes("UTF-8");
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            byte[] theMD5digest = md.digest(bytesOfMessage);
            StringBuilder sb = new StringBuilder(2*theMD5digest.length);
            for(byte b : theMD5digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            System.out.println(sb.toString().length());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
