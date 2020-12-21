package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
//https://www.geeksforgeeks.org/topological-sorting/
public class TopologicalSort {
    private ArrayList<ArrayList<Integer>> adj;
    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(new Integer(v));
    }

    void topologicalSort(int size) {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < size; i++)
            if (!visited[i])
            topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}
