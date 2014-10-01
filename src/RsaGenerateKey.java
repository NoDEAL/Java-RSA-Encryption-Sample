import java.security.*;
import java.security.spec.*;

public class RsaGenerateKey {

	KeyPairGenerator mKeyPairGenerator;
	KeyPair mKeyPair;
	KeyFactory mKeyFactory;

	public RsaGenerateKey() throws NoSuchAlgorithmException {
		mKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
		/* The bigger is slower and stronger. 1024 and 2048 also available. */
		mKeyPairGenerator.initialize(4096);

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
