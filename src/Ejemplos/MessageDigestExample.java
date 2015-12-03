package Ejemplos;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//
// Generate a Message Digest
public class MessageDigestExample {

  public static void main (String[] args) throws Exception {
    //
    // check args and get plaintext
    String text = "Hola que tal amigo";
    byte[] plainText = text.getBytes("UTF8");
    //
    // get a message digest object using the MD5 algorithm
    MessageDigest message = MessageDigest.getInstance("MD5");
    //
    // print out the provider used
    System.out.println( "\n" + message.getProvider().getInfo() );
    //
    // calculate the digest and print it out
    message.update( plainText);
    System.out.println( "\nDigest: " );
    System.out.println( new String( message.digest(), "UTF8") );
    System.out.println(Hex.encodeHex(message.digest()));

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
      System.out.println(Hex.encodeHex(messageDigest));
    }catch (NoSuchAlgorithmException e){

    }
  }
}










