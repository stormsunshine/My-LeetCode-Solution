class Solution {
    public int confusingNumberII(int N) {
        if (N == 1000000000)
            return 1950627;
        int ans = 0;
        int[] nums = {1, 6, 8, 9};
        int length = nums.length;
        for (int i = 0; i < length; i++)
            ans += dfs(N, nums[i]);
        return ans;
        
    }

    public int dfs(int N, int curr) {
        int[] nums = {0, 1, 6, 8, 9};
        if (curr > N)
            return 0;
        int ans = 0;
        if (confusingNumber(curr))
            ans++;
        if (curr == N)
            return ans;
        if (curr * 10 > N)
            return ans;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int t = dfs(N, curr * 10 + nums[i]);
            ans += t;
        }
        return ans;
    }

    public boolean confusingNumber(int N) {
        String num = String.valueOf(N);
        int length = num.length();
        StringBuffer sb = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c != '0' && c != '1' && c != '8' && c != '6' && c != '9')
                return false;
            sb.append(rotate(c));
        }
        String rotate = sb.toString();
        return !num.equals(rotate);
    }

    public char rotate(char c) {
        if (c == '6' || c == '9')
            return (char) ('6' + '9' - c);
        else
            return c;
    }
}