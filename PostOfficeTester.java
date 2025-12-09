import java.util.Scanner;
import java.util.ArrayList;

/**
 * The main method for testing the post office.
 */
public class PostOfficeTester {
    /**
     * Main method that tests out the postal system.
     * 
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        Scanner sc = new Scanner(System.in);
        PostOffice SanJose = new PostOffice(100, "SanJose");
        PostalWorker bob = new PostalWorker("bob", SanJose);
        PostOffice MountainView = new PostOffice(100, "MountainView");
        PostalWorker alice = new PostalWorker("alice", MountainView);
        ArrayList<PostOffice> listDest = new ArrayList<>();
        listDest.add(SanJose);
        listDest.add(MountainView);
        int task = 0;
        while (task != 7)
        {
            System.out.println("\nWelcome to the San Jose post office!" + 
                                    "Please let me know how I can help you.");
            System.out.println("Current locations:");
            for (int i = 0; i < listDest.size(); i++)
            {
                System.out.print(listDest.get(i).getName());
                if (i != listDest.size() - 1)
                {
                    System.out.print(", ");
                } else
                {
                    System.out.println();
                }
            }
            System.out.println("1. Submit a package to be sent");
            System.out.println("2. Check on the status of a package");
            System.out.println("3. Check how long our package queue is");
            System.out.println("4. Test sending package");
            System.out.println("5. Add new PostOffice");
            System.out.println("6. Submit an envelope");
            System.out.println("7. Exit");
            System.out.print("Enter what you want to do: ");

            task = sc.nextInt();
            sc.nextLine();

            if (task == 1) 
            {
                System.out.println("Got it! Please follow these instructions:");
                
                System.out.print("Enter priority (1-10, higher = more urgent): ");
                int priority = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter package weight: ");
                Double weight = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter destination: ");
                String destination = sc.nextLine();

                System.out.print("Enter 1 word description: ");
                String description = sc.nextLine();

                bob.addPackage(priority, weight, destination, description);
                System.out.println("Package added successfully!");
            } 
            else if (task == 2) 
            {
                System.out.println("Got it! Please enter the description:");
                String desc = sc.nextLine();
                System.out.println(bob.checkStatus(desc));
            } 
            else if (task == 3) 
            {
                System.out.println("Got it! Our queue is " + bob.queueLen() + " packages long.");
            } 
            else if (task == 4)
            {
                System.out.println("Attempting to send top package from SanJose...");
                String dest = bob.sendTopPackageTo();
                if (dest.equals(""))
                {
                    System.out.println("No package sent (queue empty or destination not found)");
                }
                else
                {
                    System.out.println("\nPackages received at " + dest + ":");
                    PostOffice.getOfficeByName(dest).displaySentStorage();
                }
            }
            else if(task == 5)
            {
                System.out.print("Enter office name: ");
                String postname = sc.nextLine();
                System.out.print("Enter size: ");
                int postsize = Integer.parseInt(sc.nextLine());
                PostOffice a = new PostOffice(postsize, postname);
                listDest.add(a);
                System.out.println("Office '" + postname + "' created successfully!");
            }
            else if(task == 6)
            {
                System.out.print("Enter priority (1-10): ");
                int priority = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter destination: ");
                String destination = sc.nextLine();
                
                System.out.print("Enter description: ");
                String description = sc.nextLine();
                
                System.out.println("Select envelope type:");
                System.out.println("1. Postcard");
                System.out.println("2. File");
                System.out.println("3. Document");
                System.out.print("Enter type (1-3): ");
                int envelopeType = sc.nextInt();
                sc.nextLine();
                
                bob.addEnvelope(priority, destination, description, envelopeType);
                System.out.println("Envelope added successfully!");
            }
            else if (task == 7) 
            {
                System.out.println("See you next time.");
            } 
            else 
            {
                System.out.println("That's not a choice.");
            }
        }
        sc.close();
    }
}
