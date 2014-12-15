import java.io.*;
import java.security.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Check the argument
        if (args.length < 2) {
            System.out.println("No input\nUsage: java Main [plain text] [key size]");
            System.exit(0);
        }

        // Get key size from arguments
        int keySize = Integer.parseInt(args[1]);

        // Check the key size. To use RSA encryption, the key size should be bigger than 512
        if (keySize < 512) {
            System.out.println("Key size should be bigger than 512, not " + keySize);
            System.exit(0);
        }

        RSA rsa = new RSA();
        RsaGenerateKey rsaGenerateKey = new RsaGenerateKey(keySize);

        // Generate keys        
        Key rsaPublicKey = rsaGenerateKey.generatePublicKey();
        Key rsaPrivateKey = rsaGenerateKey.generatePrivateKey();

        // Get a plain text from arguments
        String plain = args[0];

        // Encrypt
        byte[] encryptedPlainByte = rsa.encrypt(rsaPublicKey, plain);
        String encryptedPlainText = new String(encryptedPlainByte);

        // Decrypt
        byte[] decryptedByte = rsa.decrypt(rsaPrivateKey, encryptedPlainByte);
        String decryptedText = new String(decryptedByte);

        // Save into output.txt
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write("Plain text: " + plain);
        bufferedWriter.newLine();
        bufferedWriter.write("Encryped text: " + encryptedPlainText);
        bufferedWriter.newLine();
        bufferedWriter.write("Length: " + encryptedPlainText.length());
        bufferedWriter.newLine();
        bufferedWriter.write("Decrypted text: " + decryptedText);
        bufferedWriter.close();
    }
}
