package a4;

//name: Olivia Woodhouse
//ID: 260734701

public class HashLinkedList<K,V>{
	/*
	 * Fields
	 */
	private HashNode<K,V> head;

	private Integer size;

	/*
	 * Constructor
	 */

	HashLinkedList(){
		head = null;
		size = 0;
	}

	
	/*
	 *Add (Hash)node at the front of the linked list
	 */

	public void add(K key, V value){
		// ADD CODE BELOW HERE
		HashNode<K,V> newNode = new HashNode<K,V>(key, value);
		if (head==null) {
			this.head = newNode;
			this.size++;
		}
		else if(this.getListNode(key)==null) {
			newNode.next = head;
			this.head = newNode;
			this.size++;
		}
		else if(this.getListNode(key)!=null) {
			this.replace(key,value);
		}
		// ADD CODE ABOVE HERE
	}

	/*
	 * Get Hash(node) by key
	 * returns the node with key
	 */

	public HashNode<K,V> getListNode(K key){
		// ADD CODE BELOW HERE
		HashNode<K,V> tmp = null;
		if (size==0) {
			return tmp;
		}
		tmp = head;
		while (!(key.equals(tmp.getKey())) && (tmp.next!=null)) {
			tmp = tmp.next;
		}
		if (!(key.equals(tmp.getKey())) && (tmp.next==null)) {
			tmp = null;
		}
		if ((tmp == head) && (!(key.equals(tmp.getKey())))) {
			tmp = null;
		}
		return tmp;
		// ADD CODE ABOVE HERE
	}


	/*
	 * Remove the head node of the list
	 * Note: Used by remove method and next method of hash table Iterator
	 */

	public HashNode<K,V> removeFirst(){
		// ADD CODE BELOW HERE
		HashNode<K,V> tmpHead = head;
		if (size==0) {
			return null;
		}
		if (tmpHead==null) {
			return null;
		}
		if (size==1) {
			this.size--;
			this.head = null;
			tmpHead.next = null;
			return tmpHead;
		}
		else {
			this.size--;
			this.head = head.next;
			tmpHead.next = null;
			return tmpHead;
		}
		// ADD CODE ABOVE HERE
	}

	/*
	 * Remove Node by key from linked list 
	 */

	public HashNode<K,V> remove(K key){
		// ADD CODE BELOW HERE
		if (this.size()==0) {
			return null;
		}
		HashNode<K,V> tmp = this.getListNode(key);
		if (tmp==null) {
			return null;
		}
		if ((size==1) && (key.equals(head.getKey()))) {
			this.size--;
			tmp = head;
			this.head = null;
			tmp.next = null;
			return tmp;
		}
		if ((tmp.getKey().equals(head.getKey()))) {
			this.size--;
			tmp = head;
			this.head = head.next;
			tmp.next = null;
			return tmp;
		}
		else {
			this.size--;
			if (tmp.next!=null) {
				this.getPreviousNode(tmp).next = tmp.getNext();
			}
			else {
				this.getPreviousNode(tmp).next = null;
			}
			tmp.next = null;
			return tmp;
		}
		// ADD CODE ABOVE HERE
	}



	/*
	 * Delete the whole linked list
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	/*
	 * Check if the list is empty
	 */

	boolean isEmpty(){
		return size == 0? true:false;
	}

	int size(){
		return this.size;
	}

	//ADD YOUR HELPER  METHODS BELOW THIS
	
	//gets the previous node of specified current node in this list
	public HashNode<K,V> getPreviousNode(HashNode<K,V> currentNode) {
		HashNode<K,V> tmp = null;
		if ((size==0) || (currentNode.equals(head))) {
			return tmp;
		}
		else {
			tmp = this.head;
			while (!(tmp.next.equals(currentNode))) {
				tmp = tmp.getNext();
			}
		}
		return tmp;
	}
	
	//replaces and returns value of node if key already exists in this list
	public void replace(K key, V value) {
		HashNode<K,V> replacedNode = this.getListNode(key);
		HashNode<K,V> newNode = new HashNode<K,V>(key,value);
		if (replacedNode!=null) {
			replacedNode.setValue(newNode.getValue());
		}
	}
	
	//gets a node at the specified index
	public HashNode<K,V> getNode(int index) {
		if ((index<0)||(index>=size)) {
			return null;
		}
		else {
			if (index==0) {
				return head;
			}
			else {
				int tmpIndex = 0;
				HashNode<K,V> curr = head;
				while (tmpIndex<index) {
					curr = curr.next;
					tmpIndex++;
				}
				return curr;
			}
		}
	}

	//ADD YOUR HELPER METHODS ABOVE THIS
}

