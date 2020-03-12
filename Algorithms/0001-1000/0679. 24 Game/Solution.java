class Solution {
    public boolean judgePoint24(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = permuteUnique(nums);
        char[] operators = {'+', '-', '*', '/'};
        for (List<Integer> permutation : permutations) {
            for (int i = 0; i < 64; i++) {
                int[] base4 = toBase4(i);
                char[] curOperators = new char[3];
                for (int j = 0; j < 3; j++)
                    curOperators[j] = operators[base4[j]];
                char[][] postfixes = new char[4][7];
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++)
                        postfixes[j][k] = (char) (permutation.get(k) + '0');
                    for (int k = 4; k < 7; k++)
                        postfixes[j][k] = curOperators[k - 4];
                }
                char temp2 = postfixes[1][3];
                postfixes[1][3] = postfixes[1][4];
                postfixes[1][4] = temp2;
                char temp3 = postfixes[2][5];
                postfixes[2][5] = postfixes[2][3];
                postfixes[2][3] = postfixes[2][2];
                postfixes[2][2] = postfixes[2][4];
                postfixes[2][4] = temp3;
                char temp4 = postfixes[3][4];
                postfixes[3][4] = postfixes[3][3];
                postfixes[3][3] = postfixes[3][2];
                postfixes[3][2] = temp4;
                for (int j = 0; j < 4; j++) {
                    if (equals24(postfixes[j]))
                        return true;
                }
            }
        }
        return false;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            list.add(nums[i]);
        permutations.add(list);
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = nums[i];
        nextPermutation(array);
        while (!Arrays.equals(nums, array)) {
            List<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < length; i++)
                permutation.add(array[i]);
            permutations.add(permutation);
            nextPermutation(array);
        }
        return permutations;
    }

    public void nextPermutation(int[] array) {
        int length = array.length;
        int index = -1;
        int curNum = -1;
        for (int i = length - 1; i > 0; i--) {
            int difference = array[i] - array[i - 1];
            if (difference > 0) {
                index = i - 1;
                curNum = array[i - 1];
                break;
            }
        }
        if (index < 0) {
            Arrays.sort(array);
            return;
        }
        int nextIndex = -1;
        int nextNum = Integer.MAX_VALUE;
        for (int i = index + 1; i < length; i++) {
            if (array[i] > curNum && array[i] < nextNum) {
                nextIndex = i;
                nextNum = array[i];
            }
        }
        array[index] = nextNum;
        array[nextIndex] = curNum;
        Arrays.sort(array, index + 1, length);
    }

    public int[] toBase4(int num) {
        int[] base4 = new int[3];
        for (int i = 2; i >= 0; i--) {
            int remainder = num % 4;
            base4[i] = remainder;
            num /= 4;
        }
        return base4;
    }

    public boolean equals24(char[] postfix) {
        int length = postfix.length;
        Stack<int[]> stack = new Stack<int[]>();
        for (int i = 0; i < length; i++) {
            char c = postfix[i];
            if (Character.isDigit(c)) {
                int num = c - '0';
                stack.push(new int[]{num, 1});
            } else {
                int[] num2 = stack.pop();
                int[] num1 = stack.pop();
                int[] newNum = new int[2];
                switch (c) {
                    case '+':
                        newNum[0] = num1[0] * num2[1] + num2[0] * num1[1];
                        newNum[1] = num1[1] * num2[1];
                        break;
                    case '-':
                        newNum[0] = num1[0] * num2[1] - num2[0] * num1[1];
                        newNum[1] = num1[1] * num2[1];
                        break;
                    case '*':
                        newNum[0] = num1[0] * num2[0];
                        newNum[1] = num1[1] * num2[1];
                        break;
                    case '/':
                        newNum[0] = num1[0] * num2[1];
                        newNum[1] = num1[1] * num2[0];
                        break;
                    default:
                }
                int gcd = gcd(newNum[0], newNum[1]);
                newNum[0] /= gcd;
                newNum[1] /= gcd;
                if (newNum[1] < 0) {
                    newNum[0] = -newNum[0];
                    newNum[1] = -newNum[1];
                }
                stack.push(newNum);
            }
        }
        int[] result = stack.pop();
        return result[0] == 24 && result[1] == 1;
    }

    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0)
            return 1;
        while (a != 0 && b != 0) {
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            b %= a;
        }
        return a == 0 ? b : a;
    }
}