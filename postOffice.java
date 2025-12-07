public class PostOffice
{
    private Package[] packageQueue;
    private int heapSize;
    private postOfficeUtil heapUtil;
    private Package[] sentStorage;
    private int sentCount;

    public PostOffice(int postsize)
    {
        packageQueue = new Package[postsize + 1]; 
        heapSize = 0;
        heapUtil = new postOfficeUtil();
        sentStorage = new Package[postsize + 1];
        sentCount = 0;
    }
    public void add(Package pkg)
    {
        packageQueue = (Package[]) heapUtil.insert(packageQueue, pkg, heapSize);
        heapSize++;
    }
    
    /**
     * Weight determines size: <= 5 is small, <= 15 is medium, > 15 is large
     */
    public void add(Double weight, String destination, String description)
    {
        int size = determineSizeFromWeight(weight);
        Package pkg = new Package(1, description, destination, size);
        add(pkg);
    }

    /**
     * Prints descriptions of all packages in sent storage.
     */
    public void displaySentStorage()
    {
        System.out.println("Sent storage contents:");
        for (int i = 1; i <= sentCount; i++)
        {
            if (sentStorage[i] != null)
            {
                System.out.println("- " + sentStorage[i].getDescription());
            }
        }
    }
    
    /**
     * <= 5 pounds = small 
     * <= 15 pounds = medium 
     * > 15 pounds = large 
     */
    private int determineSizeFromWeight(Double weight)
    {
        if (weight <= 5.0)
        {
            return 1;
        }
        if (weight <= 15.0)
        {
            return 2;
        }
        return 3;
    }
    
    /**
     * Adds a package to the priority queue with priority and size
     */
    public void add(int priority, String description, String destination, int size)
    {
        Package pkg = new Package(priority, description, destination, size);
        add(pkg);
    }
    
    /**
     * Adds a package to the priority queue with priority (small size by default)
     */
    public void add(int priority, String description, String destination)
    {
        Package pkg = new Package(priority, description, destination);
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

    /**
     * Returns true if a package with the given description exists in the queue
     */
    public boolean hasPackage(String description)
    {
        for (int i = 1; i <= heapSize; i++)
        {
            if (packageQueue[i] != null && packageQueue[i].getDescription().equals(description))
            {
                return true;
            }
        }
        return false;
    }

    public void storeSentPackage(Package pkg)
    {
        if (pkg == null)
        {
            return;
        }
        if (sentCount + 1 >= sentStorage.length)
        {
            Package[] bigger = new Package[sentStorage.length * 2];
            for (int i = 0; i < sentStorage.length; i++)
            {
                bigger[i] = sentStorage[i];
            }
            sentStorage = bigger;
        }
        sentCount++;
        sentStorage[sentCount] = pkg;
    }
    public int getSentCount()
    {
        return sentCount;
    }
}