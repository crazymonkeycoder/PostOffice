/**
 * Package class represents the individual packages in the priority queue of packages to be sent or dropped off at a certain location
 * @author Leo Denizen
 * @version 12/8/2025
 */
public class Package implements Comparable<Package>
{
    private int priority;
    private String description;
    private String destination;
    private int size; // 1 = small, 2 = medium, 3 = large
    private boolean sent;
    /**
     * Constructor for a package
     * @param priority the priority of the package
     * @param description the contents of the package
     * @param destination the end destination of the package
     */
    public Package(int priority, String description, String destination)
    {
        this.priority = priority;
        this.description = description;
        this.destination = destination;
        this.size = 1;
        this.sent = false;
    }
    /**
     * Construtor for a package
     * @param priority the priority of the package
     * @param description the contents of the package
     * @param destination the end destination of the package
     * @param size the size of the package
     */
    public Package(int priority, String description, String destination, int size)
    {
        this.priority = priority;
        this.description = description;
        this.destination = destination;
        this.size = size;
        this.sent = false;
    }
    
    /**
     * Returns the priority value of this package. Higher numbers indicate higher priority.
     * @return priority integer
     */
    public int getPriority()
    {
        return priority;
    }
    
    /**
     * Sets the priority for this package.
     * @param priority new priority value
     */
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    
    /**
     * Returns the description of this package.
     * @return description string
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Returns the destination name for this package
     * @return destination office name
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Returns whether this package has been marked as sent.
     * @return true if sent, false otherwise
     */
    public boolean isSent()
    {
        return sent;
    }

    /**
     * Marks this package as sent or not sent
     * @param sent true to mark the package as sent
     */
    public void setSent(boolean sent)
    {
        this.sent = sent;
    }
    
    /**
     * Returns the size for this package.
     * @return size/type code
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * Returns description of the package size
     * @return size description string
     */
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
    
    /**
     * Compare packages by priority
     * @param other the other Package to compare against
     * @return negative if this < other, zero if equal, positive if this > other
     */
    @Override
    public int compareTo(Package other)
    {
        // Higher priority comes first (max heap)
        return Integer.compare(other.priority, this.priority);
    }
    
    /**
     * Returns a compact string representation of the package
     * @return string describing this package
     */
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