import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RsaGenerateKey {

    KeyPairGenerator mKeyPairGenerator;
    KeyPair mKeyPair;
    KeyFactory mKeyFactory;

    public RsaGenerateKey(int keySize) throws NoSuchAlgorithmException {
        mKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // The bigger is slower and stronger.
        mKeyPairGenerator.initialize(keySize);

        mKeyFactory = KeyFactory.getInstance("RSA");

        mKeyPair = mKeyPairGenerator.genKeyPair();
    }

    public Key generatePublicKey() {
        return mKeyPair.getPublic();
    }

    public Key generatePrivateKey() {
        return mKeyPair.getPrivate();
    }

    public RSAPublicKeySpec generatePublicKeySpec() throws InvalidKeySpecException {
        return mKeyFactory.getKeySpec(generatePublicKey(), RSAPublicKeySpec.class);
    }

    public RSAPrivateKeySpec generatePrivateKeySpec() throws InvalidKeySpecException {
        return mKeyFactory.getKeySpec(generatePrivateKey(), RSAPrivateKeySpec.class);
    }
}
