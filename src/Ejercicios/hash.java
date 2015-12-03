package Ejercicios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Created by diego on 03/12/2015.
 */
public class Hash {
    public Hash () {
        String sessionid = "12345";

        byte [] defaultBytes = sessionid.getBytes();
        try{
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest [] = algorithm.digest();

            StringBuffer hexString = new StringBuffer();
            for ( int i = 0; i < messageDigest.length; i++){
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            String foo = messageDigest.toString();
            System.out.println("sessionid  " + sessionid + " md5 version is " + hexString.toString());
            sessionid = hexString + "";
        }
        catch (NoSuchAlgorithmException e) {

        }
    }
}
