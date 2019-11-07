
public class BinaryHeap {

    private static final int DEFAULT_SIZE = 10;

    private int[] heap;

    private int size;

    private int capacity;

    public BinaryHeap() {
        heap = new int[DEFAULT_SIZE];
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    public void add(int i) {
        if (size == capacity) {
            expansion();
        }
        heap[size] = i;
        filtration(heap, size);
        size++;
    }

    public int remove() {
        int temp = heap[0];
        swap(heap, 0, size - 1);
        downFilter(heap, 0, size-1);
        heap[--size] = 0;
        return temp;
    }

    private void expansion() {
        capacity = capacity * 2;
        int[] temp = new int[capacity * 2];
        System.arraycopy(heap, 0, temp, 0, size);
        heap = temp;
    }


    private void downFilter(int[] arr, int index, int length) {
        int value = arr[index];
        int startIndex = index * 2 + 1;
        int hole = index;
        while (startIndex < length) {
            if (startIndex + 1 < length && arr[startIndex + 1] < arr[startIndex]) {
                startIndex++;
            }
            if (arr[startIndex] < value) {
                arr[hole] = arr[startIndex];
                hole = startIndex;
                startIndex = startIndex * 2 + 1;
            } else {
                break;
            }
        }
        arr[hole] = value;
    }

    private void filtration(int[] arr, int index) {
        int value = arr[index];
        int startIndex = (index-1) / 2;
        int hole = index;
        while (hole > 0) {
            if (arr[startIndex] > value) {
                arr[hole] = arr[startIndex];
                hole = startIndex;
                startIndex = (startIndex-1) / 2;
            } else {
                break;
            }
        }
        arr[hole] = value;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}