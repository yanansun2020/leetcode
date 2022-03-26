package sort;

public class Word {
    String s;
    int ch;
    int c;
    Long value;
    Word(int ch, int c) {
        this.ch = ch;
        this.c = c;
    }
    Word(String ch, Long value) {
        this.s = ch;
        this.value = value;
    }
}
