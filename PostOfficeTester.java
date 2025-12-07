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
        PostOffice SanJose = new PostOffice(100);
        PostalWorker bob = new PostalWorker("bob", SanJose);
        PostOffice MountainView = new PostOffice(100);
        PostalWorker alice = new PostalWorker("alice", MountainView);

        // Populate SanJose with a couple packages
        SanJose.add(5, "Books", "Seattle");
        SanJose.add(3, "Clothes", "Denver");

        System.out.println("Before transfer:");
        System.out.println("SanJose queue size: " + SanJose.getQueueSize());
        SanJose.displayQueue();
        System.out.println("MountainView queue size: " + MountainView.getQueueSize());
        MountainView.displayQueue();

        // Bob sends the top package from SanJose to MountainView
        bob.sendTopPackageTo(MountainView);

        System.out.println("After transfer (bob moved top package to MountainView):");
        System.out.println("SanJose queue size: " + SanJose.getQueueSize());
        SanJose.displayQueue();
        System.out.println("MountainView sent-storage count: " + MountainView.getSentCount());
        // Print descriptions of packages in MountainView's sent storage
        MountainView.displaySentStorage();
        int task = 0;
        while (task != 4)
        {
            System.out.println("Welcome to the post office! Please let me know how I can help you.");
            System.out.println("1. Submit a package to be sent");
            System.out.println("2. Check on the status of a package");
            System.out.println("3. Check how long our package queue is");
            System.out.println("4. Exit");
            System.out.println("5. Test sending package");
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
                System.out.println("Attempting to send top package to MountainView");
                bob.sendTopPackageTo(MountainView);
                System.out.println("MountainView storage count: " + MountainView.getSentCount());
                MountainView.displaySentStorage();
            }
            else 
            {
                System.out.println("That's not a choice.");
            }
        }
        sc.close();
    }
}
