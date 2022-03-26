/*
 *
 *  *  Copyright 2016-17 by Cisco Systems
 *  *  All rights reserved.
 *  *  This software is the confidential and proprietary information
 *  *  of Cisco Systems,  ("Confidential Information").  You
 *  *  shall not disclose such Confidential Information and shall use
 *  *  it only in accordance with the terms of the license agreement
 *  *  you entered into with Cisco Systems.
 *  *
 *
 */
package cisco;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

public class PassphraseEncryptor {
    // The higher the number of iterations the more
    // expensive computing the hash is for us
    // and also for a brute force attack.
    private static final int iterations = 10 * 1024;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    /**
     * Computes a salted PBKDF2 hash of given plaintext passphrase suitable for
     * storing in a database. Empty passphrase are not supported.
     */
    public static String getSaltedHash(String passphrase) throws IllegalArgumentException, InvalidKeySpecException,
            NoSuchAlgorithmException {
        final Random r = new SecureRandom();
        byte[] salt = new byte[saltLen];
        r.nextBytes(salt);
        String a = Base64.encodeBase64String(salt);
        String b = hash(passphrase, salt);
        String x =  a + "$" + b;
        return x;
    }

    /**
     * Checks whether given plaintext passphrase corresponds to a stored salted
     * hash of the passphrase.
     */
    public static boolean check(String passphrase, String stored) throws IllegalArgumentException,
            InvalidKeySpecException, NoSuchAlgorithmException {
        String[] saltAndPass = stored.split("\\$");
        if (saltAndPass.length != 2) {
            return false;
        }
        String hashOfInput = hash(passphrase, Base64.decodeBase64(saltAndPass[0]));
        return hashOfInput.equals(saltAndPass[1]);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String passphrase, byte[] salt) throws IllegalArgumentException, InvalidKeySpecException,
            NoSuchAlgorithmException {
        if (passphrase == null || passphrase.length() == 0) {
            throw new IllegalArgumentException("Empty passphrases are not supported.");
        }
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(passphrase.toCharArray(), salt, iterations, desiredKeyLen));

        // key.get
        return Base64.encodeBase64String(key.getEncoded());

    }

    public static void main(String[] args) {
        try {
            String s = getSaltedHash("Maglev12");
            System.out.println(s);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}