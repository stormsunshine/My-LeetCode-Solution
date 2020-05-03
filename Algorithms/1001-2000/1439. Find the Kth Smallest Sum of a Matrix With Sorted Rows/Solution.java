class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int rows = mat.length, columns = mat[0].length;
        int sum0 = 0;
        for (int i = 0; i < rows; i++)
            sum0 += mat[i][0];
        if (k == 1)
            return sum0;
        int[] indices = new int[rows];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int row = 0; row < rows; row++)
                sum += mat[row][indices[row]];
            priorityQueue.offer(sum);
            flag = nextState(indices, columns, true);
        }
        if (!flag)
            return priorityQueue.peek();
        while (flag) {
            int curKth = priorityQueue.peek();
            int sum = 0;
            for (int row = 0; row < rows; row++)
                sum += mat[row][indices[row]];
            if (sum < curKth) {
                priorityQueue.offer(sum);
                priorityQueue.poll();
                flag = nextState(indices, columns, true);
            } else
                flag = nextState(indices, columns, false);
        }
        return priorityQueue.peek();
    }

    public boolean nextState(int[] indices, int columns, boolean flag) {
        int rows = indices.length;
        int index = 0;
        if (flag) {
            indices[index]++;
            while (index < rows - 1 && indices[index] >= columns) {
                indices[index] -= columns;
                index++;
                indices[index]++;
            }
        } else {
            while (index < rows - 1 && indices[index] == 0)
                index++;
            if (index == rows - 1)
                return false;
            indices[index] = 0;
            index++;
            indices[index]++;
            while (index < rows - 1 && indices[index] >= columns) {
                indices[index] -= columns;
                index++;
                indices[index]++;
            }
        }
        return indices[rows - 1] < columns;
    }
}