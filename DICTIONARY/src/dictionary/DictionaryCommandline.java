package dictionary;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {
    public void showAllWords() {
        System.out.print("No\t\t|English                    |VietNamese            \n");
        for (int x = 0; x < Dictionary.arr_of_words.size(); x++) {
            System.out.printf("%d\t\t| %-20s\t\t| %-20s\n", (x + 1), Dictionary.arr_of_words.get(x).word_target, Dictionary.arr_of_words.get(x).word_explain);
        }
    }

    public void dictionaryBasic() {
        insertCommandLine();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        insertFromFile();
        showAllWords();
        dictionaryLookup();
        delete();
    }

    public void dictionarySearcher() {
        Scanner sc = new Scanner(System.in);
        String sug = sc.next();
        for (int x = 0; x < Dictionary.arr_of_words.size(); x++) {
            int count = 0;
            int len_of_sug = sug.length();
            int i = 0;
            while (len_of_sug > 0) {
                if (Dictionary.arr_of_words.get(x).word_target.charAt(i) == sug.charAt(i)) {
                    i++;

                } else {
                    i++;
                    count++;
                }
                len_of_sug--;
            }
            if (count == 0) System.out.println(Dictionary.arr_of_words.get(x).word_target);
        }
    }




}
