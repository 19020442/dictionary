
import javax.swing.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement  {

    public  static void insertCommandLine() {
        Scanner sc = new Scanner(System.in);
        String k;
        k = sc.nextLine();
        int n = Integer.parseInt(k);
        for (int x = 0; x < n; x++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            Word insert = new Word(a, b);
            Dictionary.arr_of_words.add(insert);

        }

    }

    public void insertFromFile() throws IOException {
        Scanner scanner = new Scanner(Paths.get("dictionaries.txt"), "UTF-8");
        while (scanner.hasNextLine()) {
            Word neword = new Word(scanner.next(), scanner.nextLine());
            Dictionary.arr_of_words.add(neword);
        }
    }

    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        for (int x = 0; x < Dictionary.arr_of_words.size(); x++) {
            if (Dictionary.arr_of_words.get(x).word_target.equals(target)) {
                System.out.println(Dictionary.arr_of_words.get(x).word_explain);
                break;
            }
        }
    }

    public static void add() {
        System.out.print("Them tu vao tu dien: ");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        Word add = new Word(a, b);
        Dictionary.arr_of_words.add(add);
    }

    public void fix() {

    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu ban muon xoa: ");
        String a = sc.next();
        for (int x = 0; x < Dictionary.arr_of_words.size(); x++) {
            if (Dictionary.arr_of_words.get(x).word_target.equals(a)) {
                Dictionary.arr_of_words.remove(x);
            }
        }
    }

}
