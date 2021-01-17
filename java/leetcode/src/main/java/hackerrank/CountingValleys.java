package hackerrank;

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int valley = 0;
        int level = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                level++;
                if (level == 0) {
                    valley++;
                }
            } else {
                level--;
            }
        }
        return valley;
    }
}
