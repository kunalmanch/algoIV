package my.practice.misc;

import java.util.*;

/**
 * Given an array of task and k wait time for which a repeated task needs to wait k time to execute again.
 * Return overall unit time it will take to complete all the task.
 */
public class WaitTime {

    public static int waitTime(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            boolean execute = true;
            if (map.containsKey(task)) {
                int prevTime = map.get(task);
                if (time - prevTime <= k) {
                    i--;
                    execute = false;
                }
            }

            if (execute) {
                map.put(task, time);
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'a', 'b', 'c', 'a', 'c', 'b', 'd', 'a'};
        System.err.println(waitTime(tasks, 4));
    }
}
