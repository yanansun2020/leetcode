package algorithm.treemap;

import java.util.TreeMap;

public class FloorKey {
    public static void main(String[] args)
    {

        // Creating an empty TreeMap
        TreeMap<Integer, String> treemap
            = new TreeMap<Integer, String>();

        // Mapping string values to int keys
        treemap.put(20, "Twenty");
        treemap.put(10, "Ten");
        treemap.put(13, "Thirteen");
        treemap.put(60, "Sixty");
        treemap.put(50, "Fifty");

        System.out.println(treemap.floorEntry(13).getKey());

        System.out.println(treemap.floorKey(10));
    }
}
