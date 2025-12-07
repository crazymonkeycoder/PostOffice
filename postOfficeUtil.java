/**
 * Docs
 */
public class postOfficeUtil implements heapUtil
{ 
    @Override
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
    public void buildHeap(Comparable[] heap, int heapSize)
    {
        for (int i = heapSize / 2; i >= 1; i--)
        {
            heapify(heap, i, heapSize);
        }
    }
    @Override
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