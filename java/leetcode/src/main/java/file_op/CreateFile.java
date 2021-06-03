package file_op;

import java.io.File;

public class CreateFile {
    private static  File          directory;
    public static void main(String[] args) {
        File attempt = new File("F:\\tmp\\dist-systems-0");

        if (attempt.mkdir()) {
            directory = attempt;
            System.out.println("123");
            // Make sure the directory is removed on virtual machine exit.
            //Thread  hook = new Thread(new CleanupShutdownHook(this));
            //untime.getRuntime().addShutdownHook(hook);
            return;
        }

    }
}
