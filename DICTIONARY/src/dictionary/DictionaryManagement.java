package dictionary;

import java.io.*;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void insertFromFile() throws IOException {
       Scanner scanner = new Scanner(Paths.get("AnhViet.txt"), "UTF-8");
        Scanner scanner1 = new Scanner(Paths.get("AnhViet.txt"), "UTF-8");
        while(!scanner.nextLine().equals("")) {
            int point = 0;
            String b = "";
            String a = scanner1.nextLine();
            for (int x = 1; x < a.length(); x++) {
                if (a.charAt(x) != '/') {
                    b+=(a.charAt(x));
                } else {
                    point=x;
                    break;
                }
            }
            
            String q = "";
            for (int x = 0 ; x < b.length()-1 ; x ++) {
                q+= b.charAt(x);
            }
           String e = "";
//            for (int x = point ; x < a.length() ; x++) {
//                e+= a.charAt(x);
//            }
//            e+="\n"; 
            String i = scanner.nextLine();
            while (!i.equals("")) {
                e += i;
                e += "\n";
                i = scanner.nextLine();
                scanner1.nextLine();
            }
            scanner1.nextLine();
            Word add = new Word(b,e);
            Dictionary.arr_of_words.add(add);
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

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (int x = 0; x < Dictionary.arr_of_words.size(); x++) {
            if (Dictionary.arr_of_words.get(x).word_target.equals(a)) {
                Dictionary.arr_of_words.remove(x);
            }
        }
    }
    
//    public static void addWord(String path) throws UnsupportedEncodingException, FileNotFoundException {
//        try  {
//            PrintWriter in = new PrintWriter(path, "UTF-8");
//            in.append("sax");
//            in.close();
//        } catch (FileNotFoundException e) {
//           e.getMessage();
//        }catch(UnsupportedEncodingException x) {
//            x.getMessage();
//        }
//    }
    public void capnhattudien() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        try {
            PrintWriter up = new PrintWriter("AnhViet.txt","UTF-8");
            //Collections.sort(Dictionary.arr_of_words , Comparator.comparing(Word::getwordtarget ));
            for(int x = 0 ; x< Dictionary.arr_of_words.size() ; x++) {
                
//                String speech = "" ;
//                speech += Dictionary.arr_of_words.get(x).word_explain.charAt(0);
//                for(int y = 1 ; y < Dictionary.arr_of_words.get(x).word_explain.length(); y ++) {
//                    if (Dictionary.arr_of_words.get(x).word_explain.charAt(y) != '/'){
//                    speech+=Dictionary.arr_of_words.get(x).word_explain.charAt(y);
//                    } else {
//                        speech += Dictionary.arr_of_words.get(x).word_explain.charAt(y);
//                        break;
//                    }
//                }
                up.println("@"+Dictionary.arr_of_words.get(x).word_target);
                up.println(Dictionary.arr_of_words.get(x).word_explain);
                count ++;
                
            }
            up.println();
            
            
                up.flush();
                up.close();
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
