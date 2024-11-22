package ee.handy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class provides functionality to mask a percentage of words in a text.
 * Symbols are ignored.
 *
 *
 *
 * @author Toomas Park
 * @version 1.0
 * @link <a href="https://github.com/zapacher">...</a>
 */
public class Masker {
    private String text;
    private int percentage = 50;

    public Masker(String text, int percentage) {
        this.text = text;
        this.percentage = percentage;
    }
    public Masker(String text) {
        this.text = text;
    }

    public String maskText() {
        String[] words = text.split("\\s+");

        int wordsToMask = (int) Math.ceil((percentage / 100.0) * words.length);

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            indices.add(i);
        }

        Collections.shuffle(indices);

        for (int i = 0; i < wordsToMask; i++) {
            int index = indices.get(i);
            words[index] = maskWord(words[index]);
        }

        return String.join(" ", words);
    }

    private static String maskWord(String word) {
        StringBuilder masked = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                masked.append("*");
            } else {
                masked.append(c);
            }
        }
        return masked.toString();
    }
}