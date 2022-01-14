class Solution {
    public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        for(int i=0; i<len; i++){
            if(arr[i]==0){
                replace(arr, i+1, len-1);
                if(i < len-1 && arr[i+1]!=0 ){
                    arr[i+1]=0;
                }
                i++;
            }
        }
    }
    
    public static void replace(int[] arr, int start, int end){
        for(int j=end; j>start; j--){
            arr[j]= arr[j-1];
        }
    }

    public static void main(String[] args){
        int[] a = {1,0,3,0,0,4,0,0,0,0,00,0};
        duplicateZeros(a);
        for(int i :a ){
            System.out.println(i);
        }
    }
}