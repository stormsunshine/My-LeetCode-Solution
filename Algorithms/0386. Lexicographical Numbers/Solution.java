class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicalOrderList = new ArrayList<Integer>();
        int num = 1;
        for (int i = 1; i <= n; i++) {
            lexicalOrderList.add(num);
            if (num * 10 <= n)
                num *= 10;
            else {
                if (num >= n)
                    num /= 10;
                num++;
                while (num % 10 == 0)
                    num /= 10;
            }
        }
        return lexicalOrderList;
    }
}