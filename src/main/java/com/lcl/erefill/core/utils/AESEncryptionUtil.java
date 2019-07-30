package com.lcl.erefill.core.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AESEncryptionUtil {

	private static final Logger Logger = LoggerFactory.getLogger(AESEncryptionUtil.class);
	private static Key genSecretKey = null;
	private static String encryptAlgorithm = PropertyUtil.getEncryptAlgorithm();

	//Constructor is used to generate a secret key for AES algorithm
	public AESEncryptionUtil() {
		Logger.info("AESEncryptionUtil invoked");
		byte[] keyValue= PropertyUtil.getEncryptionKey().getBytes();
		genSecretKey = new SecretKeySpec(keyValue, encryptAlgorithm);
	}

	// Performs Encryption
	public String encrypt(String plainText) throws Exception 
	{
		Cipher chiper = Cipher.getInstance(encryptAlgorithm);
		chiper.init(Cipher.ENCRYPT_MODE, genSecretKey);
		byte[] encVal = chiper.doFinal(plainText.getBytes());
		String encryptedValue = new Base64().encodeToString(encVal);
		return encryptedValue;
	}

	// Performs decryption
	public String decrypt(String encryptedText) throws Exception 
	{
		Cipher chiper = Cipher.getInstance(encryptAlgorithm);
		chiper.init(Cipher.DECRYPT_MODE, genSecretKey);
		byte[] decodedValue = Base64.decodeBase64(encryptedText);
		byte[] decValue = chiper.doFinal(decodedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

}
