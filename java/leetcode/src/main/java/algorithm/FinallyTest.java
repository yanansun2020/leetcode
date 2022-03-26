package algorithm;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FinallyTest {
    public void test1() throws IOException{
        System.out.println("This is a test");
        Reader fileReader = new FileReader("/Users/yanasun/leetcode/leetcode/java/leetcode/src/main/java/algorithm/file.log");
        try{
            int data = fileReader.read();
            if (fileReader == null || data < 100) {
                System.out.println("going to throw exception");
                throw new IOException();
            }
        }finally {
            System.out.println("In the finally");
        }


        int data = fileReader.read();
    }

    @Test
    public void test() throws Exception{
        test1();
    }
}
