// https://leetcode.com/problems/make-the-string-great/

class Solution {
    public String makeGood(String s) {
        char[] chArr = s.toCharArray(); String str="";
        LinkedList<Character> linkedList = new LinkedList<>();
        for(int i = 0; i < chArr.length; i++){
            if(!linkedList.isEmpty() && Math.abs(linkedList.getLast() - chArr[i]) == 'a' - 'A'){
                linkedList.removeLast(); continue;
            }
            if(i + 1 != chArr.length && Math.abs(chArr[i + 1] - chArr[i]) == 'a' - 'A') i++;
            else linkedList.add(chArr[i]);
        }
        while(!linkedList.isEmpty()){
            str+=(linkedList.removeFirst());
        }
        return str;
    }
}
