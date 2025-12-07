/**
 * Docs
 */
public class Package implements Comparable<Package>
{
    private int priority;
    private String id;
    private String destination;
    
    public Package(int priority, String id, String destination)
    {
        this.priority = priority;
        this.id = id;
        this.destination = destination;
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
                ", destination='" + destination + '\'' +
                '}';
    }
}