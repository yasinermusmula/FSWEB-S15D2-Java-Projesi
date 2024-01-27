import entity.Priority;
import entity.Status;
import entity.Task;
import entity.TaskData;
import utils.SetUtils;

import java.util.LinkedHashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Task taskDummy = new Task("s15d2","dumnmy desc","bob", Priority.HIGH, Status.ASSIGNED);
        Task taskForBob2 = new Task("s15d2","dummy desc","bob",Priority.HIGH,Status.IN_PROGRESS);

        Task taskForAnn = new Task("s15d2","dumnmy desc","ann",Priority.HIGH,Status.ASSIGNED);
        Task taskForAnn2 = new Task("s15d2","dummy desc","ann",Priority.HIGH,Status.IN_PROGRESS);

        Task taskForCarol = new Task("s15d2","dumnmy desc","carol",Priority.HIGH,Status.ASSIGNED);
        Task taskForCarol2 = new Task("s15d2","dummy desc","carol",Priority.HIGH,Status.IN_PROGRESS);

        Task taskunAssigned = new Task("s15d2","dummy desc",null,Priority.HIGH,Status.ASSIGNED);
        Task taskunAssigned2 = new Task("s15d2","dummy desc",null,Priority.HIGH,Status.IN_PROGRESS);

        Set<Task> annTasks = new LinkedHashSet<>();
        annTasks.add(taskForAnn);
        annTasks.add(taskForAnn2);
        annTasks.add(taskDummy);

        Set<Task> bobTasks = new LinkedHashSet<>();
        bobTasks.add(taskDummy);
        bobTasks.add(taskForBob2);

        Set<Task> carolTask = new LinkedHashSet<>();
        carolTask.add(taskForCarol);
        carolTask.add(taskForCarol2);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(taskunAssigned2);
        unassignedTasks.add(taskunAssigned);

        Set<Task> allTasks = new LinkedHashSet<>();
        allTasks.add(taskForBob2);
        allTasks.add(taskDummy);
        allTasks.add(taskForAnn2);
        allTasks.add(taskForAnn);
        allTasks.add(taskForCarol);
        allTasks.add(taskForCarol2);
        allTasks.add(taskunAssigned2);
        allTasks.add(taskunAssigned);

        TaskData taskData = new TaskData(annTasks,bobTasks,carolTask,unassignedTasks);

        System.out.println("---------**1**---------");
        Set<Task> all = taskData.getTask("all");
        SetUtils.printAllSet(all);
        System.out.println("---------**2**---------");
        SetUtils.printAllSet(taskData.getTask("bob"));
        SetUtils.printAllSet(taskData.getTask("ann"));
        SetUtils.printAllSet(taskData.getTask("carol"));
        System.out.println("---------**3**---------");
        Set<Task> unAssignedTasks = taskData.getDifference(allTasks, taskData.getTask("all"));
        SetUtils.printAllSet(unAssignedTasks);

        System.out.println("---------**4**---------");
        System.out.println("---------**-BOB-ANN**---------");
        Set<Task> intersectionBobAnn = taskData.getIntersect(bobTasks,annTasks);
        SetUtils.printAllSet(intersectionBobAnn);
        System.out.println("---------**-BOB-CAROL**---------");
        Set<Task> intersectionBobCarol = taskData.getIntersect(bobTasks,carolTask);
        SetUtils.printAllSet(intersectionBobCarol);
        System.out.println("---------**-ANN-CAROL**---------");
        Set<Task> intersectionAnnCarol = taskData.getIntersect(annTasks, carolTask);
        SetUtils.printAllSet(intersectionAnnCarol);
    }
}