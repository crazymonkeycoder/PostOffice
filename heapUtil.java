/**
 * Interface to house the methods useful to make a heap
 * @author Leo Denizen
 * @version 12/8/2025
 */
public interface heapUtil
{
    /**
     * Heapify will push a specific object in a heap down 
     * @param heap the heap that the Comparable resides in 
     * @param index the index of the node to be heapified
     * @param heapSize the size of the heap
     */
    public void heapify(Comparable[] heap, int index, int heapSize);
    /**
     * Buildheap will create a valid heap
     * @param heap the heap to make valid
     * @param heapSize the size of the heap
     */
    public void buildHeap(Comparable[] heap, int heapSize);
    /**
     * This removes the root node
     * @param heap the heap to remove from
     * @param heapSize the size of the heap
     */
    public Comparable remove(Comparable[] heap, int heapSize);
    /**
     * This inserts a node into the heap
     * @param heap the heap to insert into
     * @param item the item to insert
     * @param heapSize the size of the heap
     */
    public Comparable[] insert(Comparable[] heap, Comparable item, int heapSize);
    /**
     * This sorts the array of the heap
     * @param heap the array to sort
     * @param heapSize the size of the heap
     */
    public Comparable[] heapSort(Comparable[] heap, int heapSize);
}