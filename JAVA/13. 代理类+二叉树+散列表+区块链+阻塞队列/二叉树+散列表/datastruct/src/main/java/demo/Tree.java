package demo;
/**
 * �������������
 *
 */
public class Tree<E extends Comparable<E>> {
	//root������ڵ������
	private Node root;
	
	
	
	@Override
	public String toString() {
		if(root == null) {
			return "[]";
		}
		StringBuilder buf = 
				new StringBuilder("[");
		root.appendTo(buf);
		buf.delete(buf.lastIndexOf(","),
				buf.length());
		return buf.append("]").toString();
	}
	




	/**
	 * �����ĳ��Ԫ�ء�
	 * 	������ظ�Ԫ�أ�������ӣ�����false��
	 */
	public boolean add(E e) {
		if(root == null) {
			//��ǰ���ڵ�Ϊ�գ��Ըýڵ���Ϊ���ڵ�
			root = new Node(e);
			return true;
		}else {
			//���ڵ㲻Ϊ�գ����ýڵ���ӵ�
			//���ڵ�������ϡ�
			return root.addChild(e);
		}
	}
	
	
	
	
	/**
	 *  �ڵ���
	 */
	class Node{
		// �ڵ㵱�д�ŵ�����
		E data;
		// left��right������������������
		Node left;
		Node right;
		public Node(E e) {
			data = e;
		}
		
		/**
		 * ���õݹ�ķ�ʽ���������ڵ㣬
		 * ���ڵ��ֵ��ӵ�StringBuilder�����ϡ�
		 */
		public void appendTo(StringBuilder buf) {
			//�ȱ���������
			if(left != null) {
				left.appendTo(buf);
			}
			//�ٷ��ʸ��ڵ�
			buf.append(data).append(",");
			//���������
			if(right != null) {
				right.appendTo(buf);
			}
		}
		
		/**
		 *   ��Ԫ����ӵ��ýڵ�������ϡ�
		 * @param e��Ҫ��ӵ�Ԫ��
		 * @return����ӳɹ�������true,���
		 * ��Ԫ���ظ�������false��
		 */
		public boolean addChild(E e) {
			if(e.compareTo(data) == 0) {
				//Ԫ���ظ����������
				return false;
			}else if(e.compareTo(data) < 0) {
				//����ӵ�Ԫ�رȵ�ǰ�ڵ��ֵС
				//,���Ԫ��Ҫ��ӵ���ǰ�ڵ��
				//�������ϡ�
				if(left == null) {
					//������Ϊ��
					left = new Node(e);
					return true;
				}else {
					//��������Ϊ��
					return left.addChild(e);
				}
			}else {
				//��Ԫ��Ҫ��ӵ���ǰ�ڵ��
				//��������
				if(right == null) {
					right = new Node(e);
					return true;
				}else {
					return right.addChild(e);
				}
			}
		}
		
		
	}
	
	
}




