
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    public void insertCommandLine() {
        Scanner sc = new Scanner(System.in);
        String k;
        k = sc.nextLine();
        int n = Integer.parseInt(k);
        for (int x = 0; x < n; x++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            Word insert = new Word(a, b);
            arr_of_words.add(insert);
        }

    }
}
