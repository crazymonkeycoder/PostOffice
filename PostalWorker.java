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

    public void addPackage(Double w, String dest, String desc)
    {
        location.add(w,dest,desc);
    }
    public static String checkStatus(String desc)
    {
        return "";
    }
    public static int queueLen()
    {
        return 0;
    }
}