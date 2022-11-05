package com.algorithms.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class leetcode_341_NestedIterator {

    interface NestedInteger{
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
       boolean isInteger();
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      Integer getInteger();
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      List<NestedInteger> getList();
    }

    /**
     * DFS 展开成
     */
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> integerList = new ArrayList<>();

        int index = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            if(nestedList == null || nestedList.size() == 0){
                return;
            }
            dfs(nestedList,integerList);
        }

        private void dfs(List<NestedInteger> nestedList, List<Integer> integerList) {
            for(NestedInteger nestedInteger : nestedList){
                if(nestedInteger.isInteger()){
                    integerList.add(nestedInteger.getInteger());
                }else{
                    dfs(nestedInteger.getList(),integerList);
                }
            }
        }

        @Override
        public Integer next() {
           return integerList.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < integerList.size();
        }
    }


}
