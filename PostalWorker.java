/**
 * PostalWorker is a type of person that works at a postal office.
 *
 * @author Urvi S.
 * @version 12/05/2025
 */

public class PostalWorker extends Person {
    private PostOffice location;
    public PostalWorker(String name, PostOffice l)
    {
        super.setName(name);
        super.setJob("postoffice worker");
        location = l;
    }
    //do you mind implementing a priority for the tester?
    //also should the worker send the package?
    public void addPackage(int priority, Double w, String dest, String desc)
    {
        int size = determineSizeFromWeight(w);
        location.add(priority,dest,desc, size);
    }

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
     * Add an envelope to the post office with type selection
     * envelopeType: 1 = postcard, 2 = file, 3 = document
     */
    public void addEnvelope(int priority, String dest, String desc, int envelopeType)
    {
        Package env = new Envelope(priority, desc, dest, envelopeType);
        location.add(env);
    }

    public String checkStatus(String desc)
    {
        if (location.hasPackage(desc))
        {
            return "In queue";
        }
        return "Not found";
    }

    public int queueLen()
    {
        return location.getQueueSize();
    }

    public String sendTopPackageTo()
    {
        Package p = location.getNextPackage();
        if (p == null) 
        {
            return "";
        }
        p.setSent(true);
        PostOffice destinationOffice = PostOffice.getOfficeByName(p.getDestination());
        if (destinationOffice == null)
        {
            System.out.println("Warning: Destination office '" + p.getDestination() + "' not found!");
            return "";
        }
        destinationOffice.storeSentPackage(p);
        System.out.println("Package '" + p.getDescription() + "' sent to " + p.getDestination());
        return p.getDestination();
    }
}
