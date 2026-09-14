import java.util.Scanner;

class Matrix {
    int row, col;
    int arr[][];

    Matrix(int r, int c) {
        row = r;
        col = c;
        arr = new int[row][col];
    }

    void readMatrix(Scanner input) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.nextInt();
            }
        }
    }

    void displayMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    Matrix transpose() {
        Matrix t = new Matrix(col, row);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                t.arr[j][i] = arr[i][j];
            }
        }
        return t;
    }

    Matrix multiply(Matrix m) {
        if (this.col != m.row) {
            System.out.println("Matrix multiplication not possible");
            return null;
        }

        Matrix result = new Matrix(this.row, m.col);

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < m.col; j++) {
                for (int k = 0; k < this.col; k++) {
                    result.arr[i][j] += this.arr[i][k] * m.arr[k][j];
                }
            }
        }
        return result;
    }
}

public class Program2 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter rows and columns of Matrix 1: ");
            int r1 = input.nextInt();
            int c1 = input.nextInt();
            
            Matrix m1 = new Matrix(r1, c1);
            System.out.println("Enter elements of Matrix 1:");
            m1.readMatrix(input);
            
            System.out.print("Enter rows and columns of Matrix 2: ");
            int r2 = input.nextInt();
            int c2 = input.nextInt();
            
            Matrix m2 = new Matrix(r2, c2);
            System.out.println("Enter elements of Matrix 2:");
            m2.readMatrix(input);
            
            System.out.println("\nMatrix 1:");
            m1.displayMatrix();
            
            System.out.println("\nMatrix 2:");
            m2.displayMatrix();
            
            System.out.println("\nTranspose of Matrix 1:");
            Matrix t1 = m1.transpose();
            t1.displayMatrix();
            
            System.out.println("\nTranspose of Matrix 2:");
            Matrix t2 = m2.transpose();
            t2.displayMatrix();
            
            System.out.println("\nMatrix Multiplication Result: ");
            Matrix mul = m1.multiply(m2);
            if (mul != null) {
                mul.displayMatrix();
            }
        }
    }
}
