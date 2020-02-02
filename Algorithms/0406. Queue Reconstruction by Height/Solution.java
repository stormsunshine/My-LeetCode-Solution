class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0])
                    return person2[0] - person1[0];
                else
                    return person1[1] - person2[1];
            }
        });
        int length = people.length;
        for (int i = 1; i < length; i++) {
            int[] person = people[i];
            int height = person[0], count = person[1];
            if (count < i) {
                for (int j = i - 1; j >= count; j--) {
                    for (int k = 0; k < 2; k++)
                        people[j + 1][k] = people[j][k];
                }
                people[count][0] = height;
                people[count][1] = count;
            }
        }
        return people;
    }
}