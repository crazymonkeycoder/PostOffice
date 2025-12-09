import java.util.Scanner;
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
        int task = 0;
        while (task != 4)
        {
            System.out.println("Welcome to the post office! Please let me know how I can help you.");
            System.out.println("1. Submit a package to be sent");
            System.out.println("2. Check on the status of a package");
            System.out.println("3. Check how long our package queue is");
            System.out.println("4. Exit");
            System.out.println("5. Test sending package");
            System.out.println("6. Add new PostOffice");
            System.out.print("Enter what you want to do: ");

            task = sc.nextInt();
            sc.nextLine();

            if (task == 1) 
            {
                System.out.print("Got it! Please follow these instructions:");
                
                System.out.print("Enter package weight: ");
                Double weight = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter destination: ");
                String destination = sc.nextLine();

                System.out.print("Enter 1 word description: ");
                String description = sc.nextLine();

                bob.addPackage(weight, destination, description);
            } 
            else if (task == 2) 
            {
                System.out.print("Got it! Please enter the description:");
                String desc = sc.nextLine();
                System.out.print(bob.checkStatus(desc));
            } 
            else if (task == 3) 
            {
                System.out.println("Got it! Our queue is " + bob.queueLen() + " packages long.");
            } 
            else if (task == 4) 
            {
                System.out.println("See you next time.");
            } 
            else if (task ==5)
            {
                System.out.println("Attempting to send top package");
                String dest = bob.sendTopPackageTo();
                if (dest.equals(""))
                {
                    System.out.println("No package sent");
                }
                else
                {
                    PostOffice.getOfficeByName(dest).displaySentStorage();
                }
            }
            else if(task == 6)
            {
                System.out.println("Enter office name: ");
                String postname = sc.nextLine();
                System.out.println("Enter size: ");
                int postsize = Integer.parseInt(sc.nextLine());
                new PostOffice(postsize, postname);
            }
            else 
            {
                System.out.println("That's not a choice.");
            }
        }
        sc.close();
    }
}
