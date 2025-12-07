public class PostOffice
{
    private Package[] packageQueue;
    private int heapSize;
    private postOfficeUtil heapUtil;

    public PostOffice(int postsize)
    {
        packageQueue = new Package[postsize + 1]; 
        heapSize = 0;
        heapUtil = new postOfficeUtil();
    }
    
    /**
     * Adds a package to the priority queue (small size by default)
     */
    public void add(Package pkg)
    {
        packageQueue = (Package[]) heapUtil.insert(packageQueue, pkg, heapSize);
        heapSize++;
    }
    
    /**
     * Adds a package to the priority queue with priority and size
     */
    public void add(int priority, String id, String destination, int size)
    {
        Package pkg = new Package(priority, id, destination, size);
        add(pkg);
    }
    
    /**
     * Adds a package to the priority queue with priority (small size by default)
     */
    public void add(int priority, String id, String destination)
    {
        Package pkg = new Package(priority, id, destination);
        add(pkg);
    }
    
    public void addPackage(Package pkg)
    {
        add(pkg);
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
        Package removed = (Package) heapUtil.remove(packageQueue, heapSize);
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
        return packageQueue[1];
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
        System.out.println("Queue Contents:");
        for (int i = 1; i <= heapSize; i++)
        {
            System.out.println(packageQueue[i]);
        }
    }
}