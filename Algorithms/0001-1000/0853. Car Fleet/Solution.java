class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        if (length == 0)
            return 0;
        Struct[] array = new Struct[length];
        for (int i = 0; i < length; i++)
            array[i] = new Struct(position[i], 1.0 * (target - position[i]) / speed[i]);
        Arrays.sort(array);
        int fleets = 1;
        int index = length - 1;
        while (index > 0) {
            if (array[index].time < array[index - 1].time)
                fleets++;
            else
                array[index - 1] = array[index];
            index--;
        }
        return fleets;
    }
}

class Struct implements Comparable<Struct> {
    int position;
    double time;

    public Struct(int position, double time) {
        this.position = position;
        this.time = time;
    }

    public int compareTo(Struct struct2) {
        return this.position - struct2.position;
    }
}