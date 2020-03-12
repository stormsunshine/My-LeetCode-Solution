public class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<Character>();
        int radiantCount = 0, direCount = 0;
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            char party = senate.charAt(i);
            queue.offer(party);
            if (party == 'R')
                radiantCount++;
            else
                direCount++;
        }
        int radiantBanCount = 0, direBanCount = 0;
        while (radiantCount > 0 && direCount > 0) {
            char party = queue.poll();
            if (party == 'R') {
                if (radiantBanCount > 0)
                    radiantBanCount--;
                else {
                    direCount--;
                    direBanCount++;
                    queue.offer(party);
                }
            } else {
                if (direBanCount > 0)
                    direBanCount--;
                else {
                    radiantCount--;
                    radiantBanCount++;
                    queue.offer(party);
                }
            }
        }
        return radiantCount > 0 ? "Radiant" : "Dire";
    }
}