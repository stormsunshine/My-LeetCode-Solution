class Solution {
    public String maximumBinaryString(String binary) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '0')
                deque.offerLast(i);
        }
        while (deque.size() >= 2) {
            int index = deque.pollFirst();
            deque.pollFirst();
            deque.offerFirst(index + 1);
        }
        char[] array = new char[length];
        Arrays.fill(array, '1');
        while (!deque.isEmpty())
            array[deque.pollFirst()] = '0';
        return new String(array);
    }
}