/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Set<Integer> notCelebritySet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    notCelebritySet.add(i);
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!notCelebritySet.contains(i)) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j && knows(j, i))
                        count++;
                }
                if (count == n - 1)
                    return i;
            }
        }
        return -1;
    }
}