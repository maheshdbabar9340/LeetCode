// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> set = new HashSet<>(wordList);
//         if(!set.contains(endWord)) return 0;

//         Queue<String> queue = new LinkedList<>();
//         queue.add(beginWord);

//         Set<String> visited = new HashSet<>();
//         queue.add(beginWord);

//         int changes = 1;

//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i = 0; i < size; i++){
//                 String word = queue.poll();
//                 if(word.equals(endWord)) return changes;

//                 for(int j = 0; j < word.length(); j++){
//                     for(int k = 'a'; k <= 'z'; k++){
//                         char arr[] = word.toCharArray();
//                         arr[j] = (char) k;

//                         String str = new String(arr);
//                         if(set.contains(str) && !visited.contains(str)){
//                             queue.add(str);
//                             visited.add(str);
//                         }
//                     }
//                 }
//             }
//             ++changes;
//         }
//         return 0;
//     }
// }

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // edge case, if wordlist doesn't have endword, return 0
        Set<String> set = new HashSet();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord))
            return 0;

        // cnt to store the number of changes did so far.
        // queue and set for BFS

        // time complexity
        // Note that BFS has time complexity O(V+E), space complexity O(V)
        // In this particular example, we have V = #wordList = N, E = len(words) = M
        // Also we need O(M) to create all word combinations => time complexity :
        // O(M^2*N)

        // Space complexity
        // queue has maximum length of wordList, which is N -> space complexity O(M*N)
        // Set has maximum length of wrodList, which is also O(M*N)
        // finally, for each word, we used char[], to find possible change combinations,
        // which results O(M*N*M) space complexity
        // in total, we get O(M^2*N) complexity.

        int cnt = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] curr = queue.poll().toCharArray();
                for (int j = 0; j < curr.length; j++) {
                    char tmp = curr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == tmp)
                            continue;
                        curr[j] = c;
                        String nword = new String(curr);
                        if (set.contains(nword)) {
                            if (nword.equals(endWord))
                                return cnt + 1;
                            queue.add(nword);
                            set.remove(nword);
                        }
                    }
                    curr[j] = tmp;
                }

            }
            cnt++;
        }
        return 0;
    }
}