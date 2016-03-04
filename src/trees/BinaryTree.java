package trees;

public class BinaryTree {

		TreeNode root;
		
		public void add (int data)
		{
			TreeNode newNode = new TreeNode(data);
			
			if (root == null)
			{
				root = newNode;
			}
			TreeNode traversingNode = root;
				
			traverseandAdd(traversingNode, newNode);
		}
		public boolean delete(int val)
		{
			//case 1: if node has no children
			//case 2: if node has one child
			//case 3: if node has two children
			TreeNode nodeToBeDeleted = find(val);
			
			if(nodeToBeDeleted != null)
			{
				// case 1
				if(nodeToBeDeleted.leftChild == null && nodeToBeDeleted.rightChild == null)
				{
					deleteCase1(nodeToBeDeleted);
				}
				else if(nodeToBeDeleted.leftChild != null && nodeToBeDeleted.rightChild != null)
				{
					deleteCase3(nodeToBeDeleted);
				}
				else if(nodeToBeDeleted.leftChild != null)
				{
					deleteCase2(nodeToBeDeleted);
				}
				else if(nodeToBeDeleted.rightChild != null)
				{
					deleteCase2(nodeToBeDeleted);
				}
			}
			return false;
		}
		
		
		private void deleteCase3(TreeNode nodeToBeDeleted) {
 			
			TreeNode lastLeftNode = minLeftTraversal(nodeToBeDeleted.rightChild);
			
			deleteCase2(lastLeftNode);
			
			lastLeftNode.parent = nodeToBeDeleted.parent;
			lastLeftNode.leftChild = nodeToBeDeleted.leftChild;
			lastLeftNode.rightChild = nodeToBeDeleted.rightChild;
			
			if(nodeToBeDeleted.parent == null)
			{
				root = lastLeftNode;
			}
			else
			{
				if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted)
				{
					nodeToBeDeleted.parent.leftChild = lastLeftNode;
				}
				else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted)
				{
					nodeToBeDeleted.parent.rightChild = lastLeftNode;
				}
			}
		}
		private TreeNode minLeftTraversal(TreeNode node){
			if(node.leftChild == null){
				return node;
			}
			return minLeftTraversal(node.leftChild);
		}
		private void deleteCase2(TreeNode nodeToBeDeleted)
		{
			if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted)
			{
				if(nodeToBeDeleted.leftChild != null)
				{
					nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
				}
				else if(nodeToBeDeleted.rightChild != null)
				{
					nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
				}
			}
			else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted)
			{
				if(nodeToBeDeleted.leftChild != null)
				{
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
				}
				else if(nodeToBeDeleted.rightChild != null)
				{
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
				}
			}
		}
		private void deleteCase1(TreeNode nodeToBeDeleted)
		{
			if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted)
			{
				nodeToBeDeleted.parent.leftChild = null;
			}
			else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted)
			{
				nodeToBeDeleted.parent.rightChild = null;
			}
		}
		public TreeNode find(int val)
		{
			if(root != null)
			{
				return findNode(root, new TreeNode(val));
			}
			return null;
		}
		
		private TreeNode findNode(TreeNode search, TreeNode toFindNode){
			
			if( search == null)
			{
				return null;
			}
			if(search.data == toFindNode.data)
			{
				return search;
			}else
			{
				TreeNode node = findNode(search.leftChild, toFindNode);
				if(node == null)
				{
					node = findNode(search.rightChild,toFindNode);
				}
				return node;
			}
		}
		
		private void traverseandAdd(TreeNode traversingNode, TreeNode newNode)
		{
			if(traversingNode == null)
			{
				System.out.println("No nodes to add to");
			}
			else
			{
				if(newNode.data < traversingNode.data)
				{
					if(traversingNode.leftChild == null)
					{
						newNode.parent = traversingNode;
						traversingNode.leftChild = newNode;
					}else{
						traverseandAdd(traversingNode.leftChild, newNode);
					}
				}else if(newNode.data > traversingNode.data)
				{
					if(traversingNode.rightChild == null)
					{
						newNode.parent = traversingNode;
						traversingNode.rightChild = newNode;
					}else
					{
						traverseandAdd(traversingNode.rightChild, newNode);
					}
				}
			}
		}
		
		public void inOrderTraversal()
		{
			if(root != null)
			{
				TreeNode nodeToTraverse = root;
				
				if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null)
				{
					System.out.println(nodeToTraverse.data);
				}else
				{
					inOrderTraversal(nodeToTraverse);
				}
			}
		}
		private void inOrderTraversal(TreeNode child)
		{
				if(child.leftChild != null)
				{
					inOrderTraversal(child.leftChild);
				}
				
				System.out.println(child.data);
				
				if(child.rightChild != null)
				{
					inOrderTraversal(child.rightChild);
				}
		}
		
		public void preOrderTraversal()
		{
			if(root != null)
			{
				TreeNode nodeToTraverse = root;
				
				if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null)
				{
					System.out.println(nodeToTraverse.data);
				}else
				{
					preOrderTraversal(nodeToTraverse);
				}
			}
		}
		private void preOrderTraversal(TreeNode child)
		{
				System.out.println(child.data);
			
				if(child.leftChild != null)
				{
					preOrderTraversal(child.leftChild);
				}
				if(child.rightChild != null)
				{
					preOrderTraversal(child.rightChild);
				}
		}
		
		public void postOrderTraversal()
		{
			if(root != null)
			{
				TreeNode nodeToTraverse = root;
				
				if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null)
				{
					System.out.println(nodeToTraverse.data);
				}else
				{
					postOrderTraversal(nodeToTraverse);
				}
			}
		}
		private void postOrderTraversal(TreeNode child)
		{
				if(child.leftChild != null)
				{
					postOrderTraversal(child.leftChild);
				}
				if(child.rightChild != null)
				{
					postOrderTraversal(child.rightChild);
				}
				
				System.out.println(child.data);
		}
}
