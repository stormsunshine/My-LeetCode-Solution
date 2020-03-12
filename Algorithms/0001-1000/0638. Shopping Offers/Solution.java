class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int itemsCount = price.size();
        int totalOriginal = 0;
        for (int i = 0; i < itemsCount; i++)
            totalOriginal += price.get(i) * needs.get(i);
        int size = special.size();
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> curSpecial = special.get(i);
            boolean deleteFlag = false;
            int original = 0;
            for (int j = 0; j < itemsCount; j++) {
                int itemCount = curSpecial.get(j);
                if (itemCount > needs.get(j)) {
                    deleteFlag = true;
                    break;
                } else
                    original += price.get(j) * itemCount;
            }
            int specialAmount = curSpecial.get(itemsCount);
            if (specialAmount >= original)
                deleteFlag = true;
            if (deleteFlag)
                special.remove(i);
            else {
                curSpecial.set(itemsCount, specialAmount - original);
                special.set(i, curSpecial);
            }
        }
        return backtrack(price, special, needs, totalOriginal);
    }

    public int backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int total) {
        int totalNeeds = 0;
        for (int need : needs)
            totalNeeds += need;
        if (totalNeeds == 0)
            return total;
        int minTotal = total;
        int itemsCount = price.size();
        for (List<Integer> curSpecial : special) {
            boolean flag = true;
            for (int i = 0; i < itemsCount; i++) {
                if (curSpecial.get(i) > needs.get(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; i < itemsCount; i++)
                    needs.set(i, needs.get(i) - curSpecial.get(i));
                total += curSpecial.get(itemsCount);
                int nextTotal = backtrack(price, special, needs, total);
                minTotal = Math.min(minTotal, nextTotal);
                for (int i = 0; i < itemsCount; i++)
                    needs.set(i, needs.get(i) + curSpecial.get(i));
                total -= curSpecial.get(itemsCount);
            }
        }
        return minTotal;
    }
}