
package model;

import java.util.ArrayList;
import java.util.List;

public class Slot {

    private int slotId;

    private double remainingCpu;
    private double remainingRam;
    private double remainingGpu;
    private double remainingNetwork;

    private List<Task> assignedTasks;

    public Slot(int slotId,
                double cpu,
                double ram,
                double gpu,
                double network) {

        this.slotId = slotId;

        this.remainingCpu = cpu;
        this.remainingRam = ram;
        this.remainingGpu = gpu;
        this.remainingNetwork = network;

        assignedTasks = new ArrayList<>();
    }

    public boolean canAssign(Task task) {

        return remainingCpu >= task.getCpu()
                && remainingRam >= task.getRam()
                && remainingGpu >= task.getGpu()
                && remainingNetwork >= task.getNetwork();
    }

    public void assignTask(Task task) {

        remainingCpu -= task.getCpu();
        remainingRam -= task.getRam();
        remainingGpu -= task.getGpu();
        remainingNetwork -= task.getNetwork();

        assignedTasks.add(task);
    }

    public int getSlotId() {
        return slotId;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", remainingCpu=" + remainingCpu +
                ", remainingRam=" + remainingRam +
                ", remainingGpu=" + remainingGpu +
                ", remainingNetwork=" + remainingNetwork +
                ", assignedTasks=" + assignedTasks +
                '}';
    }
}
