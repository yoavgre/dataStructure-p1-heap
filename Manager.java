public class Manager <T extends Comparable<T>>
/**
 * The Manager class holds comparable elements in 2 data structures:
 * max heap storing the elements by priority.
 * Queue storing the elements by creation time.
 *
 * This class implements add, getBycreationTime, getByPriotiry methhods.
 *
 * instead of T in all the other generics classes.
 */
{
    Heap<T> prior ;
    Queue<T> byTime;


    /**
     * A standard constructor for the Manager class
     *creates an empty heap and queue
     *
     */
    public Manager ()
    {
        this.prior = new Heap<T> ();
        this.byTime = new Queue <T> ();
    }

    /**
     * a function that adds a new element to both data structures.
     * @param t - the element to added
     *
     */
    public void add(T t)
    {
        prior.add(t);
        byTime.add(t);
    }

    /**
     * a function that returns the first element by creation time.
     *
     * @return T - the oldest element.
     *
     */
    public T getByCreationTime()
    {
        T t = (T) byTime.get();
        prior.remove (t);
        return t;
    }

    /**
     * a function that returns the first element by priority.
     *
     * @return T - the firts it priority element.
     *
     */

    public T getByPriority()
    {
        T t = (T) prior.get();
        byTime.remove(t);
        return t;
    }




}

