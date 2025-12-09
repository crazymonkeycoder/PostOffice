/**
 * Envelope extends Package with specific envelope types instead of generic sizes.
 * Types: 1 = postcard, 2 = file, 3 = document
 */
public class Envelope extends Package
{
    public static final int POSTCARD = 1;
    public static final int FILE = 2;
    public static final int DOCUMENT = 3;

    public Envelope(int priority, String description, String destination)
    {
        super(priority, description, destination, POSTCARD);
    }

    public Envelope(int priority, String description, String destination, int envelopeType)
    {
        super(priority, description, destination, envelopeType);
    }

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
