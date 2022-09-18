import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean goAgain = true;
        displayMenu();
        while (goAgain) {
            String input = scan.nextLine();
            if (input.equals("1")) {
                System.out.println("Ange x antal ord separera dem med radbrytning, avsluta med att skriva END");
                reverseString();
                System.out.println();
                displayMenu();
            } else if (input.equals("2")) {
                System.out.println("Ange 5 heltal, använd enter för att separera dem");
                largestNumber();
                System.out.println();
                displayMenu();
            } else if (input.equals("3")) {
                rps();
                System.out.println();
                displayMenu();
            } else if (input.equals("4")) {
                System.out.println("Ange 5 heltal separera dem med mellanslag");
                sort();
                System.out.println();
                displayMenu();
            } else if (input.equals("e")) {
                goAgain = false;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Upp och Ner");
        System.out.println("2. Min Max");
        System.out.println("3. Sten Sax Påse");
        System.out.println("4. Ordning och reda");
        System.out.println("e. Avsluta");
    }

    private static void reverseString() {
        Scanner scan = new Scanner(System.in);
        String inputWord = scan.nextLine();
        String[] wordArray = new String[0];
        while (!inputWord.equalsIgnoreCase("end")) {
            wordArray = addWord(wordArray, inputWord);
            inputWord = scan.nextLine();
        }
        for (int i = wordArray.length - 1; i >= 0; i--) {
            System.out.println(wordArray[i]);
        }
    }

    private static String[] addWord(String[] inputArray, String newWord) {
        String[] temp = new String[inputArray.length + 1];
        for (int i = 0; i < inputArray.length; i++) {
            temp[i] = inputArray[i];
        }
        temp[temp.length - 1] = newWord;
        return temp;
    }


    private static void largestNumber() {
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

    private static void rps() {
        int userScore = 0;
        int computerScore = 0;
        int[] resultArray = new int[2];
        System.out.println("Ange ditt drag genom att skriva sten, sax eller påse. Först till tre! Skriv avsluta för att avsluta");
        Scanner scan = new Scanner(System.in);
        while (userScore < 3 && computerScore < 3) {
            String userMove = scan.nextLine();
            if (userMove.equalsIgnoreCase("sten")) {
                System.out.println("Du valde sten!");
                resultArray = roundResult(1);
            } else if (userMove.equalsIgnoreCase("sax")) {
                System.out.println("Du valde sax!");
                resultArray = roundResult(2);
            } else if (userMove.equalsIgnoreCase("påse")) {
                System.out.println("Du valde påse!");
                resultArray = roundResult(3);
            } else if (userMove.equalsIgnoreCase("avsluta")) {
                System.out.println("Du avslutade!");
                break;
            } else {
                System.out.println("Välj endast ett av alternativen");
            }
            userScore += resultArray[0];
            computerScore += resultArray[1];
            System.out.println("Du har vunnit " + userScore + " runda/rundor");
            System.out.println("Datorn har vunnit " + computerScore + " runda/rundor");

        }
    }


    private static int computerControls() {
        int computerMove = (int) (Math.random() * 2 + 1);
        if (computerMove == 1) {
            System.out.println("Datorn valde sten");
        } else if (computerMove == 2) {
            System.out.println("Datorn valde sax");
        } else if (computerMove == 3) {
            System.out.println("Datorn valde påse");
        }
        return computerMove;
    }

    private static int[] roundResult(int userMove) {
        int computerMove = computerControls();
        int[] score = new int[2];
        if (userMove == computerMove) {
            roundDraw();
        } else if (userMove == 1 && computerMove == 2 || userMove == 2 && computerMove == 3 || userMove == 3 && computerMove == 1) {
            score[0] = 1;
            score[1] = 0;
            roundWon();
        } else if (userMove == 1 && computerMove == 3 || userMove == 2 && computerMove == 1 || userMove == 3 && computerMove == 2) {
            score[0] = 0;
            score[1] = 1;
            roundLost();
        }
        return score;
    }

    private static void roundDraw() {
        System.out.println("Det blev lika den här rundan!");
    }

    private static void roundWon() {
        System.out.println("Du vann den här rundan!");
    }

    private static void roundLost() {
        System.out.println("Datorn vann den här rundan!");
    }


    public static void sort() {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int numOfIt = 5;
        String[] inputNum = scan.nextLine().split(" ");
        int[] arrayOfNum = new int[5];
        for (int i = 0; i < inputNum.length; i++) {
            arrayOfNum[i] = Integer.parseInt(inputNum[i]);
            sum = Integer.parseInt(inputNum[i]) + sum;
        }
        for (int i = 0; i < numOfIt; i++) {
            for (int j = i + 1; j < numOfIt; j++) {
                if (arrayOfNum[i] > arrayOfNum[j]) {
                    int temp = arrayOfNum[i];
                    arrayOfNum[i] = arrayOfNum[j];
                    arrayOfNum[j] = temp;
                }
            }
        }
        int[] copyOfArrayOfNum = new int[arrayOfNum.length];
        System.arraycopy(arrayOfNum, 0, copyOfArrayOfNum, 0, copyOfArrayOfNum.length);
        Arrays.sort(copyOfArrayOfNum);
        if (Arrays.equals(arrayOfNum, copyOfArrayOfNum)) {
            System.out.println("Talen är i ordning");
        } else if (!Arrays.equals(arrayOfNum, copyOfArrayOfNum)) {
            System.out.println("Talen är inte i ordning");
        }

        System.out.println("Max value: " + arrayOfNum[numOfIt - 1]);
        System.out.println("Min value: " + arrayOfNum[0]);
        System.out.println("2Max value: " + arrayOfNum[numOfIt - 2]);
        System.out.println("2Min value: " + arrayOfNum[1]);
        System.out.println("Summa: " + sum);

    }

}

