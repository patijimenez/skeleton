package mx.com.mschool.service

import mx.com.mschool.util.Gpw;
import org.apache.shiro.crypto.hash.Sha256Hash 
import org.apache.shiro.crypto.SecureRandomNumberGenerator
import org.apache.shiro.crypto.hash.format.Shiro1CryptFormat

class PasswordService {
		def rng = new SecureRandomNumberGenerator() 
		def format = new Shiro1CryptFormat()

    def encodePassword(String password) {
				def salt = rng.nextBytes()
				def hash = new Sha256Hash(password, salt, 1024)
				def passwordHash = format.format(hash)

				passwordHash
    }

    def generate(int pwlen) {
      def gpw = new Gpw(8, pwlen)

      gpw.generate()[0]

    }


}
