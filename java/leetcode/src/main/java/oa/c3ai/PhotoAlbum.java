package oa.c3ai;

import java.util.LinkedList;

public class PhotoAlbum {
    public int[] CreatePhotoAlbum_WithTwoLoops(int[] index, int[] identity){
        LinkedList<Integer> album = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            album.add(index[i], identity[i]);
        }
        int[] ans = new int[index.length];
        int i = 0;
        for (Integer v : album){
            ans[i++] = v;
        }
        return ans;
    }
}
