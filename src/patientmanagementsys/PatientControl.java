package patientmanagementsys;
/**
*
* @author Joao Pedro Haddad 2016220
*/
public class PatientControl implements PatientNodeInterface {

	   public PatientNode<Patient> head = null;
	    /** The size of the list */
	    private int size = 0;
	    // Helper Methods
	    /** Insert an item as the first item of the list.
	     *	@param item The item to be inserted
	     */
	    @Override
	    public void addFirst(Patient item) {
	        head = new PatientNode<Patient>(item, head);
	        size++;
	    }
	    /**
	     * Add a node after a given node
	     * @param node The node which the new item is inserted after
	     * @param item The item to insert
	     */
	    @Override
	    public void addAfter(PatientNode<Patient> node, Patient item) {
	        node.next = new PatientNode<Patient>(item, node.next);
	        size++;
	    }
	    /**
	     * Remove the first node from the list
	     * @returns The removed node's data or null if the list is empty
	     */
	    @Override
	    public Patient removeFirst() {
	    	PatientNode<Patient> temp = head;
	        if (head != null) {
	            head = head.next;
	        }
	        if (temp != null) {
	            size--;
	            return temp.PatientData;
	        } else {
	            return null;
	        }
	    }
	    /**
	     * Remove the node after a given node
	     * @param node The node before the one to be removed
	     * @returns The data from the removed node, or null
	     *          if there is no node to remove
	     */
	    @Override
	    public Patient removeAfter(PatientNode<Patient> node) {
	    	PatientNode<Patient> temp = node.next;
	        if (temp != null) {
	            node.next = temp.next;
	            size--;
	            return temp.PatientData;
	        } else {
	            return null;
	        }
	    }
	    /**
	     * Find the node at a specified index
	     * @param index The index of the node sought
	     * @returns The node at index or null if it does not exist
	     */
	    @Override
	    public PatientNode<Patient> getNode(int index) {
	    	PatientNode<Patient> node = head;
	        for (int i = 0; i < index && node != null; i++) {
	            node = node.next;
	        }
	        return node;
	    }
	    // Public Methods
	    /**
	     * Get the data value at index
	     * @param index The index of the element to return
	     * @returns The data at index
	     * @throws IndexOutOfBoundsException if the index is out of range
	     */
	    @Override
	    public Patient get(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException(Integer.toString(index));
	        }
	        PatientNode<Patient> node = getNode(index);
	        return node.PatientData;
	    }
	    /**
	     * Set the data value at index
	     * @param index The index of the item to change
	     * @param newValue The new value
	     * @returns The data value previously at index
	     * @throws IndexOutOfBoundsException if the index is out of range
	     */
	    @Override
	    public Patient set(int index, Patient newValue) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException(Integer.toString(index));
	        }
	        PatientNode<Patient> node = getNode(index);
	        Patient result = node.PatientData;
	        node.PatientData = newValue;
	        return result;
	    }
	    /**
	     * Insert the specified item at the specified position in the list.
	     * Shifts the element currently at that position (if any) and any
	     * subsequent elements to the right (adds one to their indices)
	     * @param index Index at which the specified item is to be inserted
	     * @param item The item to be inserted
	     * @throws IndexOutOfBoundsException if the index is out of range
	     */
	    @Override
	    public void add(int index, Patient item) {
	        if (index < 0 || index > size) {
	            throw new IndexOutOfBoundsException(Integer.toString(index));
	        }
	        if (index == 0) {
	            addFirst(item);
	        } else {
	        	PatientNode<Patient> node = getNode(index - 1);
	            addAfter(node, item);
	        }
	    }
	    /**
	     * Append the specified item to the end of the list
	     * @param item The item to be appended
	     * @returns true (as specified by the Collection interface)
	     */
	    @Override
	    public boolean add(Patient item) {
	        add(size, item);
	        return true;
	    }
	    /*<exercise chapter="2" section="5" type="programming" number="1">*/
	    /**
	     * Remove the item at the specified position in the list. Shifts
	     * any squsequent items to the left (subtracts one from their
	     * indicies). Returns the tiem that was removed.
	     * @param index The index of the item to be removed
	     * @returns The item that was at the specified position
	     * @throws IndexOutOfBoundsException if the index is out of range
	     */
	    @Override
	    public Patient remove(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException(Integer.toString(index));
	        }
	        PatientNode<Patient> removedNode = null;
	        if (index == 0) {
	            return removeFirst();
	        } else {
	        	PatientNode<Patient> node = getNode(index - 1);
	            return removeAfter(node);
	        }
	    }
	    /**
	     * Query the size of the list
	     * @return The number of objects in the list
	     */
	    @Override
	    public int size() {
	        return size;
	    }
	    /**
	     * Obtain a string representation of the list
	     * @return A String representation of the list 
	     */
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("[");
	        PatientNode p = head;
	        if (p != null) {
	            while (p.next != null) {
	                sb.append(p.PatientData.toString());
	                sb.append(" ==> ");
	                p = p.next;
	            }
	            sb.append(p.PatientData.toString());
	        }
	        sb.append("]");
	        return sb.toString();
	    }
	    /**
	     * Remove the first occurrence of element item.
	     * @param item The item to be removed
	     * @return true if item is found and removed; otherwise, return false.
	     */
	    public boolean remove(Patient item) {
	        if (head == null) {
	            return false;
	        }
	        PatientNode<Patient> current = head;
	        if (item.equals(current.PatientData)) {
	            removeFirst();
	            return true;
	        }
	        while (current.next != null) {
	            if (item.equals(current.next.PatientData)) {
	                removeAfter(current);
	                return true;
	            }
	            current = current.next;
	        }
	        return false;
	    }
}
