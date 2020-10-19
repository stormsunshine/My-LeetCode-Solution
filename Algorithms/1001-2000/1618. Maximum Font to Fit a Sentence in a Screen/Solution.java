/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        if (!canFit(text, w, h, fonts[0], fontInfo))
            return -1;
        int low = 0, high = fonts.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (canFit(text, w, h, fonts[mid], fontInfo))
                low = mid;
            else
                high = mid - 1;
        }
        return low >= 0 ? fonts[low] : -1;
    }

    public boolean canFit(String text, int w, int h, int fontSize, FontInfo fontInfo) {
        int height = fontInfo.getHeight(fontSize);
        if (height > h)
            return false;
        int totalWidth = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            int width = fontInfo.getWidth(fontSize, ch);
            totalWidth += width;
            if (totalWidth > w)
                return false;
        }
        return true;
    }
}