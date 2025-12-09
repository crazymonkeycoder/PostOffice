/**
 * Envelope extends Package with specific envelope types instead of generic sizes.
 * Types: 1 = postcard, 2 = file, 3 = document
 * @author Leo Denizen
 * @version 12/8/2025
 */
public class Envelope extends Package
{
    //Default type of an Envelope and the smallest type
    public static final int POSTCARD = 1;
    //Medium size of an Envelope
    public static final int FILE = 2;
    //Largest size of an Envelope
    public static final int DOCUMENT = 3;
    /**
     * Constructor for an Envelope without a size given. Defaults to a Postcard
     * @param priority the priority of the envelope
     * @param description the contents of the envelope
     * @param destination the end destination of the package
     */
    public Envelope(int priority, String description, String destination)
    {
        super(priority, description, destination, POSTCARD);
    }
    /**
     * Constructor for an Envelope with a size given. 
     * @param priority the priority of the envelope
     * @param description the contents of the envelope
     * @param destination the end destination of the package
     * @param envelopeType the type/size of the envelope
     */   
    public Envelope(int priority, String description, String destination, int envelopeType)
    {
        super(priority, description, destination, envelopeType);
    }
    /**
     * Gives back the size of the envelope
     * @return the type of the Envelope as a string
     */
    public String getEnvelopeType()
    {
        if (getSize() == POSTCARD)
        {
            return "Postcard";
        }
        if (getSize() == FILE)
        {
            return "File";
        }
        if (getSize() == DOCUMENT)
        {
            return "Document";
        }
        return "Unknown";
    }
    /**
     * Converts the package object to a descriptive String
     * @return A string composing of all the descriptions about the particular Envelope 
     */
    @Override
    public String toString()
    {
        return "Envelope{" +
            "description='" + getDescription() + '\'' +
            ", priority=" + getPriority() +
            ", type=" + getEnvelopeType() +
            ", destination='" + getDestination() + '\'' +
            ", sent=" + isSent() +
            '}';
    }
}
