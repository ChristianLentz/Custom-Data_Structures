package Lists;
 
/**
 * This interfce implements a number of methods that are common between the 
 * Linked List and Array List. Will be used to implement both 
 * 
 * @Author Christian Lentz
 */
public interface ListADT<T> {
    
    /**
     * Add an item of type T to the end of the list. 
     * @param item
     */
    public void addTo(T item); 

    /**
     * Add an element of type T to the given index of the list.
     * Note that the list uses zero indexing. 
     * @param index
     * @param item
     */
    public void addIndx(int index, T item); 

    /**
     * Remove the item currently at the end of the list. 
     */
    public void removeEnd(); 

    /**
     * Remove an item of type T from the list. Remove the first instance 
     * of that item if duplicates. 
     * @param item
     */
    public void remove(T item); 

    /**
     * Get an item from the list given its index into the list. 
     * @param item
     * @return the item of type T that was found, or null if not found 
     */
    public T getByIndex(int index); 
    
    /**
     * Get the index of an item in the array, or return -1 if it is not there. 
     * @param item
     * @return the index/location of the given item 
     */
    public int getIndexOf(T item); 

    /**
     * Determine if a given item is contained within a list. 
     * @param item
     * @return a boolean describing if a given item is contained within the list 
     */
    public boolean contains(T item); 

    /**
     * Determine if the given list is or is not empty
     * @return a boolean 
     */
    public boolean isEmpty(); 

    /**
     * Remove all items from the list. 
     */
    public void clear(); 
}
