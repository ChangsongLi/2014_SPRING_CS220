/*
 *  My List class Implement the List class
 *  
 *   Jason Li
 *   May 7th
 */

import java.util.*;

@SuppressWarnings("rawtypes")
public class SinglyLinkedList implements List{

	private int size;
	private SListNode head;
	
	public SinglyLinkedList(){
		size = 0;
		SListNode n = new SListNode(null);
		head = n;
	}

	@Override
	public int size() {
		return size;
	}

	public void print(){
		SListNode next = head.getNext();
		
		while(next != null){
			System.out.println(next.getData());
			
			next = next.getNext();
		}
	}
	@Override
	public boolean add(Object e) {
		if(e == null)
			return false;
		
		SListNode n = new SListNode(e);
		if(isEmpty()){
			head.setNext(n);
			size++;
			return true;
		}
		
		SListNode next = head.getNext();
		SListNode previous = head;
		
		while( next != null ){
			if(  ( (Student)e ).compareTo( (Student)(next.getData()) ) < 0){
				previous.setNext(n);
				n.setNext(next);
				size++;
				return true;
			}
			next = next.getNext();
			previous = previous.getNext();
		}
		
		previous.setNext(n);
		size++;
		return true;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		if(isEmpty()){
			return false;
		}
		
		SListNode next = head.getNext();
		while(next != null){
			if( ((Student)(next.getData())).equals((Student)o) ){
				return true;
			}
			next = next.getNext();
		}
		
		return false;
	}


	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	

}