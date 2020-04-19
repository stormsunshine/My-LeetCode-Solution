class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> itemSet = new HashSet<String>();
        Map<Integer, Map<String, Integer>> tableOrdersMap = new HashMap<Integer, Map<String, Integer>>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            itemSet.add(foodItem);
            Map<String, Integer> ordersMap = tableOrdersMap.getOrDefault(tableNumber, new HashMap<String, Integer>());
            int count = ordersMap.getOrDefault(foodItem, 0) + 1;
            ordersMap.put(foodItem, count);
            tableOrdersMap.put(tableNumber, ordersMap);
        }
        List<List<String>> displayList = new ArrayList<List<String>>();
        List<String> itemList = new ArrayList<String>(itemSet);
        Collections.sort(itemList);
        Map<String, Integer> itemIndexMap = new HashMap<String, Integer>();
        List<String> header = new ArrayList<String>();
        header.add("Table");
        int size = itemList.size();
        for (int i = 0; i < size; i++) {
            String item = itemList.get(i);
            header.add(item);
            itemIndexMap.put(item, i + 1);
        }
        displayList.add(header);
        List<List<String>> bodyList = new ArrayList<List<String>>();
        Set<Integer> tableSet = tableOrdersMap.keySet();
        for (int tableNumber : tableSet) {
            List<String> curLine = new ArrayList<String>();
            curLine.add(String.valueOf(tableNumber));
            for (int i = 0; i < size; i++)
                curLine.add("0");
            Map<String, Integer> ordersMap = tableOrdersMap.get(tableNumber);
            Set<String> curItemSet = ordersMap.keySet();
            for (String item : curItemSet) {
                int count = ordersMap.get(item);
                int index = itemIndexMap.get(item);
                curLine.set(index, String.valueOf(count));
            }
            bodyList.add(curLine);
        }
        Collections.sort(bodyList, new Comparator<List<String>>() {
            public int compare(List<String> list1, List<String> list2) {
                int tableNumber1 = Integer.parseInt(list1.get(0));
                int tableNumber2 = Integer.parseInt(list2.get(0));
                return tableNumber1 - tableNumber2;
            }
        });
        int tablesCount = bodyList.size();
        for (int i = 0; i < tablesCount; i++)
            displayList.add(bodyList.get(i));
        return displayList;
    }
}