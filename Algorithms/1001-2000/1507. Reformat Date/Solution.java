class Solution {
    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 1; i <= 12; i++)
            map.put(months[i - 1], i);
        String[] array = date.split(" ");
        int year = Integer.parseInt(array[2]);
        int month = map.get(array[1]);
        int day = Integer.parseInt(array[0].substring(0, array[0].length() - 2));
        return String.format("%d-%02d-%02d", year, month, day);
    }
}