class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0)
                str += "Fizz";
            if (i % 5 == 0)
                str += "Buzz";
            if (str.length() == 0)
                str = String.valueOf(i);
            list.add(str);
        }
        return list;
    }
}