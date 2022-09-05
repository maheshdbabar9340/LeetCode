// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
          
        List<Li st<Integer>> output = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null) return output;
        queue
        

             
            //  stores the number of values i n  current row (we alter amount in queue later)
            int rowLen = queue.size();
            List<Integer> currRow = new ArrayList<>();    
            for(int i = 0; i < rowLen;  i + + ){
             
                // Add current value into row list values.
                Node curr = queue.poll();
                currRow.add(curr.val);
    
                // Add Children of current node into queue.
                int numChildren = curr.children.size();
                for(int c = 0; c < numChildren; c++) { 
                    if(curr.children.get(c) != null) queue.add(curr.children.get(c));
                }
            }
            output.add(currRow);
        }
        return output;
    }
}