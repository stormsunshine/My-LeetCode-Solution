class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> divisions = new HashMap<String, Double>();
        Map<String, Set<String>> paths = new HashMap<String, Set<String>>();
        int size = equations.size();
        for (int i = 0; i < size; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String variable1 = equation.get(0), variable2 = equation.get(1);
            divisions.put(variable1 + "/" + variable2, value);
            Set<String> set1 = paths.getOrDefault(variable1, new HashSet<String>());
            set1.add(variable2);
            paths.put(variable1, set1);
            if (value != 0) {
                divisions.put(variable2 + "/" + variable1, 1 / value);
                Set<String> set2 = paths.getOrDefault(variable2, new HashSet<String>());
                set2.add(variable1);
                paths.put(variable2, set2);
            }
        }
        Set<String> variablesSet = paths.keySet();
        int length = queries.size();
        double[] answers = new double[length];
        for (int i = 0; i < length; i++) {
            List<String> query = queries.get(i);
            String variable1 = query.get(0), variable2 = query.get(1);
            if (!variablesSet.contains(variable1) || !variablesSet.contains(variable2))
                answers[i] = -1;
            else if (variable1.equals(variable2))
                answers[i] = 1;
            else {
                double answer = calculate(divisions, paths, variable1, variable2);
                answers[i] = answer;
            }
        }
        return answers;
    }

    public double calculate(Map<String, Double> divisions, Map<String, Set<String>> paths, String src, String dst) {
        Map<String, String> predecessorMap = new HashMap<String, String>();
        boolean flag = false;
        Set<String> visitedSet = new HashSet<String>();
        visitedSet.add(src);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            String variable = queue.poll();
            if (variable.equals(dst)) {
                flag = true;
                break;
            }
            Set<String> nextVariables = paths.getOrDefault(variable, new HashSet<String>());
            for (String nextVariable : nextVariables) {
                if (visitedSet.add(nextVariable)) {
                    predecessorMap.put(nextVariable, variable);
                    queue.offer(nextVariable);
                }
            }
        }
        if (!flag)
            return -1;
        List<String> pathList = new ArrayList<String>();
        String curVariable = dst;
        while (curVariable != null) {
            pathList.add(curVariable);
            curVariable = predecessorMap.get(curVariable);
        }
        double answer = 1;
        for (int i = pathList.size() - 2; i >= 0; i--) {
            String variable1 = pathList.get(i + 1), variable2 = pathList.get(i);
            Double division = divisions.get(variable1 + "/" + variable2);
            if (division == null)
                return -1;
            else
                answer *= division;
        }
        return answer;
    }
}