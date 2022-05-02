package algorithm;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class PassByValueTest {
    Node p1 = null;
    Node p2 = null;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        PassByValueTest test = new PassByValueTest();
        test.test((list));
        System.out.println(1);

        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(0));
        list1.add(new Node(1));
        list1.add(new Node(2));
        test.test2(list1);
        System.out.println(2);

        Integer a = 1;
        Integer b = 2;
        test.swap(a, b);
        System.out.println(3);
    }

    public void test(List<Integer> list) {
     //list.set(0, 100);
     list = new ArrayList<>();
     list.add(2);
    }

    public void test2(List<Node> list) {
        for (Node p : list) {
            p2 = p;
            if (p2.val == 1) {
                p1 = p2;
            }
        }
    }

    void swap(Integer arg1, Integer arg2) {
        int temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }
}
