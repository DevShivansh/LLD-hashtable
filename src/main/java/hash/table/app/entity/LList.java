package hash.table.app.entity;

import java.util.Collections;
import java.util.LinkedList;

public class LList<K, V> extends LinkedList<Node<K, V>>{

	
	@Override
	public boolean add(hash.table.app.entity.Node<K, V> node) {
		int index = this.indexOf(node);
		if(index == -1)
			return super.add(node);
		else
			super.add(index, node);
		return true;
	}
	
	public V find(K key) {
		Node<K, V> nodeToFind = new Node<>(key);
		int index = Collections.binarySearch(this, nodeToFind);
		return (index == -1) ? null : this.get(index).getValue();
	}

	public boolean containsKey(K key) {
		
		Node<K, V> nodeToFind = new Node<>(key);
		return super.contains(nodeToFind);
	}
	
}
