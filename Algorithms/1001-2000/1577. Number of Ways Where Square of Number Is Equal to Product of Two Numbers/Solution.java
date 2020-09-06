class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map1.getOrDefault(num, 0) + 1;
            map1.put(num, count);
        }
        for (int num : nums2) {
            int count = map2.getOrDefault(num, 0) + 1;
            map2.put(num, count);
        }
        Set<Integer> set1 = map1.keySet();
        Set<Integer> set2 = map2.keySet();
        int triplets = 0;
        for (int num1 : set1) {
            int count1 = map1.get(num1);
            long square = (long) num1 * num1;
            for (int num2 : set2) {
                if (square % num2 == 0) {
                    int num3 = (int) (square / num2);
                    if (num2 == num3) {
                        int count2 = map2.get(num2);
                        int curTriplets = count1 * count2 * (count2 - 1) / 2;
                        triplets += curTriplets;
                    } else if (num2 < num3 && set2.contains(num3)) {
                        int count2 = map2.get(num2), count3 = map2.get(num3);
                        int curTriplets = count1 * count2 * count3;
                        triplets += curTriplets;
                    }
                }
            }
        }
        for (int num1 : set2) {
            int count1 = map2.get(num1);
            long square = (long) num1 * num1;
            for (int num2 : set1) {
                if (square % num2 == 0) {
                    int num3 = (int) (square / num2);
                    if (num2 == num3) {
                        int count2 = map1.get(num2);
                        int curTriplets = count1 * count2 * (count2 - 1) / 2;
                        triplets += curTriplets;
                    } else if (num2 < num3 && set1.contains(num3)) {
                        int count2 = map1.get(num2), count3 = map1.get(num3);
                        int curTriplets = count1 * count2 * count3;
                        triplets += curTriplets;
                    }
                }
            }
        }
        return triplets;
    }
}