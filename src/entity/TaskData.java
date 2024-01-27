package entity;

import entity.Task;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    private Set<Task> unassignedTasks;
    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTask(String employee){
        switch (employee){
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(annsTasks,bobsTasks,carolsTasks);
            default:
                throw new IllegalArgumentException("Invalid Employee");
        }
    }

    public Set<Task> getUnion(Set<Task>... sets){
        HashSet total = new LinkedHashSet();
        for (Set<Task> taskset : sets){
            total.addAll(taskset);
        }
        return total;
    }

    public Set<Task> getIntersect(Set<Task> firstSet, Set<Task> secondSet){
        Set<Task> intersections = new HashSet<>(firstSet);
        intersections.retainAll(secondSet);
        return  intersections;
    }

    public Set<Task> getDifference(Set<Task> setFirst, Set<Task> setSecond){
        Set<Task> removingSet = new HashSet<>(setFirst);
        removingSet.retainAll(setSecond);
        return removingSet;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public void setAnnsTasks(Set<Task> annsTasks) {
        this.annsTasks = annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public void setBobsTasks(Set<Task> bobsTasks) {
        this.bobsTasks = bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void setCarolsTasks(Set<Task> carolsTasks) {
        this.carolsTasks = carolsTasks;
    }
}
