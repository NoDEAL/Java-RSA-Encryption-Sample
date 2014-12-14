import java.io.*;
import java.security.*;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("No input\nUsage: java Main [plain text]");
            System.exit(0);
        }

        RSA rsa = new RSA();
        RsaGenerateKey rsaGenerateKey = new RsaGenerateKey();
        
        Key rsaPublicKey = rsaGenerateKey.generatePublicKey();
        Key rsaPrivateKey = rsaGenerateKey.generatePrivateKey();
        
        String plain = args[0];
    
        byte[] encryptedPlainByte = rsa.encrypt(rsaPublicKey, plain);
        String encryptedPlainText = new String(encryptedPlainByte);
        byte[] decryptedByte = rsa.decrypt(rsaPrivateKey, encryptedPlainByte);
        String decryptedText = new String(decryptedByte);

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
