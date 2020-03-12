/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    int size = 0;
    int i = 0;
    char[] temp = new char[4];
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (size == 0) {
                size = read4(temp);
                if (size == 0)
                    break;
            }
            while (index < n && i < size)
                buf[index++] = temp[i++];
            if (i == size) {
                i = 0;
                size = 0;
            }     
        }
        return index;
    }
}