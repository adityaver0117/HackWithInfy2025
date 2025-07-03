import java.util.Arrays;

public class ActivitySelection {
    static class Activity {
        int start;
        int finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
        public String toString() {
            return "(" + start + ", " + finish + ")";
        }
    }

    public static void selectActivities(int[] start, int[] finish) {
        int n = start.length;
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], finish[i]);
        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        System.out.println("Selected activities:");

        System.out.println(activities[0]);
        int lastFinishTime = activities[0].finish;
        for (int i = 1; i < n; i++) {
            if (activities[i].start >= lastFinishTime) {
                System.out.println(activities[i]);
                lastFinishTime = activities[i].finish;
            }
        }
    }

    public static void main(String[] args) {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] finishTimes = {2, 4, 6, 7, 9, 9};

        selectActivities(startTimes, finishTimes);
    }
}