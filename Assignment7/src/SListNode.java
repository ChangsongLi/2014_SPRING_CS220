/*
 *  Node class for containing the data we want to save. 
 *  
 *   Jason Li
 *   May 7th
 */
public class SListNode {
	private SListNode next;
	private Object data;
	
	public SListNode(Object d){
		data = d;
		next = null;
	}
	
	public SListNode(Object d,SListNode n){
		data = d;
		next = n;
	}
	
	public SListNode getNext(){
		return next;
	}
	
	public Object getData(){
		return data;
	}
	
	public void setNext(SListNode n){
		next = n;
	}
	
	public void setData(Object d){
		data = d;
	}
}
