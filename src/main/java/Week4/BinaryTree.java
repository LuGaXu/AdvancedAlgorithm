package Week4;

import sun.applet.Main;
import sun.reflect.generics.tree.Tree;

/**
 * Created by lujxu on 2018/1/3.
 */
public class BinaryTree {
    public static void main(String [] args){
        TreeNode root=new TreeNode("1");
        root.left=new TreeNode("2");
        root.left.left=new TreeNode("3");
        root.left.right=new TreeNode("4");
        root.left.right.right=new TreeNode("9");
        root.left.left.left=new TreeNode("5");
//        root.left.left.right=new TreeNode("7");
        root.left.left.left.left=new TreeNode("6");
//        root.left.left.left.right=new TreeNode("6");
        BinaryTree tree=new BinaryTree();
        tree.findMaxLength(root);
        System.out.println(tree.maxLen);
    }

    public int maxLen;

    public void findMaxLength(TreeNode root){
        if (root==null)
            return;
        if (root.left==null)
            root.leftLength=0;
        if (root.right==null)
            root.rightLength=0;
        if (root.left!=null)
            findMaxLength(root.left);
        if (root.right!=null)
            findMaxLength(root.right);
        if (root.left!=null){
            if (root.left.leftLength>root.left.rightLength)
                root.leftLength=root.left.leftLength+1;
            else
                root.leftLength=root.left.rightLength+1;
        }
        if (root.right!=null){
            if (root.right.leftLength>root.right.rightLength)
                root.rightLength=root.right.leftLength+1;
            else
                root.rightLength=root.right.rightLength+1;
        }
        if (root.leftLength+root.rightLength+1>maxLen)
        maxLen=root.leftLength+root.rightLength+1;
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    String value;
    int leftLength;
    int rightLength;

    public TreeNode(String value){
        this.value=value;
    }
}
