
/**
 * Person is a parent class for all types of people.
 *
 * @author Urvi S.
 * @version 12/05/2025
 */
public class Person
{
    private String name;
    private int age;
    private String job;
    /**
     * Constructor for objects of class Student
     * 
     * @param n the name
     * @param a the age
     * @param j the job
     */
    public Person(String n, int a, String j)
    {
        name = n;
        age = a;
        job = j;
    }
    public Person() {}

    /**
     * Getter for the name.
     * 
     * @return the name of the person
     */
    public String getName()
    {
        return name;
    }
    /**
     * Getter for the age.
     * 
     * @return the age of the person
     */
    public int getAge()
    {
        return age;
    }
    /**
     * Getter for the grade.
     * 
     * @return the job of the person
     */
    public String getJob()
    {
        return job;
    }
    /**
     * Setter for the name.
     * 
     * @param n the name of the person
     */
    public void setName(String n)
    {
        name = n;
    }
    /**
     * Setter for the Student ID.
     * 
     * @param a the age of the person
     */
    public void setAge(int a)
    {
        age = a;
    }
    /**
     * Setter for the job.
     * 
     * @param j the job of the person
     */
    public void setJob(String j)
    {
        job = j;
    }
}
