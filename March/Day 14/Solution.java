// https://leetcode.com/problems/simplify-path/

// Approach 1 : Using Stack

class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!s.isEmpty() && p[i].equals(".."))
                s.pop();
            else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }

        if (s.isEmpty())
            return "/";
        while (!s.isEmpty()) {
            res.insert(0, s.pop()).insert(0, "/");
        }
        return res.toString();
    }
}

// Approach 2 : Using Deque

class Solution {
    public String simplifyPath(String path) {
        Deque<String> s = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!s.isEmpty() && p[i].equals(".."))
                s.poll();
            else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }

        if (s.isEmpty())
            return "/";
        while (!s.isEmpty()) {
            res.append("/").append(s.pollLast());
        }
        return res.toString();
    }
}