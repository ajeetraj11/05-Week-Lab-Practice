package com.encryptanddecryptcsvdata;

import java.io.*;

// Define the class responsible for encrypting and decrypting CSV data
public class EncryptDecryptCSV {
	// Define secret key for encryption
	private static final String SECRET_KEY = "MySecretKey12345";

	public static void main(String[] args) {
		// Specify input and output file paths
		String inputFile = "employees.csv";
		String encryptedFile = "encrypted_employees.csv";
		String decryptedFile = "decrypted_employees.csv";

		// Encrypt CSV file
		encryptCsv(inputFile, encryptedFile);

		// Decrypt CSV file
		decryptCsv(encryptedFile, decryptedFile);

		// Display decrypted file content
		displayDecryptedFile(decryptedFile);
	}

	// Method to encrypt CSV file
	public static void encryptCsv(String inputFile, String outputFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

			// Read and write the header as is
			String header = br.readLine();
			bw.write(header + "\n");
			String line;
			while ((line = br.readLine()) != null) {
				// Split the line into fields
				String[] fields = line.split(",");

				// Encrypt sensitive fields
				fields[2] = encrypt(fields[2]);
				fields[3] = encrypt(fields[3]);

				// Write encrypted data to output file
				bw.write(String.join(",", fields) + "\n");
			}
		}
		catch (Exception e) {
			// Handle any encryption or IO exceptions that may occur
			e.printStackTrace();
		}
	}

	// Method to decrypt CSV file
	public static void decryptCsv(String inputFile, String outputFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

			// Read and write the header as is
			bw.write(br.readLine() + "\n");
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");

				// Decrypt sensitive fields
				fields[2] = decrypt(fields[2]);
				fields[3] = decrypt(fields[3]);

				// Write decrypted data to output file
				bw.write(String.join(",", fields) + "\n");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to display the decrypted file contents
	public static void displayDecryptedFile(String decryptedFile) {
		System.out.println("\nDecrypted File Content:");
		try (BufferedReader br = new BufferedReader(new FileReader(decryptedFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Simple encryption method using character shifting
	public static String encrypt(String data) {
		StringBuilder encrypted = new StringBuilder();

		// Shift each character by 3 positions in ASCII
		for (char c : data.toCharArray()) {
			encrypted.append((char) (c + 3));
		}
		return encrypted.toString();
	}

	// Simple decryption method using character shifting
	public static String decrypt(String data) {
		StringBuilder decrypted = new StringBuilder();

		// Shift each character back by 3 positions in ASCII
		for (char c : data.toCharArray()) {
			decrypted.append((char) (c - 3));
		}
		return decrypted.toString();
	}
}