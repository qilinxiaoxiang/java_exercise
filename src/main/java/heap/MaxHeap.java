package heap;

public class MaxHeap {
    private int[] a; // 数组, 从下标1开始存储数据
    private int n; // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public MaxHeap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    public void insert(int data) {
        if (count >= n) { // 堆满了
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 从下往上堆化
            swap(a, i, i / 2);
            i = i / 2;
        }

    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int removeMax() {
        if (count == 0) {
            return -1;
        }
        int max = a[1];
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
        return max;
    }

    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void buildHeap(int[] a, int n) { // 原地交换法
        for (int i = n/2; i >= 1; --i) { // 叶子节点往下堆化只能自己跟自己比较, 直接从非叶子结点开始
            heapify(a, n, i);
        }
    }

    // n表示数据的个数, 数组a中的数据从下标1到n的位置
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) { // 每次把堆顶元素换到堆尾, 然后对前k个元素建堆
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }


}
