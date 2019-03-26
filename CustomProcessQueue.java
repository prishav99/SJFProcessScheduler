import java.util.Arrays;

/**
 * This class defines the storage of the processes and some of its functions
 * 
 * @author rishav
 *
 */

public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * The constructor
   */

  public CustomProcessQueue() {
    heap = new CustomProcess[INITIAL_CAPACITY]; // Empty the array
  }

  /**
   * Adds the process to the array and sorts it
   * 
   * @param newObject The process to be added
   */

  @Override
  public void enqueue(CustomProcess newObject) {
    if (size >= heap.length) {
      heap = Arrays.copyOf(heap, heap.length * 2); // Create a copy
      // of the array with twice its size
    }
    for (int i = 1; i < heap.length; i++) { // Adding the new process to the heap
      if (heap[i] == null) {
        heap[i] = newObject;
        minHeapPercolateUp(i); // Sorting the added process

        break;
      }
    }

    size++; // Incrementing the number of processes
  }

  /**
   * Removes and returns a process from the array and sorts the remaining processes
   * 
   * @return The removed process
   */

  @Override
  public CustomProcess dequeue() {
    CustomProcess process;
    if (heap[1] != null) {
      process = heap[1]; // Sending the bottom node
      heap[1] = heap[size]; // to the top
      heap[size] = null;
      size--;
      minHeapPercolateDown(1); // Sorting the heap after the removal
      return process;
    }
    return null;
  }

  /**
   * Returns the first process in the array
   * 
   * @return The first process in the array
   */

  @Override
  public CustomProcess peek() {
    if (heap[1] != null) {
      return heap[1]; // The first process
    }
    return null;
  }

  /**
   * Returns the number of processes
   * 
   * @return The number of processes
   */

  @Override
  public int size() {
    return size; // Gets the size
  }

  /**
   * Checks whether the array is empty or not
   * 
   * @return True if the array is empty and false otherwise
   */

  @Override
  public boolean isEmpty() {
    if (heap[1] == null) { // if queue is empty
      return true;
    }
    return false;
  }

  /**
   * Sorts the element at a given index according to the min heap rule, by taking it upwards
   * 
   * @param index The index from which the element is picked
   */
  private void minHeapPercolateUp(int index) {
    int x;
    while (index > 1) {
      x = (index) / 2; // Index for the parent
      if (heap[index].compareTo(heap[x]) > 0) { // parent has higher priority
        return;
      } else {// Swapping the places of the parent and the current node
        CustomProcess temp;
        temp = heap[index];
        heap[index] = heap[x];
        heap[x] = temp;
        index = x;
      }
    }
  }



  /**
   * Sorts the element at a given index according to the min heap rule, by taking it downwards
   * 
   * @param index The index from which the element is picked
   */


  private void minHeapPercolateDown(int index) {
    while (true) {
      int child1 = 2 * index; // Left child
      int child2 = 2 * index + 1; // Right child
      if (heap[child1] != null && heap[child2] != null) { // Both children exist
        if (heap[child1].compareTo(heap[child2]) > 0) {// child 2 has greater priority
          if (heap[index].compareTo(heap[child2]) > 0) { // child 2 has priority over parent
            CustomProcess temp;
            temp = heap[index];
            heap[index] = heap[child2];
            heap[child2] = temp;
            index = child2;
          } else {
            return;
          }
        } else if (heap[child1].compareTo(heap[child2]) < 0) { // child 1 has greater priority
          if (heap[index].compareTo(heap[child1]) > 0) { // child 1 has priority over parent
            CustomProcess temp;
            temp = heap[index];
            heap[index] = heap[child1];
            heap[child1] = temp;
            index = child1;
          } else {
            return;
          }
        }
      } // 1st if end

      if (heap[child1] != null && heap[child2] == null) { // Only one child exists
        if (heap[index].compareTo(heap[child1]) > 0) {// Child 1 has greater priority
          CustomProcess temp;
          temp = heap[index];
          heap[index] = heap[child1];
          heap[child1] = temp;
          index = child1;
        } else {
          return;
        }
      } // 2nd if end

      if (heap[child1] == null) { // No child exists
        return;
      }

    } // Outermost while loop
  } // method end

  /**
   * Getter method for the queue
   * 
   * @return The queue
   */

  public CustomProcess[] getHeap() {
    return this.heap; // Gets the queue

  }
}
