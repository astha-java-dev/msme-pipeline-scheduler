package schedular;

import model.Slot;
import model.Task;

import java.util.*;

public class GreedyScheduler {

    private List<Slot> slots;

    public GreedyScheduler(List<Slot> slots) {
        this.slots = slots;
    }

    public Map<String, Integer> scheduleTasks(List<Task> tasks) {

        Map<String, Integer> assignment = new HashMap<>();

        // High priority tasks first
        tasks.sort((t1, t2) ->
                Double.compare(t2.getWeight(), t1.getWeight()));

        for (Task task : tasks) {

            boolean assigned = false;

            // Check slots within SLA window
            for (int i = task.getStartSlot();
                 i <= task.getEndSlot(); i++) {

                Slot slot = slots.get(i);

                // Resource check
                if (!slot.canAssign(task)) {
                    continue;
                }

                // Conflict check
                if (hasConflict(task, slot)) {
                    continue;
                }

                // Assign task
                slot.assignTask(task);

                assignment.put(task.getTaskId(),
                        slot.getSlotId());

                assigned = true;

                break;
            }

            // Infeasible task
            if (!assigned) {
                System.out.println(
                        "Could not assign task: "
                                + task.getTaskId());
            }
        }

        return assignment;
    }

    private boolean hasConflict(Task task, Slot slot) {

        for (Task assignedTask : slot.getAssignedTasks()) {

            if (task.getConflicts()
                    .contains(assignedTask.getTaskId())) {

                return true;
            }
        }

        return false;
    }
    
    public double calculatePenalty(
            Map<String, Integer> assignment,
            List<Task> tasks) {

        double penalty = 0;

        for (Task task : tasks) {

            int slot = assignment.get(task.getTaskId());

            // Base weighted delay penalty
            penalty += task.getWeight() * slot;
        }

        // Load imbalance penalty
        double imbalancePenalty = 0;

        for (Slot slot : slots) {
            imbalancePenalty += slot.getAssignedTasks().size();
        }

        return penalty + imbalancePenalty;
    }
}