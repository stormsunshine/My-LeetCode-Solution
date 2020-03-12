class Solution {
    public int strongPasswordChecker(String s) {
        int length = s.length();
        if (length == 0)
            return 6;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1 % 3 - num2 % 3;
            }
        });
        int repeatingCount = 1;
        int lowerCaseCount = 1, upperCaseCount = 1, digitCount = 1;
        char c0 = s.charAt(0);
        if (Character.isLowerCase(c0))
            lowerCaseCount = 0;
        else if (Character.isUpperCase(c0))
            upperCaseCount = 0;
        else if (Character.isDigit(c0))
            digitCount = 0;
        char prevC = c0;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c))
                lowerCaseCount = 0;
            else if (Character.isUpperCase(c))
                upperCaseCount = 0;
            else if (Character.isDigit(c))
                digitCount = 0;
            if (c == prevC)
                repeatingCount++;
            else {
                if (repeatingCount >= 3)
                    priorityQueue.offer(repeatingCount);
                repeatingCount = 1;
            }
            prevC = c;
        }
        if (repeatingCount >= 3)
            priorityQueue.offer(repeatingCount);
        int typeCount = lowerCaseCount + upperCaseCount + digitCount;
        int changes = 0;
        if (length == 5) {
            if (typeCount >= 2 || repeatingCount == 5)
                return typeCount;
            else
                return 1;
        } else if (length < 5)
            return 6 - length;
        while (!priorityQueue.isEmpty() && length > 20) {
            int curRepeatingCount = priorityQueue.poll();
            changes++;
            length--;
            curRepeatingCount--;
            if (curRepeatingCount >= 3)
                priorityQueue.offer(curRepeatingCount);
        }
        if (length > 20)
            changes += length - 20 + typeCount;
        else {
            int curCount = 0;
            while (!priorityQueue.isEmpty()) {
                int curRepeatingCount = priorityQueue.poll();
                curCount += curRepeatingCount / 3;
            }
            changes += Math.max(curCount, typeCount);
        }
        return changes;
    }
}