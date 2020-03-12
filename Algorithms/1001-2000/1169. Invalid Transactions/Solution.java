class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int length = transactions.length;
        Transaction[] transactionsArray = new Transaction[length];
        for (int i = 0; i < length; i++) {
            String transactionStr = transactions[i];
            String[] array = transactionStr.split(",");
            String name = array[0];
            int time = Integer.parseInt(array[1]);
            int amount = Integer.parseInt(array[2]);
            String city = array[3];
            Transaction curTransaction = new Transaction(name, time, amount, city);
            transactionsArray[i] = curTransaction;
        }
        Arrays.sort(transactionsArray);
        Set<String> invalidSet = new HashSet<String>();
        Transaction transaction0 = transactionsArray[0];
        if (transaction0.amount > 1000)
            invalidSet.add(transaction0.toString());
        int prevIndex = 0;
        for (int i = 1; i < length; i++) {
            Transaction curTransaction = transactionsArray[i];
            if (curTransaction.amount > 1000)
                invalidSet.add(curTransaction.toString());
            while (!transactionsArray[prevIndex].name.equals(curTransaction.name) || curTransaction.time - transactionsArray[prevIndex].time > 60)
                prevIndex++;
            boolean flag = false;
            for (int j = prevIndex; j < i; j++) {
                Transaction prevTransaction = transactionsArray[j];
                if (curTransaction.name.equals(prevTransaction.name) && curTransaction.time - prevTransaction.time <= 60 && !curTransaction.city.equals(prevTransaction.city)) {
                    invalidSet.add(prevTransaction.toString());
                    flag = true;
                }
            }
            if (flag)
                invalidSet.add(curTransaction.toString());
        }
        List<String> invalidTransactionsList = new ArrayList<String>(invalidSet);
        return invalidTransactionsList;
    }
}

class Transaction implements Comparable<Transaction> {
    String name;
    int time;
    int amount;
    String city;

    public Transaction(String name, int time, int amount, String city) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
    }

    public int compareTo(Transaction transaction2) {
        if (!this.name.equals(transaction2.name))
            return this.name.compareTo(transaction2.name);
        else if (this.time != transaction2.time)
            return this.time - transaction2.time;
        else if (!this.city.equals(transaction2.city))
            return this.city.compareTo(transaction2.city);
        else
            return this.amount - transaction2.amount;
    }

    public String toString() {
        return name + "," + time + "," + amount + "," + city;
    }
}