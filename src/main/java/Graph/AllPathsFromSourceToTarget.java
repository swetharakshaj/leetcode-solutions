package Graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static List<List<Integer>> getPaths(int[][] graph)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(graph == null || graph.length == 0)
        {
            return result;
        }

        List<Integer> tempList = new ArrayList<>();

        dfs(0, graph, tempList, result);
        return result;
    }

    private static void dfs(int curr, int[][] graph, List<Integer> tempList, List<List<Integer>> result) {
        tempList.add(curr);

        if(tempList.get(tempList.size()-1) == graph.length-1)
        {
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int next : graph[curr])
            {
                dfs(next, graph, tempList, result);
            }
        }

        tempList.remove(tempList.size()-1);

    }

    public static void main(String[] args)
    {
        int[][] graph ={{1,2}, {3}, {3}, {}};
        List<List<Integer>> result = getPaths(graph);

        for(List<Integer> list : result)
        {
            System.out.println();
            for(int num : list)
            {
                System.out.print(num + " -- ");
            }
        }
    }

}
