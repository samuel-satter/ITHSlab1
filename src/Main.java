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
                UppOchNer uppOchNer = new UppOchNer();
                uppOchNer.reverseString();
                System.out.println();
                displayMenu();
            } else if (input.equals("2")) {
                System.out.println("Ange 5 heltal, använd enter för att separera dem");
                MinMax minMax = new MinMax();
                minMax.largestNumber();
                System.out.println();
                displayMenu();
            } else if (input.equals("3")) {
                StenSaxPase stenSaxPase = new StenSaxPase();
                stenSaxPase.rps();
                System.out.println();
                displayMenu();
            } else if (input.equals("4")) {
                System.out.println("Ange 5 heltal separera dem med mellanslag");
                OrdningOchReda ordningOchReda = new OrdningOchReda();
                ordningOchReda.sort();
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

}

