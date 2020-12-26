class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int length = students.length;
        for (int i = 0; i < length; i++)
            queue.offer(students[i]);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int student = queue.poll();
                if (student == sandwiches[index])
                    index++;
                else
                    queue.offer(student);
            }
            if (size == queue.size())
                break;
        }
        return queue.size();
    }
}