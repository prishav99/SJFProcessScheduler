public interface WaitingQueueADT<T extends Comparable<T>> {

  /**
   * Inserts a newObject in the priority queue
   * @param newObject the object to be inserted
   */
    
    public void enqueue(T newObject); 
  
  /**
   * Removes and returns the item with the highest priority
   * @return The item with the highest priority
   */
    
    public T dequeue(); 

    /**
     * Returns without removing the item with the highest priority
     * @return The item with highest priority
     */
    
  public T peek(); 

  /**
   * Returns size of the waiting queue
   * @return Size of the waiting queue
   */
  
  public int size(); 

  /**
   * Checks if the waiting queue is empty
   * @return True if the queue is empty and false otherwise
   */
  
  public boolean isEmpty(); 
}