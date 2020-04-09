/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    ConcurrentHashMap<String, Boolean> totalUrls = new ConcurrentHashMap<String, Boolean>();
    ReentrantLock resultLock = new ReentrantLock();
    LinkedList<String> resultUrls = new LinkedList<String>();
    ReentrantLock crawlLock = new ReentrantLock();
    LinkedList<String> urlsToCrawl = new LinkedList<String>();
    AtomicInteger choreCount = new AtomicInteger(0);

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = startUrl.substring(7);
        int index = hostName.indexOf("/");
        if (index >= 0)
            hostName = hostName.substring(0, index);
        totalUrls.put(startUrl, true);
        addUrlToResult(startUrl); 
        addUrlToCrawl(startUrl);
        while (true) {
            String urlToCrawl = null;
            crawlLock.lock();
            try {
                urlToCrawl = urlsToCrawl.poll();
            } finally {
                crawlLock.unlock();
            }
            if (urlToCrawl != null) {
                incrementChore();
                Chore chore = new Chore(this, hostName, htmlParser, urlToCrawl);
                Thread thread = new Thread(chore);
                thread.start(); 
            } else {
                if (this.choreCount.get() == 0)
                    break;
                LockSupport.parkNanos(1L);
            }
        }
        resultLock.lock();
        try {
            return resultUrls;
        } finally {
            resultLock.unlock();
        }
    }

    public void addUrlToResult(String url) {
        resultLock.lock();
        try {
            resultUrls.add(url);
        } finally {
            resultLock.unlock();
        }
    }

    public void addUrlToCrawl(String url) {
        crawlLock.lock();
        try {
            urlsToCrawl.add(url);
        } finally {
            crawlLock.unlock();
        }
    }

    public void incrementChore() {
        choreCount.incrementAndGet();
    }

    public void decrementChore() {
        choreCount.decrementAndGet();
    }
}

class Chore implements Runnable {
    Solution solution;
    String hostName;
    HtmlParser htmlParser; 
    String urlToCrawl;

    public Chore(Solution solution, String hostName, HtmlParser htmlParser, String urlToCrawl) {
        this.solution = solution;
        this.hostName = hostName;
        this.htmlParser = htmlParser;
        this.urlToCrawl = urlToCrawl;
    }

    public void run() {
        try {
            List<String> crawledUrls = htmlParser.getUrls(urlToCrawl);
            if (crawledUrls == null || crawledUrls.isEmpty())
                return;
            for (String url : crawledUrls) {
                if (solution.totalUrls.containsKey(url))
                    continue;
                solution.totalUrls.put(url, true);
                String processedUrl = url.substring(7);
                int index = processedUrl.indexOf("/");
                String crawledHostName = index == -1 ? processedUrl : processedUrl.substring(0, index);
                if (crawledHostName.equals(hostName)) {
                    solution.addUrlToResult(url);
                    solution.addUrlToCrawl(url);
                }
            }
        } finally {
            solution.decrementChore(); 
        }
    }
}