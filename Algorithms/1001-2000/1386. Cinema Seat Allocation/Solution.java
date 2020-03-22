class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, new Comparator<int[]>() {
            public int compare(int[] reservedSeat1, int[] reservedSeat2) {
                return reservedSeat1[0] - reservedSeat2[0];
            }
        });
        int families = 0;
        int prevRow = 0;
        Set<Integer> set = new HashSet<Integer>();
        int length = reservedSeats.length;
        for (int i = 0; i < length; i++) {
            int[] reservedSeat = reservedSeats[i];
            int row = reservedSeat[0], column = reservedSeat[1];
            if (column == 1 || column == 10)
                continue;
            if (row == prevRow)
                set.add(column);
            else {
                if (prevRow > 0) {
                    families += maxNumberOfFamilies(set);
                    set.clear();
                }
                set.add(column);
                for (int j = prevRow + 1; j < row; j++)
                    families += 2;
                prevRow = row;
            }
        }
        families += maxNumberOfFamilies(set);
        for (int j = prevRow + 1; j <= n; j++)
            families += 2;
        return families;
    }

    public int maxNumberOfFamilies(Set<Integer> set) {
        if (set.isEmpty())
            return 2;
        boolean flag1 = set.contains(4) || set.contains(5);
        boolean flag2 = set.contains(6) || set.contains(7);
        if (flag1 && flag2)
            return 0;
        else if (!flag1 && !flag2)
            return 1;
        else if (flag1) {
            if (!set.contains(8) && !set.contains(9))
                return 1;
            else
                return 0;
        } else {
            if (!set.contains(2) && !set.contains(3))
                return 1;
            else
                return 0;
        }
    }
}