package demo;
/**
 *     双向循环链表
 */
public class LinkedList<E> {
	//存放表头(即第一个节点)的地址(引用)
	private Node head;
	//存放节点的个数(链表的长度)
	private int size;
	
	/**
	 *   在指定位置插入某个元素
	 * @param index 位置
	 * @param e 要插入的元素
	 */
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(
					"下标越界");
		}
		//如果位置等于链表的长度，表示向
		//链表末尾添加。
		if(index == size) {
			add(e);
			return;
		}
		//先找到指定位置的节点
		Node next = getNode(index);
		Node prev = next.prev;
		//将next和prev指定为新添加的节点的前驱
		//和后继节点
		Node node = new Node(e);
		next.prev = node;
		node.prev = prev;
		prev.next = node;
		node.next = next;
		//如果添加的位置是0，则新添加的节点
		//成为头节点。
		if(index == 0) {
			head = node;
		}
		size ++;
		
	}
	
	/**
	 *  返回指定位置的元素。
	 * @param index 位置(位置是从0开始的)
	 * @return 指定位置的元素
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new 
			IndexOutOfBoundsException(
					"下标越界");
		}
		Node node = getNode(index);
		return node.data;
	}
	
	/**
	 *    删除指定位置的元素
	 * @param index 位置
	 * @return  元素
	 */
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new 
			IndexOutOfBoundsException(
					"下标越界");
		}
		//只有一个节点
		if(size == 1) {
			E data = head.data;
			head = null;
			size --;
			return data;
		}
		
		//找到要删除的节点
		Node node = getNode(index);
		//找到该节点的上一个(前驱)和
		//下一个节点(后继)
		Node prev = node.prev;
		Node next = node.next;
		//让前驱和后继建立引用关系
		prev.next = next;
		next.prev = prev;
		//如果删除的是头节点，需要将下一个节点
		//指定为头节点。
		if(index == 0) {
			head = next;
		}
		size --;
		//返回删除的元素
		return node.data;
	}

	private Node getNode(int index) {
		Node node = head;
		if(index < size /2) {
			System.out.println("向后遍历");
			for(int i = 0; i< index; i ++) {
				node = node.next;
			}	
		}else {
			System.out.println("向前遍历");
			for(int i = size; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}
	
	/**
	 *   获得链表的长度。
	 * @return 链表的长度(即链表当中有几个节点)
	 */
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		//如果链表为空，返回[]
		if(head == null) {
			return "[]";
		}
		StringBuilder buf = 
				new StringBuilder("[" 
		+ head.data);
		Node node = head.next;
		while(node != head) {
			buf.append("," + node.data);
			node = node.next;
		}
		return buf.append("]").toString();
	}

	/**
	 *  在链表的末尾添加某个元素。
	 * @param e 要添加的元素。
	 * @return 添加成功，返回true。
	 */
	public boolean add(E e) {
		/*
		 * 如果当前链表为空，则该节点为头节点。
		 */
		if(head == null) {
			head = new Node(e);
			head.next = head;
			head.prev = head;
			size ++;
			return true;
		}
		/*
		 * 如果当前链表不为空，则将该元素添加到
		 * 链表末尾。
		 */
		Node node = new Node(e);
		//先找到链尾(最后一个节点)
		Node end = head.prev;
		//将新节点添加到链尾(即重新建
		//立新的引用关系)
		end.next = node;
		node.next = head;
		head.prev = node;
		node.prev = end;
		size ++;
		return true;
	}
	
	/**
	 *   节点类:
	 *     用于封装要添加的元素
	 *
	 */
	private class Node{
		//data是要添加的元素
		E data;
		//存放下一个节点的地址(引用)
		Node next;
		//存放上一个节点的地址
		Node prev;
		
		public Node(E e) {
			data = e;
		}
	}
}

