import java.util.Scanner;

public class StenSaxPase {
    public void rps() {
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
    private int[] roundResult(int userMove) {
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
    private int computerControls() {
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

    private void roundDraw() {
        System.out.println("Det blev lika den här rundan!");
    }

    private void roundWon() {
        System.out.println("Du vann den här rundan!");
    }

    private void roundLost() {
        System.out.println("Datorn vann den här rundan!");
    }



}
