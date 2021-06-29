package hash.table.app.entity;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import hash.table.app.Constants;
import hash.table.app.util.HashUtil;

public class HTable<K, V> {

	private HashUtil<K> hash = null;
	
	private ArrayList<LList<K, V>> buckets = new ArrayList<LList<K, V>>(Constants.SIZE);
	
	public HTable() throws NoSuchAlgorithmException{
		 hash = new HashUtil<>();
	}
	
	
	public void put(K key, V value) throws NoSuchAlgorithmException {
		buckets.get(hash.hashFunction(key)).add(new Node<K, V>(key, value));
	}
	
	public V get(K key) {
		return buckets.get(hash.hashFunction(key)).find(key);
				
	}
	
	public boolean containsKey(K key) {
		return buckets.get(hash.hashFunction(key)).containsKey(key);
	}
	
	
	
}
