/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> employeeImportanceMap = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> employeeSubordinatesMap = new HashMap<Integer, List<Integer>>();
        for (Employee employee : employees) {
            int employeeId = employee.id;
            int importance = employee.importance;
            List<Integer> subordinates = employee.subordinates;
            employeeImportanceMap.put(employeeId, importance);
            if (subordinates != null)
                employeeSubordinatesMap.put(employeeId, subordinates);
        }
        int totalImportance = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            int importance = employeeImportanceMap.get(curId);
            totalImportance += importance;
            List<Integer> subordinates = employeeSubordinatesMap.getOrDefault(curId, new ArrayList<Integer>());
            for (int subordinate : subordinates)
                queue.offer(subordinate);
        }
        return totalImportance;
    }
}