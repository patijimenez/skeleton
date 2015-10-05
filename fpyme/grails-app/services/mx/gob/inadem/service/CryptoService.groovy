package mx.gob.inadem.service

import mx.gob.inadem.*
import mx.gob.inadem.exception.*
import java.security.MessageDigest

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import org.apache.commons.codec.binary.Base64



class CryptoService {

  def hashSha256(def stringToEncrypt){
    def messageDigest = MessageDigest.getInstance("SHA-256")
    messageDigest.update(stringToEncrypt.getBytes())
    def encryptedString =  byteArray2Hex(messageDigest.digest())
    encryptedString
  }

  def encrypt(String password, String string) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
      SecretKeySpec secretKey = generateSecretKey(password)

      cipher.init(Cipher.ENCRYPT_MODE, secretKey)

      def encryptedString = Base64.encodeBase64String(cipher.doFinal(string.getBytes("UTF-8")))
      encryptedString
    } catch(Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex)
    }
  }

  def decrypt(String password, String encrypted) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
      SecretKeySpec secretKey = generateSecretKey(password)

      cipher.init(Cipher.DECRYPT_MODE, secretKey)

      def decryptedString = new String(cipher.doFinal(Base64.decodeBase64(encrypted)))
      decryptedString
    } catch(Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex)
    }
  }

  def generateSecretKey(String password) throws Exception {
    byte[] passwordBytes = password.getBytes("UTF-8")

    if(passwordBytes.length != 16) {
      throw new SecurityException("Password should be of 16 bytes length")
    }

    return new SecretKeySpec(passwordBytes, "AES")
  }

  def byteArray2Hex(byte[] bytes) {
    char[] hex = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' ]
    StringBuffer sb = new StringBuffer(bytes.length * 2);
    for(final byte b : bytes) {
      sb.append(hex[(b & 0xF0) >> 4]);
      sb.append(hex[b & 0x0F]);
    }
    return sb.toString();
  }

}