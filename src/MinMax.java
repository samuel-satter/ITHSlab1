import java.util.Scanner;

public class MinMax {
    public void largestNumber() {
        Scanner scan = new Scanner(System.in);
        int numOfIt = 5;
        int largestNum = Integer.MIN_VALUE;
        int smallestNum = Integer.MAX_VALUE;

        for (int i = 0; i < numOfIt; i++) {
            int inputNum = scan.nextInt();
            if (inputNum > largestNum) {
                largestNum = inputNum;
            }
            if (inputNum < smallestNum) {
                smallestNum = inputNum;
            }
        }
        System.out.println("Min value: " + smallestNum);
        System.out.println("Max value: " + largestNum);
    }

}
