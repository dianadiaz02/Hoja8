package com.hoja8;
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * @author Diana Díaz 21066
 * @author Mario Puente 21290
 * @version 1.0
 * Fecha 7/04/2022
 */

 //la interface de priorityQueue que extiene una comparable
public interface PriorityQueue<E extends Comparable<E>> {
    public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	public int size();
	// post: returns number of elements within queue
	
	public void clear();
	// post: removes all elements from queue
}