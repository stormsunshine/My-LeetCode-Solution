class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++)
                nums[i] = i;
            return nums;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= 9; i++) {
            int nextDigit1 = i - K, nextDigit2 = i + K;
            if (nextDigit1 >= 0)
                queue.offer(i * 10 + nextDigit1);
            if (K != 0 && nextDigit2 < 10)
                queue.offer(i * 10 + nextDigit2);
        }
        for (int digits = 3; digits <= N; digits++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int lastDigit = num % 10;
                int nextDigit1 = lastDigit - K, nextDigit2 = lastDigit + K;
                if (nextDigit1 >= 0)
                    queue.offer(num * 10 + nextDigit1);
                if (K != 0 && nextDigit2 < 10)
                    queue.offer(num * 10 + nextDigit2);
            }
        }
        int length = queue.size();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++)
            nums[i] = queue.poll();
        return nums;
    }
}