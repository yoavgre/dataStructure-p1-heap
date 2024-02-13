/**
 * The Queue class holds the line by ariival time implemnted by a linked list.
 *
 *
 * This class implements add, get, remove methhods.
 *
 * This class will be used in your future implementation
 * instead of T in all the other generics classes.
 */
public class Queue<T> {
    LinkedList<T> q1;
    /**
     * A standard constructor for the Queue class
     *creates an empty Queue implimted by an empty linked list
     *
     */

    public Queue() {
        q1 = new LinkedList<T>();
    }


    /**
     * a function that adds a new element to the Queue.
     * @param t - the element to added
     *
     */
    public void add(T t) {
        q1.addFirst(t);
    }

    /**
     * a function that returns the first element in the Queue.
     *
     * @return T - the element in the first element in the Queue.
     *
     */
    public T get() {

        T temp = q1.getLast();
        q1.remove(temp);
        return temp;

    }

    /**
     * a function that removes a given element from the Queue.
     *
     * @param t - the element to be removed
     *
     */

    public void remove(T t) {
        q1.remove(t);

    }

}