package main;

import model.Slot;
import model.Task;
import schedular.GreedyScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Slot> slots = new ArrayList<>();

        // Create 4 slots
        for (int i = 0; i < 4; i++) {

            slots.add(new Slot(
                    i,
                    32,
                    128,
                    8,
                    6.0
            ));
        }

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task(
                "T1",
                8,
                32,
                4,
                1.5,
                5,
                0,
                3,
                Arrays.asList("T2", "T3")
        ));

        tasks.add(new Task(
                "T2",
                4,
                16,
                0,
                3.0,
                4,
                0,
                3,
                Arrays.asList("T1")
        ));

        tasks.add(new Task(
                "T3",
                2,
                8,
                0,
                2.0,
                3,
                0,
                3,
                Arrays.asList("T1")
        ));

        GreedyScheduler scheduler =
                new GreedyScheduler(slots);

        Map<String, Integer> result =
                scheduler.scheduleTasks(tasks);

        System.out.println("Final Assignment:");
        for (Map.Entry<String, Integer> entry
                : result.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " -> Slot "
                            + entry.getValue()
            );
        }

        double penalty =
                scheduler.calculatePenalty(result, tasks);

        System.out.println("Total Penalty: "
                + penalty);
    }
}