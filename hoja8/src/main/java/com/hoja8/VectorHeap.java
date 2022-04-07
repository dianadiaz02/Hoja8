package com.hoja8;
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * @author Diana Díaz 21066
 * @author Mario Puente 21290
 * @version 1.0
 * Fecha 7/04/2022
 */
//imports
import java.util.Vector;

//la clase de vectorHeap que implementa el priorityQueue, con la comparable
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

	protected Vector<E> data; // the data, kept in heap order

	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++) { // add elements to heap
			add(v.get(i));
		}
	}

	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i - 1) / 2;
	}

	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2 * i + 1;
	}

	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2 * i + 1) + 1;
	}

	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
			data.set(leaf, data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf, value);
	}

	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize) {
				if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo(value) < 0) {
					data.set(root, data.get(childpos));
					root = childpos; // keep moving down
				} else { // found right location
					data.set(root, value);
					return;
				}
			} else { // at a leaf! insert and halt
				data.set(root, value);
				return;
			}
		}
	}

	@Override
	public E getFirst() {
		return data.get(0);
	}

	@Override
	public E remove() {
		E minVal = getFirst();
		data.set(0, data.get(data.size() - 1));
		data.setSize(data.size() - 1);
		if (data.size() > 1)
			pushDownRoot(0);
		return minVal;
	}

	@Override
	public void add(E value) {
		data.add(value);
		percolateUp(data.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	/**
	 * public String toString(){ String info=""; for(int i=0;i<data.size();i++){
	 * info = info+data.get(i); } return info; }
	 */
	public String print() {
		String print = "";
		for (int i = 0; i < data.size(); i++) {
			print = print + data.get(i) + "\n";
		}
		return print;
	}

}