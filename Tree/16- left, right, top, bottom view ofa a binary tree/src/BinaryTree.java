import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a Binary Tree. The task is to print the nodes of the binary tree when viewed 
 * from different sides. That is, the left view of the binary tree will contain only 
 * those nodes which can be seen when the Binary tree is viewed from left.
 * 
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
class Node{
	int key;
	Node left, right;
	Node (int key){
		this.key = key;
	}
}

public class BinaryTree {
	// prints the bottom view of a binary tree
	public static void bottom(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			System.out.print(root.key + " ");
		bottom(root.left);
		bottom(root.right);
	}
	
	// prints the top view of a binary tree
	public static void top(Node root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		if (root.left != null)
			System.out.print(root.left.key + " ");
		if (root.right != null)
			System.out.print(root.right.key + " ");
	}
	
	// prints the left view of a binary tree
	public static void left(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				Node curr = q.poll();
				if (i == (0))
					System.out.print(curr.key + " ");
				if (curr.left != null)
					q.offer(curr.left);
				if (curr.right != null)
					q.offer(curr.right);
			}
		}
	}
	
	// prints the right view of a binary tree
	public static void right(Node root) {
		if (root == null) {
            return;
        }
 
        Queue<Node> q = new LinkedList<>();
        q.add(root);
 
        while (!q.isEmpty()) {
 
            // get number of nodes for each level
            int n = q.size();
 
            // traverse all the nodes of the current level
            for (int i = 0; i < n; i++) {
                Node curr = q.peek();
                q.remove();
 
                // print the last node of each level
                if (i == n - 1) 
                    System.out.print(curr.key + " ");
                
 
                // if left child is not null add it into the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
 
                // if right child is not null add it into the queue
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("Borrom view: ");
		bottom(root);
		System.out.println();
		
		System.out.println("Top view: ");
		top(root);
		System.out.println();
		
		System.out.println("Left view: ");
		left(root);
		System.out.println();
		
		System.out.println("Right view: ");
		right(root);
		System.out.println();

	}

}
