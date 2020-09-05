package oa.amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CandidateCount {
    List<List<Integer>> output;
    public int countTeams(int num, List<Integer> skills,int minAssociate, int maxLevel, int minLevel){
        if(num < 1 || skills == null || skills.size() == 0){
            return 0;
        }
        int candidate = 0;
        for(int i =0;i <num; i++){
            if(skills.get(i) >= minLevel && skills.get(i) <= maxLevel){
                candidate++;
            }
        }
        int count = 0;
        for(int i=minAssociate; i<= candidate; i++ ){
            count += factorial(candidate, i);
        }
        return count;
    }
    private int factorial(int n, int k){
        int a = 1; int b = 1;
        for(int i =n; i>= n-k+1; i--){
            a *= i;
        }
        for(int j = k; j >= 1; j--){
            b *= j;
        }
        return a/b;
    }

    public int getCandidate(int[] skills, int maxLevel, int minLevel, int limit){
        output = new LinkedList<>();
        List<Integer> candidates = new ArrayList<>();
        for(int i=0; i< skills.length; i++){
            if(skills[i] >= minLevel && skills[i] <= maxLevel){
                candidates.add(skills[i]);
            }
        }
        getCombinations(0, candidates, limit, new LinkedList<>());
        return output.size();
    }
    void getCombinations(int start, List<Integer> candidates, int limit, LinkedList<Integer> ans){
        if(ans.size() >= limit){
            output.add(new LinkedList<>(ans));
        }
        for(int i = start; i<candidates.size(); i++){
            ans.add(candidates.get(i));
            getCombinations(i+1, candidates, limit, ans);
            ans.removeLast();
        }
    }
    @Test
    public void test(){
//        int[] skills = {3,2,1,4,3};
////        int ans1 = getCandidate(skills, 10, 4, 1);
////        List<Integer> skillsL = new ArrayList<Integer>(){
////            {
////                add(3);
////                add(2);
////                add(1);
////                add(4);
////                add(3);
////            }
////        };
////        int ans2 = countTeams(5, skillsL, 10, 4, 1);
        int[] skills1 = {12,4,6,13,5,10};
        List<Integer> l1 = new ArrayList<Integer>(){
            {
                add(12);
                add(4);
                add(6);
                add(13);
                add(5);
                add(10);
            }
        };
        int ans3 = countTeams(6, l1, 3, 10, 4);
//        int[] skills2 = {6,6,6};
//        int ans = getCandidate(skills1, 10, 4, 1);
    }
}
