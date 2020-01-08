/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int total = 0;
        char[] temp = new char[4];
        int index = 0;
        while (index < n) {
            count = read4(temp);
            for (int i = 0; i < count; i++)
                buf[index + i] = temp[i];
            total += count;
            index += 4;
        }
        return Math.min(total, n);
    }
}