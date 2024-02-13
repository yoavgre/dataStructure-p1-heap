import java.lang.reflect.Array;

/**
 * The Heap class holds the priority line implemnted by an array.
 * This class implements add, get, remove methhods.
 * This class will be used in your future implementation
 * instead of T in all the other generics classes.
 */

public class Heap<T extends Comparable<T>> {
    private T[] heapArr;
    private int n; // saves the number of elements in the heap

    /**
     * A standard constructor for the Heap class
     * creates an empty heap implimted by an array with a leangth of 10.
     *
     */

    public Heap() {
        this.heapArr = (T[]) Array.newInstance(Comparable.class, 10);
        n = 0;
    }

    /**
     * a function that adds a new element to the heap.
     * at first adds the element to the last place on the heap and then uses
     * parculateUp function
     *
     * @param t - the element to added
     *
     */

    public void add(T t) {
        if (n == heapArr.length) // the array is full - creates a doubled length array and copies all the elemets
        {
            T[] tempArr = (T[]) Array.newInstance(Comparable.class, heapArr.length*2);
            for (int i = 0; i < heapArr.length; i++) {
                tempArr[i] = heapArr[i];
            }
            this.heapArr = tempArr;
        }
        heapArr[n] = t; // adds the new element to the last place.
        this.n++;
        perculateUp(n, this.heapArr); // reorganize the heap
    }

    /**
     * a function that returns the first element in the heap.
     * it saves the first element, then replace it with the last element, and then
     * uses percolateDown
     * function to reorganize the heap.
     *
     * @return T - the element in the first place in the heap, the maximal element.
     *
     */
    public T get() {
        if (n == 0)//empty heap
            return null;
        T first = heapArr[0]; // saves the first element to return it after it have been replaced
        heapArr[0] = heapArr[n - 1]; // replacing the first element with the last one
        heapArr[n - 1] = null;
        n = n - 1;
        perculate_Down(1, n, heapArr);// reorganize the heap
        return first;
    }

    private void perculate_Down(int i, int n, T[] arr)
    {
        T max;
        int maxInd; //index for max;
        if(i==0)
        {
            return;
        }
        while (i*2 <= n) // not a leaf
        {
            if(i*2 == n)//has 1 son
            {
                if(arr[i-1].compareTo(arr[i*2-1])<0)//dad is smaller then only son
                {
                    T temp = arr[i-1];//switch dad and son
                    arr[i-1] = arr[i*2-1];
                    arr[i*2-1] = temp;
                    break;
                }
                else
                    break;
            }
            //the element has two sons
            if (arr[i * 2 - 1].compareTo(arr[i * 2]) >= 0)//saves the maximum between two sons and its index
            {
                max = arr[i * 2 - 1];
                maxInd = i * 2;
            }
            else
            {
                max = arr[i * 2];
                maxInd = i * 2 + 1;
            }
            if (arr[i - 1].compareTo(max) < 0)//current node is smaller then the max of the sons
            {
                T temp = arr[i - 1];//switch them
                arr[i - 1] = arr[maxInd - 1];
                arr[maxInd - 1] = temp;
                i=maxInd;
            }
            else
                return;
        }
    }

    private void perculateUp(int i, T[] arr) {
        while ((i / 2 >= 1) && arr[i - 1].compareTo(arr[i / 2 - 1]) > 0)//the current node is larger then its father
        {
            T temp = arr[i/2 - 1];
            arr[i / 2 - 1] = arr[i - 1];
            arr[i - 1] = temp;
            i = i / 2;
        }

    }

    /**
     * a function that removes a given element from the heap.
     * going throw the array and looking for this element. the removed elemet will
     * be replaced with the
     * last element in the heap and then it uses perculateDown function to reorgnize
     * the heap.
     *
     *
     * @param t - the element to be removed
     *
     */
    public void remove(T t) {

        if(n==0)//empty heap
            return;
        for (int i = 0; i < n; i++)
        {
            if (heapArr[i] == t)//currnet element is the one to be removed
            {
                heapArr[i] = heapArr[n - 1];//replace the current element with the last element
                heapArr[n - 1] = null;
                n = n - 1;
                perculate_Down(i, n, heapArr);//percolate down the last element from its new place

            }

        }
    }

}



