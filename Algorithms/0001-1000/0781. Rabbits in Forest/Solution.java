class Solution {
    public int numRabbits(int[] answers) {
        int minRabbits = 0;
        Arrays.sort(answers);
        int length = answers.length;
        int startIndex = -1;
        for (int i = 0; i < length; i++) {
            if (answers[i] == 0)
                minRabbits++;
            else {
                startIndex = i;
                break;
            }
        }
        if (startIndex < 0)
            return minRabbits;
        int prevAnswer = -1;
        int count = 0;
        for (int i = startIndex; i < length; i++) {
            int answer = answers[i];
            if (prevAnswer < 0)
                count = 1;
            else if (answer == prevAnswer)
                count++;
            else {
                int prevRabbits = minRabbitsPossible(prevAnswer, count);
                minRabbits += prevRabbits;
                count = 1;
            }
            prevAnswer = answer;
        }
        int prevRabbits = minRabbitsPossible(prevAnswer, count);
        minRabbits += prevRabbits;
        return minRabbits;
    }

    public int minRabbitsPossible(int answer, int count) {
        int groupSize = answer + 1;
        int groupsCount = (int) Math.ceil(1.0 * count / groupSize);
        return groupSize * groupsCount;
    }
}