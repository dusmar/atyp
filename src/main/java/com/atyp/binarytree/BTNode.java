package com.atyp.binarytree;

/**
 * 
 * @author dmarusca
 *
 * @param <E>
 */
public class BTNode<E> {

	private E data;
	private BTNode<E> left, right;

	public BTNode(E data) {
		super();
		this.data = data;
	}

	public BTNode(E data, BTNode<E> left, BTNode<E> right) {
		this(data);
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BTNode<E> getLeft() {
		return left;
	}

	public void setLeft(BTNode<E> left) {
		this.left = left;
	}

	public BTNode<E> getRight() {
		return right;
	}

	public void setRight(BTNode<E> right) {
		this.right = right;
	}

}
