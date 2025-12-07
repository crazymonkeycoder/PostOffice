public class PostOffice
{
    private Package[] priorityQueue;
    private int heapSize;
    private postOfficeUtil heapUtil;
    
    public PostOffice(int postsize)
    {
        priorityQueue = new Package[postsize + 1]; 
        heapSize = 0;
        heapUtil = new postOfficeUtil();
    }
    
    /**
     * Adds a package to the priority queue
     */
    public void addPackage(Package pkg)
    {
        priorityQueue = (Package[]) heapUtil.insert(priorityQueue, pkg, heapSize);
        heapSize++;
    }
    
    /**
     * Retrieves and removes the highest priority package from the queue
     */
    public Package getNextPackage()
    {
        if (heapSize < 1)
        {
            return null;
        }
        Package removed = (Package) heapUtil.remove(priorityQueue, heapSize);
        heapSize--;
        return removed;
    }
    
    /**
     * Gets the highest priority package without removing it
     */
    public Package peekNextPackage()
    {
        if (heapSize < 1)
        {
            return null;
        }
        return priorityQueue[1];
    }
    
    /**
     * Returns the current number of packages in the queue
     */
    public int getQueueSize()
    {
        return heapSize;
    }
    
    /**
     * Displays all packages currently in the queue
     */
    public void displayQueue()
    {
        System.out.println("Priority Queue Contents:");
        for (int i = 1; i <= heapSize; i++)
        {
            System.out.println(priorityQueue[i]);
        }
    }
}