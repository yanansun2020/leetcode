package oa.gg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给了两个recipe R1 和 R2，每个recipe有特定的几个步骤，每个步骤是一个tuple，包含步骤名称、用时间、active/passive
 * 对于passive的步骤，可以在做的时候同时去完成另一个recipe上面的任务。求完成两个recipe的最短时间
 * eg. R1 = [(A, 2, 'ACTIVE'), (B, 3, 'PASSIVE')], R2 = [(C, 2, 'ACTIVE')]
 * output是5，先做A，然后同时BC。
 * https://www.1point3acres.com/bbs/thread-796092-1-1.html
 *
 * 此方法对这种例子不work：需要将连续相同type的receipe 先合并
 *  r1.add(new Recipe('A', 5, "p"));
 *  r1.add(new Recipe('B', 3, "p"));
 */
public class TimeToFinishRecipe {
    private int getTime(List<Recipe> r1, List<Recipe> r2) {
        return dfs(0, 0, r1, r2);
    }

    private int dfs(int i1, int i2, List<Recipe> r1_list, List<Recipe> r2_list) {
        if (i1 == r1_list.size() && i2 == r2_list.size()) {
            return 0;
        }
        int remainTime = 0;
        if (i1 == r1_list.size()) {
            for (int i = i2; i < r2_list.size(); i++) {
                remainTime += r2_list.get(i).time;
            }
            return remainTime;
        }
        if (i2 == r2_list.size()) {
            for (int i = i1; i < r1_list.size(); i++) {
                remainTime += r1_list.get(i).time;
            }
            return remainTime;
        }
        Recipe r1 = r1_list.get(i1);
        Recipe r2 = r2_list.get(i2);
        //if select r1:
        int t1 = 0;
        if (active(r1) && active(r2)) {
            t1 += dfs(i1 + 1, i2, r1_list, r2_list);
            t1 += r1.time;
        } else if (!active(r1)){
            //find how many work can finish in r2
//            int parallel_time = 0;
//            while (parallel_time + r2.time < r1.time) {
//                parallel_time += r2.time;
//                i2++;
//                r2 = r2_list.get(i2);
//            }
            t1 += dfs(i1 + 1, i2 + 1, r1_list, r2_list);
            t1 += Math.max(r1.time, r2.time);
        }
        //select r2
        int t2 = 0;
        if (active(r2) && active(r1)) {
            t2 += dfs(i1, i2 + 1, r1_list, r2_list);
            t2 += r2.time;
        } else if (!active(r2)){
//            int parallel_time = 0;
//            while (parallel_time + r1.time < r1.time) {
//                parallel_time += r1.time;
//                i1++;
//                r1 = r1_list.get(i1);
//            }
            t2 += dfs(i1 + 1, i2 + 1, r1_list, r2_list);
            t2 += Math.max(r2.time, r1.time);
        }
        return Math.min(t1, t2);
    }

    private boolean active(Recipe r) {
        return r.type.equals("a");
    }

    @Test
    public void test() {
        List<Recipe> r1 = new ArrayList<>();
        r1.add(new Recipe('A', 3, "a"));
        r1.add(new Recipe('B', 10, "p"));
        List<Recipe> r2 = new ArrayList<>();
        r2.add(new Recipe('c', 4, "a"));
        r2.add(new Recipe('c', 15, "p"));

        int time = getTime(r1, r2);
    }

}


class Recipe{
    char name;
    int time;
    String type;//p(passive) or a (active)
    Recipe(char name, int time, String type) {
        this.name = name;
        this.time = time;
        this.type = type;
    }
}
