// Leetcode 106

class Solution {
    public HashMap<Integer,Integer> hashMap;
    public TreeNode buildTree(int[] A, int[] B) {
        hashMap = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            hashMap.put(A[i],i);
        }
        return formBinaryTree(A,B,0,A.length-1,0,B.length-1);
    }
    
    public TreeNode formBinaryTree(int[] inOrder, int [] postOrder, int start, int end , int start2, int end2)      {
        if(start > end){
            
            return  null;
        }
        TreeNode middle = new TreeNode(postOrder[end2]);
        int mid = hashMap.get(middle.val);
        
        int x = mid-1+start2-start;
        middle.left = formBinaryTree(inOrder,postOrder, start, mid-1, start2, x);
        middle.right = formBinaryTree(inOrder,postOrder,mid+1,end,x+1,end2-1 );
        return middle;
    }
}
