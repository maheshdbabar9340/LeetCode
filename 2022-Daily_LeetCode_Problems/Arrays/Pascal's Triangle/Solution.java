import java.util.*;
// DP Approach 
class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> MainList = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        
        for(int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j)
                if(j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j-1) + pre.get(j));
            pre = row;
            MainList.add(row);
        }
        return MainList;
    }

    // nCr approach for each row
    // public static List<List<Integer>> generate(int numRows) {
    //     List<List<Integer>> MainList = new ArrayList<List<Integer>>();
    //     for(int i = 0; i<numRows; i++) {
    //         List<Integer> list=new ArrayList<Integer>();
    //         for(int j=0; j<=i; j++) {
    //             list.add(nCr(i, j));
    //         }
    //         MainList.add(list);
    //     }
    //     return MainList;
    // }
    // static int nCr(int n, int r)
    // {
    //     return fact(n) / (fact(r) * fact(n - r));
    // }

    // // Returns factorial of n
    // static int fact(int n)
    // {
    //     int res = 1;
    //     for (int i = 2; i <= n; i++)
    //         res = res * i;
    //     return res;
    // }

    public static void main(String[] args) {
        List<List<Integer>> MainList = generate(15);
        System.out.println(MainList);

        int[] a = new int[5];
        for(int i:a)
            System.out.println(i);
    }
}