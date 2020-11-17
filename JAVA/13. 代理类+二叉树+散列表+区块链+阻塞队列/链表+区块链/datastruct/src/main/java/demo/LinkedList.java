package demo;
/**
 *     ˫��ѭ������
 */
public class LinkedList<E> {
	//��ű�ͷ(����һ���ڵ�)�ĵ�ַ(����)
	private Node head;
	//��Žڵ�ĸ���(����ĳ���)
	private int size;
	
	/**
	 *   ��ָ��λ�ò���ĳ��Ԫ��
	 * @param index λ��
	 * @param e Ҫ�����Ԫ��
	 */
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(
					"�±�Խ��");
		}
		//���λ�õ�������ĳ��ȣ���ʾ��
		//����ĩβ��ӡ�
		if(index == size) {
			add(e);
			return;
		}
		//���ҵ�ָ��λ�õĽڵ�
		Node next = getNode(index);
		Node prev = next.prev;
		//��next��prevָ��Ϊ����ӵĽڵ��ǰ��
		//�ͺ�̽ڵ�
		Node node = new Node(e);
		next.prev = node;
		node.prev = prev;
		prev.next = node;
		node.next = next;
		//�����ӵ�λ����0��������ӵĽڵ�
		//��Ϊͷ�ڵ㡣
		if(index == 0) {
			head = node;
		}
		size ++;
		
	}
	
	/**
	 *  ����ָ��λ�õ�Ԫ�ء�
	 * @param index λ��(λ���Ǵ�0��ʼ��)
	 * @return ָ��λ�õ�Ԫ��
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new 
			IndexOutOfBoundsException(
					"�±�Խ��");
		}
		Node node = getNode(index);
		return node.data;
	}
	
	/**
	 *    ɾ��ָ��λ�õ�Ԫ��
	 * @param index λ��
	 * @return  Ԫ��
	 */
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new 
			IndexOutOfBoundsException(
					"�±�Խ��");
		}
		//ֻ��һ���ڵ�
		if(size == 1) {
			E data = head.data;
			head = null;
			size --;
			return data;
		}
		
		//�ҵ�Ҫɾ���Ľڵ�
		Node node = getNode(index);
		//�ҵ��ýڵ����һ��(ǰ��)��
		//��һ���ڵ�(���)
		Node prev = node.prev;
		Node next = node.next;
		//��ǰ���ͺ�̽������ù�ϵ
		prev.next = next;
		next.prev = prev;
		//���ɾ������ͷ�ڵ㣬��Ҫ����һ���ڵ�
		//ָ��Ϊͷ�ڵ㡣
		if(index == 0) {
			head = next;
		}
		size --;
		//����ɾ����Ԫ��
		return node.data;
	}

	private Node getNode(int index) {
		Node node = head;
		if(index < size /2) {
			System.out.println("������");
			for(int i = 0; i< index; i ++) {
				node = node.next;
			}	
		}else {
			System.out.println("��ǰ����");
			for(int i = size; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}
	
	/**
	 *   �������ĳ��ȡ�
	 * @return ����ĳ���(���������м����ڵ�)
	 */
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		//�������Ϊ�գ�����[]
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
	 *  �������ĩβ���ĳ��Ԫ�ء�
	 * @param e Ҫ��ӵ�Ԫ�ء�
	 * @return ��ӳɹ�������true��
	 */
	public boolean add(E e) {
		/*
		 * �����ǰ����Ϊ�գ���ýڵ�Ϊͷ�ڵ㡣
		 */
		if(head == null) {
			head = new Node(e);
			head.next = head;
			head.prev = head;
			size ++;
			return true;
		}
		/*
		 * �����ǰ����Ϊ�գ��򽫸�Ԫ����ӵ�
		 * ����ĩβ��
		 */
		Node node = new Node(e);
		//���ҵ���β(���һ���ڵ�)
		Node end = head.prev;
		//���½ڵ���ӵ���β(�����½�
		//���µ����ù�ϵ)
		end.next = node;
		node.next = head;
		head.prev = node;
		node.prev = end;
		size ++;
		return true;
	}
	
	/**
	 *   �ڵ���:
	 *     ���ڷ�װҪ��ӵ�Ԫ��
	 *
	 */
	private class Node{
		//data��Ҫ��ӵ�Ԫ��
		E data;
		//�����һ���ڵ�ĵ�ַ(����)
		Node next;
		//�����һ���ڵ�ĵ�ַ
		Node prev;
		
		public Node(E e) {
			data = e;
		}
	}
}

