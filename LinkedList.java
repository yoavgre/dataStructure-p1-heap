import java.util.NoSuchElementException;

/**
 * Represents a generic linked list, and list-oriented operations.
 * The list can hold objects of any type.
 */
public class LinkedList<E> {

    // The following constant is used for localizing the line separator character,
    // which may be different in different host platforms.

    private Node<E> first;  // Points to the first node in the list (just after the dummy node)
    private Node<E> last;   // Points to the last node in the list
    private int size;       // Number of list elements

    /**
     * Creates a list with 0 elements.
     */
    public LinkedList() {
        // Starts with a dummy node, to avoid handling empty lists.
        Node<E> dummy = new Node<E>(null);
        this.first =  dummy;
        this.last = first;
        this.size = 0;
    }

    /**
     * Adds the given element to the end of this list.
     * @param e  the node to add
     */
    public void add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (this.size == 0) {
            this.first.next = this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }

    /**
     * Adds the given element to the beginning of this list.
     * @param e  the element to add to the list.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        if (this.size == 0){
            this.first.next = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.first.next;
            this.first.next = newNode;
        }
        size++;
    }

    /**
     * Adds the given element at the n'th location of this list.
     * The index of the list's first element is 0.
     * The index of the list's last element is the list's size.
     * @param  e the element to add
     * @param  index the index
     * @throws IllegalArgumentException if index is negative or larger than the list's size
     */
    public void add(E e, int index) {
        Node<E> head = this.first.next;
        if (index < 0 || index > this.size){
            throw new IllegalArgumentException ("index out of range");
        }
        if (index == 0){
            addFirst(e);
        } else if (this.size == index) {
            add(e);
        } else {
            while (index-- != 0){
                if (index == 0){
                    Node <E> newNode = new Node <E> (e);
                    newNode.next = head.next;
                    head.next = newNode;
                    size++;
                }
                head = head.next;
            }
        }
    }

    /**
     * Returns the index of the given element in this list, or -1 if not found.
     * @param  e the returned index will be the index of e.
     * @return the index of the given element in this list
     */
    public int indexOf (E e) {
        Node<E> current = this.first.next;
        int i = 0;
        while (i < this.size){
            if (current.e.equals(e)){
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    /**
     * If the given element exists in this list, removes it and returns true.
     *  Otherwise, returns false.
     * @param  e the element to remove.
     * @return if the given element exists in this list, removes it and
     * returns true. Otherwise, returns false.
     */
    public boolean remove(E e) {
        int index = indexOf(e);
        boolean isLastValue = false;
        if (index != -1){
            if (index == this.size - 1){
                isLastValue = true;
            }
            Node <E> head = this.first;
            while (index != -1){
                if (index == 0){
                    head.next = head.next.next;
                    this.size--;
                    if (isLastValue){
                        this.last = head;
                    }
                    return true;
                } else {
                    head = head.next;
                    index--;
                }
            }
        }
        return false;
    }

    /**
     * Returns the first element in this list.
     * @return the first element in this list.
     * @throws NoSuchElementException if the list is empty
     */
    public E getFirst() {
        if (this.size == 0){
            throw new NoSuchElementException ("the list is empty");
        }
        return this.first.next.e;
    }

    /**
     * Returns the last element in this list.
     * @return the last element in this list.
     * @throws NoSuchElementException if the list is empty
     */
    public E getLast() {
        if (this.size == 0){
            return null;
        }
        return this.last.e;
    }

    /**
     * Returns the size of this list.
     * @return the size of this list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns an itertaor on this list.
     * @return an itertaor on this list.
     */
    public ListIterator<E> iterator() {
        return new ListIterator<E>(this.first.next);
    }

    /**
     * A textual representation of the elements of this list.
     * Each element is displayed in a separate line.
     */
    public String toString() {
        if (this.size == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder();
        ListIterator<E> itr = this.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next().toString() +  "\n");
        }
        return sb.toString();
    }
}
