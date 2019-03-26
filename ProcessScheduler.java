
import java.util.Scanner;

/**
 * This class the defines the scheduler and some of its functions
 * 
 * @author Rishav
 */

public class ProcessScheduler {
  private int runningTime; // The total running time after the last run
  private int numProcessesRun; // The number of processes run so far
  private CustomProcessQueue queue; // The custom process queue for this scheduler

  /**
   * The constructor
   */

  public ProcessScheduler() {
    this.queue = new CustomProcessQueue(); // Initializing the queue
    this.runningTime = 0; // Initializing the runtime
    this.numProcessesRun = 0; // Initializing the number of processes run so far
  }

  /**
   * Adds the process to the scheduler according to the priority
   * 
   * @param process The process being added
   */

  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process); // Adding the process

  }

  /**
   * Runs all the processes in the schedule and returns their details as a string
   * 
   * @return The string containing the details of the processes run
   */

  public String run() {
    String data = "";
    if (queue.size() == 1) { // if there is only one process
      data += "Starting " + queue.size() + " process\n\n";
    } else {
      data += "Starting " + queue.size() + " processes\n\n";
    }
    while (!this.queue.isEmpty()) {
      CustomProcess runProcess = queue.dequeue(); // Getting the most priority process to execute it
      data += "Time " + this.runningTime + " : Process ID " + runProcess.getProcessId()
          + " Starting.\n";
      this.runningTime = runProcess.getBurstTime() + this.runningTime; // Updating runtime
      data += "Time " + this.runningTime + ": Process ID " + runProcess.getProcessId()
          + " Completed.\n";
      numProcessesRun++; // Incrementing the number of processes run.
    }

    data += "\nTime " + this.runningTime + " : All scheduled processes completed.\n";
    return data;
  }

  /**
   * The main method which drives the application
   * 
   * @param args String arguments
   * @throws NumberFormatException
   */

  public static void main(String[] args) throws NumberFormatException {
    ProcessScheduler running = new ProcessScheduler(); // Creating a new scheduler
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========\n");
    Scanner scnr = new Scanner(System.in); // Scanner to take input
    while (true) {

      System.out.println("Enter command:");
      System.out.println("[schedule <burstTime>] or [s <burstTime>]");
      System.out.println("[run] or [r]");
      System.out.println("[quit] or [q]");
      System.out.println();
      String input = scnr.nextLine();
      int burstTime;
      String[] commands = new String[] {};
      commands = input.split(" "); // Removing the spaces between input
      String command = commands[0]; // The first character

      if (command.equals("s") || command.equals("schedule")) {
        try {
          burstTime = Integer.parseInt(commands[1]); // Converting the second character
          // to integer;
          if (burstTime <= 0) {
            System.out.println("WARNING: burst time MUST be greater than 0!\n");
            continue; // To keep going on
          }
        } catch (NumberFormatException ne) { // If the input is not an integer
          System.out.println("WARNING: burst time MUST be an integer!\n");
          continue;
        }

        CustomProcess process = new CustomProcess(burstTime); // Creating a new
        // process
        running.scheduleProcess(process); // and adding it to the schedule
        System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
            + process.getBurstTime() + "\n");
        continue;
      }
      if (command.equals("r") || command.equals("run")) {
        System.out.println(running.run()); // Call the run method
        continue;
      }

      if (command.equals("q") || command.equals("quit")) {
        System.out.println(running.numProcessesRun + " processes run in " + running.runningTime
            + " units of time!\n" + "Thank you for using our scheduler!\n" + "Goodbye!\n");
        break; // Quit
      }

      else {
        System.out.println("WARNING: Please enter a valid command!");
        continue;
      }
    }

  }
}
