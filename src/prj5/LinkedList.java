package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * Represents a singly linked list.
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.17
 * 
 * @param <T>
 *            The type of data to store in the linked list.
 */
public class LinkedList<T>
{

    private Node<T> head;
    private int size;

    /**
     * Creates a new empty linked list.
     */
    public LinkedList()
    {
        head = null;
        size = 0;
    }


    /**
     * Returns number of elements in linked list.
     * 
     * @return size of linked list.
     */
    public int size()
    {
        return size;
    }


    /**
     * Adds a new element to linked list at index.
     * 
     * @param index
     *            Index to add element.
     * @param obj
     *            Element to add.
     */
    public void add(int index, T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        if ((index < 0) || (index > size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;

        if (isEmpty())
        {
            head = new Node<T>(obj);
        }
        else
        {
            if (index == 0)
            {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else
            {
                int currentIndex = 0;
                while (current != null)
                {
                    if ((currentIndex + 1) == index)
                    {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    current = current.next();
                    currentIndex++;
                }
            }
        }
        size++;
    }


    /**
     * Adds a new element at end of linked list.
     * 
     * @param obj
     *            Element to add.
     */
    public void add(T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        if (isEmpty())
        {
            head = new Node<T>(obj);
        }
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }


    /**
     * Checks if linked list is empty.
     * 
     * @return True if list is empty.
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }


    /**
     * Removes an element from linked list.
     * 
     * @param obj
     *            Element to search for and remove.
     * @return True if element was removed.
     */
    public boolean remove(T obj)
    {
        Node<T> current = head;

        if ((null != head) && (obj.equals(current.data)))
        {
            head = head.next;
            size--;
            return true;
        }

        while (size() >= 2 && (current.next != null))
        {
            if ((obj.equals(current.next.data)))
            {
                if (current.next.next != null)
                {
                    current.setNext(current.next.next);
                }
                else
                {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Removes the element at index.
     * 
     * @param index
     *            Index to remove at.
     * @return True if element was removed.
     */
    public boolean remove(int index)
    {
        if (index < 0 || head == null)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else
        {
            Node<T> current = head;
            int currentIndex = 0;

            if (index == 0)
            {
                head = head.next();
                size--;
                return true;
            }

            while (current.next != null)
            {
                if ((currentIndex + 1) == index)
                {
                    Node<T> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Returns the element at index.
     * 
     * @param index
     *            Index to get from.
     * @return Element at index.
     */
    public T get(int index)
    {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        if (data == null)
        {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks for an element in the list.
     * 
     * @param obj
     *            Element to look for.
     * @return True if element is in list.
     */
    public boolean contains(T obj)
    {
        Node<T> current = head;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Empties the list.
     */
    public void clear()
    {
        if (head != null)
        {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Returns the last occurance of an element.
     * 
     * @param obj
     *            Element to look for.
     * @return Last index element occurs at.
     */
    public int lastIndexOf(T obj)
    {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list.
     * 
     * @return String representation of list.
     */
    public String toString()
    {
        String result = "{";

        Node<T> current = head;
        while (current != null)
        {
            result += "" + current.data;
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    private void sort(Comparator<T> comp, Node<T> nodeToInsert)
    {
        T item = nodeToInsert.getData();
        Node<T> currentNode = head.next();
        Node<T> prevNode = head;
        while ((currentNode != null) && (comp.compare(item, currentNode
            .getData()) > 0))
        {
            prevNode = currentNode;
            currentNode = currentNode.next();
        }
        if (prevNode != head)
        {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else
        {
            nodeToInsert.setNext(head.next());
            head.setNext(nodeToInsert);
        }
    }


    /**
     * Uses insertion sort to sort list
     * 
     * @param comp
     *            Comparator to use.
     */
    public void insertionSort(Comparator<T> comp)
    {
        Node<T> firstNode = head.next();
        if (size() > 1)
        {
            Node<T> unsorted = firstNode.next();
            firstNode.setNext(null);
            while (unsorted != null)
            {
                Node<T> nodeToInsert = unsorted;
                unsorted = unsorted.next();
                sort(comp, nodeToInsert);
            }
        }
    }


    /**
     * Returns an array represenation of list.
     * 
     * @return Array represenation of list.
     */
    public Object[] toArray()
    {

        Object[] array = new Object[this.size()];

        Node<T> current = head;
        int count = 0;
        while (current != null)
        {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Checks if two linked lists are equal
     * 
     * @param obj
     *            The list to compare to.
     * @return True if obj is equal to this.
     */
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = ((LinkedList<T>)obj);
            if (other.size() == this.size())
            {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null)
                {
                    if (!current.getData().equals(otherCurrent.getData()))
                    {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Returns a new iterator.
     * 
     * @return an iterator.
     */
    public Iterator<T> iterator()
    {
        return new ListIterator<T>();
    }

    /**
     * Represents an iterator to traverse a linked list.
     * 
     * @author Bryce Cullen (brycec23)
     *
     * @param <A>
     *            The object to traverse.
     */
    private class ListIterator<A> implements Iterator<T>
    {

        private Node<T> currentNode;
        private Node<T> previousNode;

        /**
         * Creates a new listIterator.
         */
        public ListIterator()
        {
            currentNode = head;
            previousNode = head;
        }


        /**
         * Returns true if there is a next element.
         * 
         * @return true if next element exists.
         */
        @Override
        public boolean hasNext()
        {
            return (currentNode.next().getData() != null);
        }


        /**
         * Returns the value of the next node and advances iterator
         * 
         * @return value in next node.
         */
        @Override
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("There is no next node.");
            }
            T data = currentNode.next().getData();
            previousNode = currentNode;
            currentNode = currentNode.next();
            return data;
        }

    }


    /**
     * Represents a node.
     * 
     * @author Bryce Cullen (brycec23)
     *
     * @param <D>
     *            The type of data to store in a node.
     */
    public static class Node<D>
    {

        private D data;
        private Node<D> next;

        /**
         * Creates a new node.
         * 
         * @param data
         *            The data to store in the node.
         */
        public Node(D data)
        {
            this.data = data;
        }


        /**
         * Sets the next node.
         * 
         * @param next
         *            Node to make next.
         */
        public void setNext(Node<D> next)
        {
            this.next = next;
        }


        /**
         * Returns the next node.
         * 
         * @return Next node.
         */
        public Node<D> next()
        {
            return next;
        }


        /**
         * returns the data contained in this node.
         * 
         * @return Node's data.
         */
        public D getData()
        {
            return data;
        }
    }

}
