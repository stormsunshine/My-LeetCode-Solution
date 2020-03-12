class Logger {
    Map<String, Integer> messageTimestampMap;

    /** Initialize your data structure here. */
    public Logger() {
        messageTimestampMap = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int previousTimestamp = messageTimestampMap.getOrDefault(message, -1);
        if (previousTimestamp < 0 || timestamp - previousTimestamp >= 10) {
            messageTimestampMap.put(message, timestamp);
            return true;
        } else
            return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */