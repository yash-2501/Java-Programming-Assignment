//Write a program demonstrating Wrapper classes and String vs StringBuffer

import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Wrapper Class\n");
            System.out.print("Enter an integer: ");
            int num = sc.nextInt();

            Integer objNum = num;
            System.out.println("Integer object: " + objNum);

            int unboxedNum = objNum;
            System.out.println("primitive int: " + unboxedNum);

            System.out.println("\nString vs StringBuffer");
            sc.nextLine();

            System.out.print("\nEnter a String: ");
            String str = sc.nextLine();

            System.out.print("Enter word to concat: ");
            String concatWord = sc.nextLine();

            str = str.concat(concatWord);
            System.out.println("String after concat: " + str);

            System.out.print("Enter a StringBuffer value: ");
            StringBuffer sb = new StringBuffer(sc.nextLine());

            System.out.print("Enter word to append: ");
            String appendWord = sc.nextLine();

            sb.append(appendWord);
            System.out.println("StringBuffer after append: " + sb);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
