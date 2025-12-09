/**
 * PostalWorker is a type of person that works at a postal office.
 *
 * @author Urvi S., Leo D.
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
    /**
     * Add a package by weight, destination and description. The PostOffice will
     * determine the size from the provided weight and create a Package instance.
     * @param w weight of the package
     * @param dest destination office name
     * @param desc description of the package
     */
    public void addPackage(int p, Double w, String dest, String desc)
    {
        location.add(p,desc,dest,w);
    }

    /**
     * Add an envelope to the post office with type selection.
     * envelopeType: 1 = postcard, 2 = file, 3 = document
     * @param priority numeric priority for the envelope
     * @param dest destination office name
     * @param desc description of envelope contents
     * @param envelopeType envelope type code
     */
    public void addEnvelope(int priority, String dest, String desc, int envelopeType)
    {
        Package env = new Envelope(priority, desc, dest, envelopeType);
        location.add(env);
    }

    /**
     * Check whether a package with the given description exists in this worker's office.
     * @param desc description to search for
     * @return "In queue" if found, otherwise "Not found"
     */
    public String checkStatus(String desc)
    {
        if (location.hasPackage(desc))
        {
            return "In queue";
        }
        return "Not found";
    }

    /**
     * Return the number of packages currently queued at this worker's PostOffice.
     * @return queue length
     */
    public int queueLen()
    {
        return location.getQueueSize();
    }

    /**
     * Remove the top (highest-priority) package from this worker's PostOffice
     * and store it in the destination PostOffice's sent-storage area. The package
     * will be marked as sent. If the destination office is not registered or the
     * queue is empty, an empty string is returned.
     * @return destination name if a package was sent, otherwise empty string
     */
    public String sendTopPackageTo()
    {
        Package p = location.getNextPackage();
        if (p == null) 
        {
            return "";
        }
        p.setSent(true);
        PostOffice postinst = PostOffice.getOfficeByName(p.getDestination());
        if(postinst == null)
        {
            return "";
        }
        postinst.storeSentPackage(p);
        return p.getDestination();
    }
}
