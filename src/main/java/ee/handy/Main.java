package ee.handy;

public class Main {
    public static void main(String[] args) {
        String text = "This is an example text; where ~half~ the words: @will be replaced with * symbols @.";
        System.out.println("Example of the text () -> : " + text);
        System.out.println("Result of the default(50%) scrambler () -> : " + new Masker(text).maskText());
        System.out.println("Result of the 10% scrambler () -> : " + new Masker(text, 10).maskText());
        System.out.println("Result of the 99% scrambler () -> : " + new Masker(text, 90).maskText());
    }
}
