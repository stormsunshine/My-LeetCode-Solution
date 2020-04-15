class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Polynomial polynomial = parse(expression);
        Map<String, Integer> evaluateMap = new HashMap<String, Integer>();
        int length = evalvars.length;
        for (int i = 0; i < length; i++)
            evaluateMap.put(evalvars[i], evalints[i]);
        Polynomial evaluation = polynomial.evaluate(evaluateMap);
        List<String> list = evaluation.toList();
        return list;
    }

    public Polynomial parse(String expression) {
        List<Polynomial> bucket = new ArrayList<Polynomial>();
        List<Character> operators = new ArrayList<Character>();
        int index = 0, length = expression.length();
        while (index < length) {
            if (expression.charAt(index) == '(') {
                int balance = 0;
                int curIndex = index;
                while (curIndex < length) {
                    if (expression.charAt(curIndex) == '(')
                        balance++;
                    else if (expression.charAt(curIndex) == ')')
                        balance--;
                    if (balance == 0)
                        break;
                    curIndex++;
                }
                Polynomial curPolynomial = parse(expression.substring(index + 1, curIndex));
                bucket.add(curPolynomial);
                index = curIndex;
            } else if (Character.isLetterOrDigit(expression.charAt(index))) {
                boolean flag = true;
                int curIndex = index;
                while (curIndex < length) {
                    if (expression.charAt(curIndex) == ' ') {
                        Polynomial curPolynomial = make(expression.substring(index, curIndex));
                        bucket.add(curPolynomial);
                        flag = false;
                        break;
                    }
                    curIndex++;
                }
                if (flag) {
                    Polynomial polynomial = make(expression.substring(index));
                    bucket.add(polynomial);
                }
                index = curIndex;
            } else if (expression.charAt(index) != ' ')
                operators.add(expression.charAt(index));
            index++;
        }
        for (int i = operators.size() - 1; i >= 0; i--) {
            if (operators.get(i) == '*') {
                Polynomial newPolynomial = combine(bucket.get(i), bucket.remove(i + 1), operators.remove(i));
                bucket.set(i, newPolynomial);
            }
        }
        if (bucket.isEmpty())
            return new Polynomial();
        Polynomial polynomial = bucket.get(0);
        int size = operators.size();
        for (int i = 0; i < size; i++)
            polynomial = combine(polynomial, bucket.get(i + 1), operators.get(i));
        return polynomial;
    }

    public Polynomial make(String expression) {
        Polynomial polynomial = new Polynomial();
        List<String> list = new ArrayList<String>();
        if (Character.isDigit(expression.charAt(0)))
            polynomial.update(list, Integer.valueOf(expression));
        else {
            list.add(expression);
            polynomial.update(list, 1);
        }
        return polynomial;
    }

    public Polynomial combine(Polynomial polynomial1, Polynomial polynomial2, char operator) {
        if (operator == '+')
            return polynomial1.add(polynomial2);
        else if (operator == '-')
            return polynomial1.subtract(polynomial2);
        else if (operator == '*')
            return polynomial1.multiply(polynomial2);
        else
            return null;
    }
}

class Polynomial {
    Map<List<String>, Integer> countMap;

    public Polynomial() {
        countMap = new HashMap<List<String>, Integer>();
    }

    public void update(List<String> key, int count) {
        int newCount = countMap.getOrDefault(key, 0) + count;
        countMap.put(key, newCount);
    }

    public Polynomial add(Polynomial polynomial2) {
        Polynomial sum = new Polynomial();
        Set<List<String>> keySet1 = countMap.keySet();
        for (List<String> list : keySet1)
            sum.update(list, countMap.get(list));
        Set<List<String>> keySet2 = polynomial2.countMap.keySet();
        for (List<String> list : keySet2)
            sum.update(list, polynomial2.countMap.get(list));
        return sum;
    }

    public Polynomial subtract(Polynomial polynomial2) {
        Polynomial difference = new Polynomial();
        Set<List<String>> keySet1 = countMap.keySet();
        for (List<String> list : keySet1)
            difference.update(list, countMap.get(list));
        Set<List<String>> keySet2 = polynomial2.countMap.keySet();
        for (List<String> list : keySet2)
            difference.update(list, -polynomial2.countMap.get(list));
        return difference;
    }

    public Polynomial multiply(Polynomial polynomial2) {
        Polynomial product = new Polynomial();
        Set<List<String>> keySet1 = countMap.keySet();
        Set<List<String>> keySet2 = polynomial2.countMap.keySet();
        for (List<String> list1 : keySet1) {
            for (List<String> list2 : keySet2) {
                List<String> newList = new ArrayList<String>();
                for (String str : list1)
                    newList.add(str);
                for (String str : list2)
                    newList.add(str);
                Collections.sort(newList);
                product.update(newList, countMap.get(list1) * polynomial2.countMap.get(list2));
            }
        }
        return product;
    }

    public Polynomial evaluate(Map<String, Integer> evaluateMap) {
        Polynomial polynomial = new Polynomial();
        Set<List<String>> keySet = countMap.keySet();
        for (List<String> list : keySet) {
            int count = countMap.get(list);
            List<String> freeList = new ArrayList<String>();
            for (String str : list) {
                if (evaluateMap.containsKey(str))
                    count *= evaluateMap.get(str);
                else
                    freeList.add(str);
            }
            polynomial.update(freeList, count);
        }
        return polynomial;
    }

    public int compareList(List<String> list1, List<String> list2) {
        int size1 = list1.size(), size2 = list2.size();
        if (size1 != size2)
            return size2 - size1;
        else {
            for (int i = 0; i < size1; i++) {
                String str1 = list1.get(i), str2 = list2.get(i);
                if (!str1.equals(str2))
                    return str1.compareTo(str2);
            }
            return 0;
        }
    }

    public List<String> toList() {
        List<String> list = new ArrayList<String>();
        List<List<String>> keyList = new ArrayList<List<String>>(countMap.keySet());
        Collections.sort(keyList, new Comparator<List<String>>() {
            public int compare(List<String> list1, List<String> list2) {
                return compareList(list1, list2);
            }
        });
        for (List<String> key : keyList) {
            int count = countMap.get(key);
            if (count != 0) {
                StringBuffer sb = new StringBuffer();
                sb.append(count);
                for (String str : key) {
                    sb.append('*');
                    sb.append(str);
                }
                list.add(sb.toString());
            }
        }
        return list;
    }
}