import java.util.Scanner;

public class UppOchNer {
    public void reverseString() {
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
    private String[] addWord(String[] inputArray, String newWord) {
        String[] temp = new String[inputArray.length + 1];
        for (int i = 0; i < inputArray.length; i++) {
            temp[i] = inputArray[i];
        }
        temp[temp.length - 1] = newWord;
        return temp;
    }

}
