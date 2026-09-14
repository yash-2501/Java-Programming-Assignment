//Implement Cipher system using Abstract class and method overriding

import java.util.Scanner;

abstract class Cipher {
    public abstract String encrypt(String text);
    public abstract String decrypt(String text);
}

class SimpleCipher extends Cipher {

    @Override
    public String encrypt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = (char)(ch + 3);   
            result += ch;
        }
        return result;
    }

    @Override
    public String decrypt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = (char)(ch - 3);   
            result += ch;
        }
        return result;
    }
}

public class Program6 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SIMPLE CIPHER SYSTEM =====\n");

        System.out.print("Enter Original Text : ");
        String text = sc.nextLine();

        SimpleCipher obj = new SimpleCipher();

        String encrypted = obj.encrypt(text);
        String decrypted = obj.decrypt(encrypted);

        System.out.println("--------------------------------");
        System.out.println("Encrypted Text : " + encrypted);
        System.out.println("Decrypted Text : " + decrypted);
        System.out.println("================================");
    }
}