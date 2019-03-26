
public class CustomProcess implements Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * The constructor
   * 
   * @param burstTime The burst time of the process
   */

  public CustomProcess(int burstTime) {
    this.burstTime = burstTime; // Assigning this process' burst time
    PROCESS_ID = nextProcessId; // Assigning this process' process ID
    CustomProcess.nextProcessId++; // Incrementing the process ID for the next process
  }

  /**
   * This method compares two processes and returns an integer based on their priorities
   * 
   * @param other The process being compared to
   * @return 1 if the current process has lower priority than the other process and -1 if the
   *         current process has higher priority
   */

  @Override
  public int compareTo(CustomProcess other) {
    if (other.getBurstTime() < this.burstTime) {
      return 1;
    } else if (other.getBurstTime() < this.burstTime) {
      return 1;
    } else {
      return -1;
    }
  }

  /**
   * Getter method for process ID
   * 
   * @return The process ID of the process
   */

  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * Getter method for burst time
   * 
   * @return The burst time of the process
   */

  public int getBurstTime() {
    return burstTime;
  }

}
