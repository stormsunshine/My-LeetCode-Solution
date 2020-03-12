class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int friendsCount = friends.length;
        int[] colors = new int[friendsCount];
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        colors[id] = GRAY;
        int friendLevel = 0;
        while (!queue.isEmpty() && friendLevel < level) {
            friendLevel++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curId = queue.poll();
                int[] curFriends = friends[curId];
                for (int friend : curFriends) {
                    if (colors[friend] == WHITE) {
                        colors[friend] = GRAY;
                        queue.offer(friend);
                    }
                }
                colors[curId] = BLACK;
            }
        }
        Map<String, Integer> videosCountsMap = new HashMap<String, Integer>();
        boolean flag = false;
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            List<String> curVideos = watchedVideos.get(curId);
            for (String video : curVideos) {
                int count = videosCountsMap.getOrDefault(video, 0);
                count++;
                videosCountsMap.put(video, count);
            }
        }
        List<VideoFrequency> list = new ArrayList<VideoFrequency>();
        Set<String> videosSet = videosCountsMap.keySet();
        for (String video : videosSet) {
            int count = videosCountsMap.get(video);
            VideoFrequency videoFrequency = new VideoFrequency(video, count);
            list.add(videoFrequency);
        }
        Collections.sort(list);
        List<String> videos = new ArrayList<String>();
        for (VideoFrequency videoFrequency : list)
            videos.add(videoFrequency.video);
        return videos;
    }
}

class VideoFrequency implements Comparable<VideoFrequency> {
    String video;
    int frequency;

    public VideoFrequency() {
        
    }

    public VideoFrequency(String video, int frequency) {
        this.video = video;
        this.frequency = frequency;
    }

    public int compareTo(VideoFrequency videoFrequency2) {
        if (this.frequency != videoFrequency2.frequency)
            return this.frequency - videoFrequency2.frequency;
        else
            return this.video.compareTo(videoFrequency2.video);
    }
}