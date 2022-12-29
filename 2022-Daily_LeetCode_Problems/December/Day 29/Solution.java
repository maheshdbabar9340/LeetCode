// https://leetcode.com/problems/single-threaded-cpu/description/

class Solution {
    public int[] getOrder(int[][] tasks) {
        Comparator<Task> processingTimeThenIndex = Comparator
				.comparingInt(Task::getProcessingTime)
                .thenComparingInt(Task::getIndex);
        Queue<Task> allTasks = new PriorityQueue<>(
                Comparator.comparingInt(Task::getEnqueueTime).thenComparing(processingTimeThenIndex)
        );
        Queue<Task> availableTasks = new PriorityQueue<>(processingTimeThenIndex);
        for (int i = 0, tasksLength = tasks.length; i < tasksLength; i++) {
            int[] taskInfo = tasks[i];
            Task task = new Task(taskInfo[0], taskInfo[1], i);
            allTasks.offer(task);
        }
        int virtualTime = 0;
        int orderCounter = 0;
        int[] order = new int[tasks.length];
        while (!allTasks.isEmpty() || !availableTasks.isEmpty()) {
            final Task nextTask;
            if (availableTasks.isEmpty()) {
                nextTask = allTasks.poll();
                virtualTime = nextTask.getEnqueueTime();
            } else {
                nextTask = availableTasks.poll();
            }
            order[orderCounter++] = nextTask.getIndex();
            virtualTime += nextTask.getProcessingTime();
            while (!allTasks.isEmpty() && allTasks.peek().getEnqueueTime() <= virtualTime) {
                availableTasks.offer(allTasks.poll());
            }
        }
        return order;
    }
}

class Task {
    final int enqueueTime;
    final int processingTime;
    final int index;

    public Task(
            final int enqueueTime,
            final int processingTime,
            final int index) {
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
        this.index = index;
    }

    public int getEnqueueTime() {
        return enqueueTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getIndex() {
        return index;
    }
}
