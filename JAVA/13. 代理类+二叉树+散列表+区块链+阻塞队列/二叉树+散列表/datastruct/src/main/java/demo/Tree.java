package demo;
/**
 * 　排序二叉树类
 *
 */
public class Tree<E extends Comparable<E>> {
	//root保存根节点的引用
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
	 * 　添加某个元素。
	 * 	如果有重复元素，不能添加，返回false。
	 */
	public boolean add(E e) {
		if(root == null) {
			//当前根节点为空，以该节点作为根节点
			root = new Node(e);
			return true;
		}else {
			//根节点不为空，将该节点添加到
			//根节点的子树上。
			return root.addChild(e);
		}
	}
	
	
	
	
	/**
	 *  节点类
	 */
	class Node{
		// 节点当中存放的数据
		E data;
		// left和right保存左右子树的引用
		Node left;
		Node right;
		public Node(E e) {
			data = e;
		}
		
		/**
		 * 采用递归的方式遍历各个节点，
		 * 将节点的值添加到StringBuilder对象上。
		 */
		public void appendTo(StringBuilder buf) {
			//先遍历左子树
			if(left != null) {
				left.appendTo(buf);
			}
			//再访问根节点
			buf.append(data).append(",");
			//最后右子树
			if(right != null) {
				right.appendTo(buf);
			}
		}
		
		/**
		 *   将元素添加到该节点的子树上。
		 * @param e　要添加的元素
		 * @return　添加成功，返回true,如果
		 * 　元素重复，返回false。
		 */
		public boolean addChild(E e) {
			if(e.compareTo(data) == 0) {
				//元素重复，不添加了
				return false;
			}else if(e.compareTo(data) < 0) {
				//被添加的元素比当前节点的值小
				//,则该元素要添加到当前节点的
				//左子树上。
				if(left == null) {
					//左子树为空
					left = new Node(e);
					return true;
				}else {
					//左子树不为空
					return left.addChild(e);
				}
			}else {
				//该元素要添加到当前节点的
				//右子树上
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




