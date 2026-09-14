//Implement Array and String operations (Reverse, Sort,Search, Average, Maximum) using class and objects

import java.util.Scanner;

class Operations {

    void revString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println("Reversed String: " + rev);
    }

    void revArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        System.out.print("Reversed Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void sortArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void searchArray(int arr[], int key) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }

    void avgArray(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / arr.length;
        System.out.println("Average: " + avg);
    }

    void maxArray(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum Element: " + max);
    }
}

public class Program1 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            Operations a = new Operations();
            
            System.out.println("-> String Opreations\n");
            System.out.print("Enter String: ");
            String str = input.nextLine();
            a.revString(str);
            
            System.out.println("\n-> Array Opreations\n");
            System.out.print("Enter number of elements: ");
            int n = input.nextInt();
            int arr[] = new int[n];
            
            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            
            a.revArray(arr);
            a.sortArray(arr);
            
            System.out.print("Enter element to search: ");
            int key = input.nextInt();
            a.searchArray(arr, key);
            
            a.avgArray(arr);
            a.maxArray(arr);
        }
    }
}
