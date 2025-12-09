/**
 * HeapUtil implements the methods necessary for a heap and allows for the packages in the queue to be organized by priority
 * @author Leo Denizen
 * @version 12/8/2025
 */
public class postOfficeUtil implements heapUtil
{ 
    @Override
    /**
     * Ensure the subtree rooted at index is in the right spot for a maxheap
     * @param heap array representing the heap
     * @param index root index to heapify
     * @param heapSize current size of the heap
     */
    public void heapify(Comparable[] heap, int index, int heapSize)
    {
        int leftind = 2 * index;
        int rightind = leftind + 1;
        int top = index;
        if (leftind <= heapSize && heap[leftind] != null &&
            heap[top].compareTo(heap[leftind]) < 0)
        {
            top = leftind;
        }
        if (rightind <= heapSize && heap[rightind] != null &&
            heap[top].compareTo(heap[rightind]) < 0)
        {
            top = rightind;
        }
        if (top != index)
        {
            Comparable temp = heap[index];
            heap[index] = heap[top];
            heap[top] = temp;
            index = top;
            heapify(heap, index, heapSize);
        }
    }
    @Override
    /**
     * Makes a valid maxheap
     * @param heap array representing the heap 
     * @param heapSize number of elements in the heap
     */
    public void buildHeap(Comparable[] heap, int heapSize)
    {
        for (int i = heapSize / 2; i >= 1; i--)
        {
            heapify(heap, i, heapSize);
        }
    }
    @Override
    /**
     * Remove and return the top element of the heap 
     * @param heap array representing the heap 
     * @param heapSize number of elements currently in the heap
     * @return the removed element
     */
    public Comparable remove(Comparable[] heap, int heapSize)
    {
        if (heapSize < 1) 
        {
            return null;
        }
        Comparable removed = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize] = null;
        heapSize--;
        heapify(heap, 1, heapSize);
        return removed;
    }
    @Override
    /**
     * Insert an element into the heap array
     * @param heap the heap array
     * @param item item to insert
     * @param heapSize current size of the heap 
     * @return the updated array
     */
    public Comparable[] insert(Comparable[] heap, Comparable item, int heapSize)
    {
        heapSize++;
        if (heapSize >= heap.length)
        {
            Comparable[] bigger = new Comparable[heap.length * 2];
            for (int i = 0; i < heap.length; i++)
            {
                bigger[i] = heap[i];
            }
            heap = bigger;
        }
        heap[heapSize] = item;
        int index = heapSize;
        boolean escape = false;
        while (index > 1 && !escape)
        {
            int parent = index / 2;
            if (heap[parent].compareTo(heap[index]) >= 0)
            {
                escape = true;
            }
            else
            {
                Comparable temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            }
        }
        return heap; 
    }
    @Override
    /**
     * Sorts the array the heap is in
     * @param heap array to sort
     * @param heapSize the size of the heap
     * @return the same array instance containing the sorted values
     */
    public Comparable[] heapSort(Comparable[] heap, int heapSize)
    {
        buildHeap(heap, heapSize);
        while (heapSize > 1)
        {
            Comparable temp = heap[1];
            heap[1] = heap[heapSize];
            heap[heapSize] = temp;
            heapSize--;
            heapify(heap, 1, heapSize);
        }
        return heap;
    }
}