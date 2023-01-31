// https://leetcode.com/problems/best-team-with-no-conflicts/

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, max = 0;
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < n; i++)
            players.add(new Player(scores[i], ages[i]));
        players.sort((p1, p2) -> p1.age == p2.age ? p1.score - p2.score : p1.age - p2.age);
        
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = players.get(i).score;
            for(int j = 0; j < i; j++) {
                if(players.get(j).score <= players.get(i).score)
                    dp[i] = Math.max(dp[i], dp[j] + players.get(i).score);
            }
            
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Player {
    public int score;
    public int age;
    public Player(int score, int age) {
        this.score = score;
        this.age = age;
    }
}
