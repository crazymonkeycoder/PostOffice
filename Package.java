/**
 * Docs
 */
public class Package implements Comparable<Package>
{
    private int priority;
    private String id;
    private String destination;
    private int size; // 1 = small, 2 = medium, 3 = large
    
    public Package(int priority, String id, String destination)
    {
        this.priority = priority;
        this.id = id;
        this.destination = destination;
        this.size = 1;
    }
    
    public Package(int priority, String id, String destination, int size)
    {
        this.priority = priority;
        this.id = id;
        this.destination = destination;
        this.size = size;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public String getSizeDescription()
    {
        if (size == 1)
        {
            return "Small";
        }
        if (size == 2)
        {
            return "Medium";
        }
        if (size == 3)
        {
            return "Large";
        }
        return "Unknown";
    }
    
    @Override
    public int compareTo(Package other)
    {
        // Higher priority comes first (max heap)
        return Integer.compare(other.priority, this.priority);
    }
    
    @Override
    public String toString()
    {
        return "Package{" +
                "id='" + id + '\'' +
                ", priority=" + priority +
                ", size=" + getSizeDescription() +
                ", destination='" + destination + '\'' +
                '}';
    }
}