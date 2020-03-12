/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> crawlUrls = new ArrayList<String>();
        String hostname = startUrl.split("//")[1].split("/")[0];
        Queue<String> queue = new LinkedList<String>();
        queue.offer(startUrl);
        while (!queue.isEmpty()) {
            String url = queue.poll();
            if (!crawlUrls.contains(url))
                crawlUrls.add(url);
            List<String> nextUrls = htmlParser.getUrls(url);
            for (String nextUrl : nextUrls) {
                if (nextUrl.indexOf(hostname) == 7 && !crawlUrls.contains(nextUrl))
                    queue.offer(nextUrl);
            }
        }
        return crawlUrls;
    }
}