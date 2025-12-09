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
    public void addPackage(Double w, String dest, String desc)
    {
        location.add(w,dest,desc);
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
        PostOffice postinst = PostOffice.getOfficeByName(p.getDestination());
        if(postinst == null)
        {
            return "";
        }
        postinst.storeSentPackage(p);
        return p.getDestination();
    }
}