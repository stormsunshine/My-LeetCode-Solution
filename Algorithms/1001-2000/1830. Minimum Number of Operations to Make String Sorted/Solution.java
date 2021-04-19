class Solution {
    static final int MODULO = 1000000007;

    public int makeStringSorted(String s) {
        int length = s.length();
        int[] f = new int[26];
        int[] p = new int[length + 1];
        int[] all = new int[length + 1];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            f[c - 'a']++;
        }
        p[1] = 1;
        all[1] = 1;
        for (int i = 2; i <= length; i++) {
            int temp = power(i, MODULO - 2);
            p[i] = (int) ((long) p[i - 1] * temp % MODULO);
            all[i] = (int) ((long) all[i - 1] * i % MODULO);
        }
        int operations = 0;
        for (int i = 0; i < length; i++) {
            int left = length - 1 - i;
            int index = s.charAt(i) - 'a';
            for (int j = 0; j < index; j++) {
                int up = all[left];
                if (f[j] != 0) {
                    f[j]--;
                    for (int k = 0; k < 26; k++) {
                        if (f[k] != 0)
                            up = (int) ((long) up * p[f[k]] % MODULO);
                    }
                    operations =  (operations + up) % MODULO;
                    f[j]++;
                }
            }
            f[index]--;
        }
        return operations;
   }

   public int power(int x, int n) {
       int power = 1;
       while (n > 0) {
           if (n % 2 == 1)
               power = (int) ((long) power * x % MODULO);
           x = (int) ((long) x * x % MODULO);
           n /= 2;
       }
       return power;
    }
}