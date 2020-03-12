class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int length = deck.length;
        List<Integer> originalList = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            originalList.add(i);
        int[] orderArray = new int[length];
        int orderIndex = 0;
        while (originalList.size() > 0) {
            int num = originalList.remove(0);
            orderArray[orderIndex++] = num;
            if (originalList.size() > 0)
                originalList.add(originalList.remove(0));
        }
        int[] originalOrdering = new int[length];
        for (int i = 0; i < length; i++) {
            int num = deck[i];
            int index = orderArray[i];
            originalOrdering[index] = num;
        }
        return originalOrdering;
    }
}