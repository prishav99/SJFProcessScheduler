public class ProcessSchedulerTests {
    
    /**
     * The main method which drives the test class
     * @param args
     */
    public static void main(String[] args) {
        testDequeueCustomProcessQueue();
        testEnqueueCustomProcessQueue();
        testRun();
        testEnqueueCustomProcessDequeue2();
    }
    
    /**
     
     * Checks the correctness of the enqueue 
     * operation implemented in the CustomProcessQueue class
     * @return True if the method works correctly and false otherwise
     */
    public static boolean testEnqueueCustomProcessQueue(){
        CustomProcessQueue queue = new CustomProcessQueue(); // Creating a queue
        CustomProcess process1 = new CustomProcess(15); // and adding
        CustomProcess process2 = new CustomProcess(18); // different
        CustomProcess process3 = new CustomProcess(9); // processes
        CustomProcess process4 = new CustomProcess(3); // to it
        queue.enqueue(process1); // Adding the processes
        queue.enqueue(process2);
        queue.enqueue(process3);
        queue.enqueue(process4);
        if(queue.getHeap()[1].getBurstTime() == 3 && queue.getHeap()[2].getBurstTime() == 9 &&
                queue.getHeap()[3].getBurstTime() == 15 && queue.getHeap()[4].getBurstTime() == 18) {
            // should be true if the percolation algorithm is correct
            return true;
        }
        return false;
    } 
   
    /**
     * Checks the correctness of the dequeue
     * operation implemented in the CustomProcessQueue class     
     * @return True if the method works correctly and false otherwise
     */
    
    public static boolean testDequeueCustomProcessQueue(){
        CustomProcess process1 = new CustomProcess(15); // Creating some new processes
        CustomProcess process2 = new CustomProcess(18);
        CustomProcess process3 = new CustomProcess(9);
        CustomProcess process4 = new CustomProcess(3);
        CustomProcessQueue queue = new CustomProcessQueue();// Creating a queue
        queue.enqueue(process1); // Adding the processes to the queue
        queue.enqueue(process2);
        queue.enqueue(process3);
        queue.enqueue(process4);
        queue.dequeue(); // Removing the topmost elements from the queue
        queue.dequeue();
        if(queue.getHeap()[1].getBurstTime() == 15 && queue.getHeap()[2].getBurstTime() == 18) {
            // Should be true if the percolating algorithm is true
            return true;
        }
        return false;
    }
    
    /**
     * Checks the correctness of the run() method
     * @return true if the implementation is correct and false otherwise
     */

    
    public static boolean testRun() {
        ProcessScheduler running = new ProcessScheduler(); // Creating a new scheduler
        String string = "";
        String data = "";
        string += running.run(); // There are no processes added
        data += "Starting 0 processes\n\n";
        data += "\nTime 0 : All scheduled processes completed.\n";
        if(string.equals(data)) { // Should be true
            return true;
        }
        return false;
        
    }
    
    /**
     * Checks the correctness of the dequeue() method
     * @return true if the implementation is correct and false otherwise
     */
    
    public static boolean testEnqueueCustomProcessDequeue2() {
        CustomProcess process1 = new CustomProcess(15); // Creating some new processes
        CustomProcess process2 = new CustomProcess(18);
        CustomProcess process3 = new CustomProcess(9);
        CustomProcess process4 = new CustomProcess(3);
        CustomProcessQueue queue = new CustomProcessQueue(); // Creating anew queue
        queue.enqueue(process1); // Adding the processes
        queue.enqueue(process2);
        queue.enqueue(process3);
        queue.enqueue(process4);
        queue.dequeue(); // Removing some processes
        queue.dequeue();
        if(queue.size() == 2) { // Should be true
            return true;
        }
        return false;
    }

    
}