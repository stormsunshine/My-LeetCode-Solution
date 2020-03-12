class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long ipStart = ipToLong(ip);
        long ipEnd = ipStart + n;
        List<String> list = new ArrayList<String>();
        long ipCur = ipStart;
        while (ipCur < ipEnd) {
            long lowestBit = Long.lowestOneBit(ipCur);
            while (ipCur + lowestBit > ipEnd)
                lowestBit /= 2;
            int bitNum = (int) (Math.log(lowestBit) / Math.log(2));
            String block = longToIP(ipCur) + "/" + (32 - bitNum);
            list.add(block);
            ipCur += lowestBit;
        }
        return list;
    }

    public long ipToLong(String ip) {
        String[] array = ip.split("\\.");
        long ipLong = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            ipLong <<= 8;
            ipLong += Long.parseLong(array[i]);
        }
        return ipLong;
    }

    public String longToIP(long num) {
        int[] array = new int[4];
        for (int i = 3; i >= 0; i--) {
            int remainder = (int) (num % 256);
            array[i] = remainder;
            num /= 256;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            if (i > 0)
                sb.append('.');
            sb.append(array[i]);
        }
        return sb.toString();
    }
}