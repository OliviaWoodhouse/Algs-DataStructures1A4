package a4;

//name: Olivia Woodhouse
//ID: 260734701

public  class HashNode<K,V> implements Cloneable{
	private V value;
	private K key;
	public HashNode<K,V> next;

	/*
	 * Constructor.
	 */

	HashNode(K key, V value){
		this.value = value;
		this.key = key;
		this.next = null;
	}

	//ADD HELPER METHODS BELOW HERE

	// Hint: Implement a  'Public' clone() method
	//clones the node
	/*public HashNode<K,V> clone() {
		HashNode<K,V> cloneNode = new HashNode<K,V>(this.getKey(),this.getValue());
		cloneNode.next = this.getNext();
		return cloneNode;
	}
	*/
	
	//sets the value
	public void setValue(V newValue) {
		this.value = newValue;
	}
	
	//method for getting this HashNode's corresponding HashTable

	//ADD HELPER METHODS ABOVE HERE

	/*
	 * Returns this hash entry's value. 
	 * Assume entry is not null.
	 */

	public V getValue(){
		return this.value;
	}
	/*
	 * Returns this hash nodes's key.  
	 * Assume entry is not null.
	 * @return This hash nodes's key
	 */

	public K getKey(){
		return this.key;
	}
	/*
	 * Return Next node
	 */
	HashNode<K,V> getNext(){
		return this.next;
	}

	@Override
	public String toString() {
		/*
		 * Implemented method. You do not need to modify.
		 */
		return key.toString()+" : " + value.toString();
		//return  value.toString();
	}

}
