package oa.ms.vo;

import org.junit.Test;

import java.util.HashMap;

public class HashMapTesting {
    @Test
    public void test(){
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i<30; i++) {
            map.put(i + "", i + "");
        }
    }
}
