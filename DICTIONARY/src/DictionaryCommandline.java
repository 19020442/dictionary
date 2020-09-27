public class DictionaryCommandline extends  DictionaryManagement {

    public void showAllWords() {
        System.out.printf("No\t\t|English                    |VietNamese            \n");
        for (int x = 0 ; x< arr_of_words.size(); x++) {
            System.out.printf("%d\t\t| %-20s\t\t| %-20s\n",(x+1),arr_of_words.get(x).word_target,arr_of_words.get(x).word_explain);
        }

    }
    public void dictionaryBasic() {
        insertCommandLine();
        showAllWords();
    }
    public static void main(String[] args) {
        DictionaryCommandline center = new DictionaryCommandline();
        center.dictionaryBasic();
    }

}
