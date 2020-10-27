package dictionary;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Word {
    String word_target;
    String word_explain;
    public Word( String word_target, String word_explain)
    {
        this.word_explain = word_explain;
        this.word_target = word_target;
    }

    
    public String getwordtarget() {
        return this.word_target;
    }
}
