package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_399_CalcEquation {

    /**
     *  DFS 遍历
     * @param equations  除法变量
     * @param values 除法结果值
     * @param queries 查询变量
     * @return 除法值
     */
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //邻接点
        Map<String,List<String>> map = new HashMap<>();
        //等式 ---> 值
        Map<String,Double> equationToValue = new HashMap<>();
        // 是否使用
        Map<String,Boolean> used = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            //a --> b
            List<String> value = map.get(equations.get(i).get(0));
            if(value == null){
                List<String> list = new ArrayList<>();
                list.add(equations.get(i).get(1));
                map.put(equations.get(i).get(0),list);
            }else{
                value.add(equations.get(i).get(1));
            }
            // b --> a
            value = map.get(equations.get(i).get(1));
            if(value == null){
                List<String> list = new ArrayList<>();
                list.add(equations.get(i).get(0));
                map.put(equations.get(i).get(1),list);
            }else{
                value.add(equations.get(i).get(0));
            }
            equationToValue.put(equations.get(i).get(0)+"_"+equations.get(i).get(1),values[i]);
            equationToValue.put(equations.get(i).get(1)+"_"+equations.get(i).get(0),1/values[i]);

            used.put(equations.get(i).get(0),false);
            used.put(equations.get(i).get(1),false);
        }
        //保存结果
        double[] ans = new double[queries.size()];
        double value;
        //使用DFS遍历
        for (int i = 0; i < queries.size(); i++){
            List<String> result = new ArrayList<>();
            resetUsed(used);
            if(!used.containsKey(queries.get(i).get(0))){
                ans[i] = -1.00000;
                continue;
            }
            used.put(queries.get(i).get(0),true);
            result.add(queries.get(i).get(0));
            result =  dfs(queries.get(i).get(0),queries.get(i).get(1),map,used,result);
            if(result == null || !result.get(result.size()-1).equals(queries.get(i).get(1))){
                ans[i] = -1.00000;
                continue;
            }
            value = 1;
            for (int j = 0; j < result.size()-1; j++) {
                value = value * equationToValue.get(result.get(j)+"_"+result.get(j+1));
            }
            ans[i] = value;
        }
        return ans;
    }

    private static void resetUsed(Map<String, Boolean> usered) {
            usered.replaceAll((k,v)-> false);
    }

    /**
     * @param start 开始字符
     * @param end 结束字符
     * @param map 邻接表
     * @param result 保存从开始到结束的人
     */
    private static List<String> dfs(String start, String end, Map<String, List<String>> map, Map<String,Boolean> used, List<String> result) {
          if(start.equals(end)){
               return result;
          }
         List<String> nexts = map.get(start);
         if(nexts != null) {
             for (String next : nexts) {
                 if (!used.get(next)) {
                     result.add(next);
                     used.put(next, true);
                     List<String> res = dfs(next, end, map, used, result);
                     if(res != null){
                         return res;
                     }
                     result.remove(result.size() - 1);
                     used.put(next, false);
                 }
             }
         }
         return null;
    }

    //并查集
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        equations.add(elements);

        double[] values = new double[1];
        values[0] = 0.5;

        List<List<String>> queries = new ArrayList<>();
        List<String> ele1 = new ArrayList<>();
        ele1.add("a");
        ele1.add("b");
        List<String> ele2 = new ArrayList<>();
        ele2.add("b");
        ele2.add("a");
        List<String> ele3 = new ArrayList<>();
        ele3.add("a");
        ele3.add("c");
        List<String> ele4 = new ArrayList<>();
        ele4.add("a");
        ele4.add("c");
        queries.add(ele1);
        queries.add(ele2);
        queries.add(ele3);
        queries.add(ele4);

        for(double ans : calcEquation(equations,values,queries)){
            System.out.println(ans);
        }
    }
}
