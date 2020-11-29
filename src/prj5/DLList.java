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
 * A doubly linked list.
 *
 * @author Bryce Cullen (brycec23)
 * @verison 2020.11.21
 * @param <E>
 *            The type of object the class will store
 */
public class DLList<E>
{

    /**
     * Represents a node.
     * 
     * @author Bryce Cullen (brycec23)
     *
     * @param <E>
     *            Type of object to store as data in node.
     */
    private static class Node<E>
    {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        /**
         * Creates a new node with the given data.
         *
         * @param d
         *            The data to put inside the node.
         */
        public Node(E d)
        {
            data = d;
        }


        /**
         * Sets the node after this node.
         *
         * @param n
         *            The node after this one.
         */
        public void setNext(Node<E> n)
        {
            next = n;
        }


        /**
         * Sets the node before this one.
         *
         * @param n
         *            The node before this one.
         */
        public void setPrevious(Node<E> n)
        {
            previous = n;
        }


        /**
         * Gets the next node.
         *
         * @return The next node.
         */
        public Node<E> next()
        {
            return next;
        }


        /**
         * Gets the node before this one.
         *
         * @return The node before this one.
         */
        public Node<E> previous()
        {
            return previous;
        }


        /**
         * Gets the data in the node.
         *
         * @return The data in the node.
         */
        public E getData()
        {
            return data;
        }
    }


    /**
     * Represents an iterator to traverse the list.
     * 
     * @author Bryce Cullen
     * @version 2020.10.29
     * @param <A>
     *            The object to traverse.
     */
    public class DLListIterator<A> implements Iterator<E>
    {
        private Node<E> currentNode;
        private Node<E> previousNode;
        private boolean flag;

        /**
         * Creates a new DLListIterator
         */
        public DLListIterator()
        {
            currentNode = head;
            previousNode = head;
            flag = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext()
        {
            return (currentNode.next().getData() != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("There is no next node.");
            }
            E data = currentNode.next().getData();
            previousNode = currentNode;
            currentNode = currentNode.next();
            flag = true;
            return data;
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove()
        {
            if (!flag)
            {
                throw new IllegalStateException(
                    "next() has not been called yet or element has"
                        + " already been removed.");
            }
            Node<E> removed = currentNode;
            removed.previous().setNext(currentNode.next());
            removed.next().setPrevious(previousNode);
            flag = false;
            size--;
        }
    }

    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> tail;

    /**
     * Create a new DLList object.
     */
    public DLList()
    {
        init();
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator()
    {
        return new DLListIterator<E>();
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init()
    {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return size;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear()
    {
        init();
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj)
    {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E get(int index)
    {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry)
    {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj)
    {
        if (index < 0 || size < index)
        {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null)
        {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size)
        {
            nodeAfter = tail;
        }
        else
        {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index)
    {
        if (index < 0 || size() <= index)
        {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++)
        {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj)
    {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--)
        {
            if (current.getData().equals(obj))
            {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     * @return true if successful
     */
    public boolean remove(int index)
    {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(E obj)
    {
        Node<E> current = head.next();
        while (!current.equals(tail))
        {
            if (current.getData().equals(obj))
            {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty())
        {
            Node<E> currNode = head.next();
            while (currNode != tail)
            {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail)
                {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
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
            DLList<E> other = ((DLList<E>)obj);
            if (other.size() == this.size())
            {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
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
     * Helper method for insertionSort.
     * 
     * @param comp
     *            Comparator to use
     * @param nodeToInsert
     *            Node to be inserted into sorted portion.
     */
    private void sort(Comparator<E> comp, Node<E> nodeToInsert)
    {
        E item = nodeToInsert.getData();
        Node<E> currentNode = head.next();
        Node<E> prevNode = head;
        while ((currentNode != null) && (comp.compare(item, currentNode
            .getData()) > 0))
        {
            prevNode = currentNode;
            currentNode = currentNode.next();
        }
        if (prevNode != head)
        {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(prevNode);
            nodeToInsert.setNext(currentNode);
            if (currentNode != null)
            {
                currentNode.setPrevious(nodeToInsert);
            }
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
    public void insertionSort(Comparator<E> comp)
    {
        Node<E> firstNode = head.next();
        if (size() > 1)
        {
            Node<E> unsorted = firstNode.next();
            firstNode.next().setPrevious(null);
            firstNode.setNext(null);
            while (unsorted != tail && unsorted != null)
            {
                Node<E> nodeToInsert = unsorted;
                unsorted = unsorted.next();
                sort(comp, nodeToInsert);
            }
        }
        Node<E> newTail = new Node<E>(null);
        getNodeAtIndex(size - 1).setNext(newTail);
        newTail.setPrevious(getNodeAtIndex(size - 1));
        tail = newTail;

    }
}
