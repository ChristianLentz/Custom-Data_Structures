package Lists.LinkedList; 

import Lists.ListADT;

/**
 * Implementation of a doubly-linked list using a list interface and a linear node class. 
 * 
 * Note that this Linked List is zero indexed 
 * 
 * @Author Christian Lentz
 */
public class LinkedList<T> implements ListADT<T> {

    // data to keep track of the list 
    LinearNode<T> head = new LinearNode<T>(); 
    LinearNode<T> rear = new LinearNode<T>(); 
    int size; 

    /**
     * Constructor for an empty linked list
     */
    public LinkedList () { 
        this.head = null; 
        this.rear = null; 
        this.size = 0; 
    }

    /**
     * Constructor for a linked list with starter array of data
     * @param data
     */
    public LinkedList (T[] data) { 
        this.head = null; 
        this.rear = null; 
        for (T item : data) { 
            this.addTo(item); 
        }
    }

    @Override
    /**
     * Adding to a linked list is O(n)
     */
    public void addTo(T item) {
        LinearNode<T> newNode = new LinearNode<T>(item); 
        if (size == 0) { 
            head = newNode; 
        } else { 
            newNode.setPrev(rear);
            rear.setNext(newNode); 
        }
        rear = newNode; 
        size++; 
    }

    @Override
    /**
     * Adding to a given index is O(n), but can be better 
     */
    public void addIndx(int index, T item) {
        // if the index being added to is the end of the list 
        if (index == size) { 
            addTo(item); 
        // if the index is valid and not at the end 
        } else if (index < size) { 
            LinearNode<T> currNode = head; 
            LinearNode<T> toAdd = new LinearNode<T>(item); 
            // get the node at location we want to insert 
            for (int i = 1; i <= index; i++) { 
                currNode = currNode.getNext(); 
            }
            // add links for the inserted node to its previous
            toAdd.setPrev(currNode.getPrev()); 
            toAdd.getPrev().setNext(toAdd); 
            // add links for the inserted node to its next 
            toAdd.setNext(currNode); 
            toAdd.getNext().setPrev(toAdd); 
            size++; 
        // if the index is not valid 
        } else { 
            System.out.println("ERROR when adding to linked list: index out of bounds!"); 
        }
    }

    @Override
    /**
     * Constant time, O(1)
     */
    public void removeEnd() {
        rear = rear.getPrev(); 
        rear.getNext().setPrev(null); 
        rear.setNext(null); 
        size--; 
    }

    @Override
    /**
     * Removing at a given index is O(n), but can be better 
     */
    public void remove(T item) {
        int sizeBefore = size; 
        // remove the head if the data is there 
        if (head.getElement().equals(item)) { 
            head = head.getNext(); 
            head.getPrev().setNext(null); 
            head.setPrev(null); 
            size--; 
        // remove the rear if data is there 
        } else if (rear.getElement().equals(item)) { 
            removeEnd(); 
        // remove a node in the middle if there 
        } else {
            LinearNode<T> currNode = head; 
            LinearNode<T> toRemove = null; 
            int i = 0; 
            // loop through list until we find the node containing the item 
            while (toRemove.equals(null) && i < size) { 
                if (currNode.getElement().equals(item)) { 
                    toRemove = currNode; 
                }
                currNode = currNode.getNext(); 
                i++; 
            }
            // remove the item if it was found 
            if (!toRemove.equals(null)) { 
                // NEED TO UPDATE LINKS HERE 
                size--; 
            }
        }
        // let user know if item to remove is not there 
        if (sizeBefore == size) { 
            System.out.println("Item to remove is not in the list!"); 
        }
    }

    @Override
    /**
     * Getting by a given index is O(n), but can be better 
     */
    public T getByIndex(int index) {
        
        return null;
    }

    @Override
    /**
     * Getting an index is O(n) but can be better
     */
    public int getIndexOf(T item) {
        
        return 0;
    }

    @Override
    public boolean contains(T item) {
        
        return false;
    }

    @Override
    /**
     * Constant time, O(1) 
     */
    public boolean isEmpty() {
        if (size == 0) { 
            return true; 
        }
        return false; 
    } 

    @Override
    /**
     * Must loop over whole array, the average time is the same as the upper bound, O(n)
     */
    public void clear() {
        while (size > 0) { 
            this.removeEnd(); 
        }
    }
}
