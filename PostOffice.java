import java.util.HashMap;
import java.util.Map;
/**
 * PostOffice class is the individual post office itself. The post office houses each individual package. When the first postOffice is accessed,
 * a static final hashMap is created, which maps the name of the PostOffice to the instance of the PostOffice.
 * @author Leo Denizen
 * @version 12/8/2025
 */
public class PostOffice
{
    private static final Map<String, PostOffice> registry = new HashMap<>();

    private Package[] packageQueue;
    private int heapSize;
    private postOfficeUtil heapUtil;
    private Package[] sentStorage;
    private int sentCount;
    private String name;
    /**
     * Constructor for a postoffice
     * @param postsize the size of the postoffice
     */
    public PostOffice(int postsize)
    {
        packageQueue = new Package[postsize + 1]; 
        heapSize = 0;
        heapUtil = new postOfficeUtil();
        sentStorage = new Package[postsize + 1];
        sentCount = 0;
        name = null;
    }
    /**
     * Constructor for a postoffice
     * @param postsize the size of the office
     * @param name the name of the office
     */
    public PostOffice(int postsize, String name)
    {
        this(postsize);
        this.name = name;
        register(name);
    }
    /**
     * Register this PostOffice instance under a name so it can be looked up later.
     * @param officeName name to register this PostOffice under
     */
    public void register(String officeName)
    {
        registry.put(officeName, this);
    }

    /**
     * Look up a registered PostOffice by name.
     * @param officeName the name under which the office was registered
     * @return the PostOffice instance or null if none registered under that name
     */
    public static PostOffice getOfficeByName(String officeName)
    {
        return registry.get(officeName);
    }

    /**
     * Returns the registered name of this PostOffice, or null if none.
     * @return office name or null
     */
    public String getName()
    {
        return name;
    }

    /**
     * Adds to this office's priority queue.
     * @param pkg Package to add
     */
    public void add(Package pkg)
    {
        packageQueue = (Package[]) heapUtil.insert(packageQueue, pkg, heapSize);
        heapSize++;
    }
    
    /**
     * Adds to this office's priority queue.
     * @param weight the weight of the package
     * @param destination the end destination of the package
     * @param description the content of the package
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
     * Finds the size of the package
     * @param weight the weight of the package
     * @return the size of the package
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
     * @param priority the priority of the package
     * @param description the content of the package
     * @param destination the end destination of the package
     * @param size the size of the package
     */
    public void add(int priority, String description, String destination, int size)
    {
        Package pkg = new Package(priority, description, destination, size);
        add(pkg);
    }
    
    /**
     * Adds a package to the priority queue with priority (small size by default)
     * @param priority the priority of the package
     * @param description the contents of the package
     * @param destination the end destination of the package
     */
    public void add(int priority, String description, String destination)
    {
        Package pkg = new Package(priority, description, destination);
        add(pkg);
    }
    
    /**
     * Retrieves and removes the highest priority package from the queue
     * @return the next package
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
     * @return the next package
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
     * @return the size of the queue
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
     * @param description the content in packages to find
     * @return true if the queue has the package
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

    /**
     * Store a package into this office's sent-storage area. 
     * @param pkg package to store
     */
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

    /**
     * Returns the number of packages currently stored in sent-storage.
     * @return sent-storage count
     */
    public int getSentCount()
    {
        return sentCount;
    }
}
