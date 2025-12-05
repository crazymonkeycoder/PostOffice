public interface heapUtil
{
    public void heapify(Comparable[] heap, int index, int heapSize);
    public void buildHeap(Comparable[] heap, int heapSize);
    public Comparable remove(Comparable[] heap, int heapSize);
    public Comparable[] insert(Comparable[] heap, Comparable item, int heapSize);
    public Comparable[] heapSort(Comparable[] heap, int heapSize);
}