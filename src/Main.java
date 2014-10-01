import java.security.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		RSA rsa = new RSA();
		RsaGenerateKey rsaGenerateKey = new RsaGenerateKey();
		
		Key rsaPublicKey = rsaGenerateKey.generatePublicKey();
		Key rsaPrivateKey = rsaGenerateKey.generatePrivateKey();
		
		String plain = "Hello World!";
		System.out.println("Plain text: " + plain + "\n" + plain.length());
	
		byte[] encryptedPlainByte = rsa.encrypt(rsaPublicKey, plain);
		String encryptedPlainText = new String(encryptedPlainByte);

        System.out.println("Encrypted Plain Text: " + encryptedPlainText + "\n" + encryptedPlainText.length());

		byte[] decryptedByte = rsa.decrypt(rsaPrivateKey, encryptedPlainByte);
		String decryptedText = new String(decryptedByte);
        System.out.println("Decrypted text: " + decryptedText);
	}
}
