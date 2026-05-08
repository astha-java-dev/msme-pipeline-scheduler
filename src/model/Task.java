package model;

public class Task {

    private String taskId;

    private double cpu;
    private double ram;
    private double gpu;
    private double network;

    private double weight;

    private int startSlot;
    private int endSlot;

    public Task(String taskId, double cpu, double ram, double gpu,
                double network, double weight,
                int startSlot, int endSlot) {

        this.taskId = taskId;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.network = network;
        this.weight = weight;
        this.startSlot = startSlot;
        this.endSlot = endSlot;
    }

    public String getTaskId() {
        return taskId;
    }

    public double getCpu() {
        return cpu;
    }

    public double getRam() {
        return ram;
    }

    public double getGpu() {
        return gpu;
    }

    public double getNetwork() {
        return network;
    }

    public double getWeight() {
        return weight;
    }

    public int getStartSlot() {
        return startSlot;
    }

    public int getEndSlot() {
        return endSlot;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", gpu=" + gpu +
                ", network=" + network +
                ", weight=" + weight +
                ", startSlot=" + startSlot +
                ", endSlot=" + endSlot +
                '}';
    }
}