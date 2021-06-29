package hash.table.app.entity;

import java.security.NoSuchAlgorithmException;

import hash.table.app.util.HashUtil;

public class Node<K,V> implements Comparable<Node<K, V>>{

	private K key;
	
	private V value;
	
	private HashUtil<K> hash = null;

	public Node(K key, V value) throws NoSuchAlgorithmException {
		super();
		this.key = key;
		this.value = value;
		 hash = new HashUtil<>();
	}
	
	public Node(K key) {
		super();
		this.key = key;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if( obj instanceof Node) {
			Node temp = (Node) obj;
			return key.equals(temp.key);
		}
		
		
		return super.equals(obj);
	}
	
	public V getValue() {
		return value;
	}

	@Override
	public int compareTo(Node<K, V> o) {
		
		return hash.toHexString(key).compareTo(hash.toHexString(o.key));
	}

	

	
	
}
