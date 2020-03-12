class Solution {
    public boolean canReorderDoubled(int[] A) {
        List<Integer> list = new ArrayList<Integer>();
        int length = A.length;
        for (int i = 0; i < length; i++)
            list.add(A[i]);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                if (Math.abs(num1) != Math.abs(num2))
                    return Math.abs(num1) - Math.abs(num2);
                else
                    return num1 - num2;
            }
        });
        while (list.size() > 0) {
            int num = list.remove(0);
            int num2 = num * 2;
            int index = list.indexOf(num2);
            if (index >= 0)
                list.remove(index);
            else
                return false;
        }
        return true;
    }
}