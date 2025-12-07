/**
 * Docs
 */
public class Package implements Comparable<Package>
{
    private int priority;
    private String description;
    private String destination;
    private int size; // 1 = small, 2 = medium, 3 = large
    private boolean sent;
    
    public Package(int priority, String description, String destination)
    {
        this.priority = priority;
        this.description = description;
        this.destination = destination;
        this.size = 1;
        this.sent = false;
    }
    
    public Package(int priority, String description, String destination, int size)
    {
        this.priority = priority;
        this.description = description;
        this.destination = destination;
        this.size = size;
        this.sent = false;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getDestination()
    {
        return destination;
    }

    public boolean isSent()
    {
        return sent;
    }

    public void setSent(boolean sent)
    {
        this.sent = sent;
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
            "description='" + description + '\'' +
            ", priority=" + priority +
            ", size=" + getSizeDescription() +
            ", destination='" + destination + '\'' +
            ", sent=" + sent +
            '}';
    }
}