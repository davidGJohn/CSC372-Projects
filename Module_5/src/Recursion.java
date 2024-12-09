import java.util.Scanner;

public class Recursion {
    public static double getProduct(double[] numbers, int index) {
        if (index == numbers.length) 
            return 1;
        return numbers[index] * getProduct(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        System.out.println("Product: " + getProduct(numbers, 0));
        scanner.close();
    }
}

