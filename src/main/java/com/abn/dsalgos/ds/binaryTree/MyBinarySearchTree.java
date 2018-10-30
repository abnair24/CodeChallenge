package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;

public class MyBinarySearchTree<T extends Comparable<T>> {

    MyBSTNode<T> root;

    public MyBinarySearchTree() {
        root = null;
    }

    public void insertNode(MyBSTNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }

        MyBSTNode<T> current = root;
        MyBSTNode<T> parent = null;

        while(current != null) {
            parent = current;

            if(node.data.compareTo(current.data) < 0) {

                current = current.left;
                if(current == null) {
                    parent.left = node;
                    return;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    public boolean search(MyBSTNode<T> node) {
        MyBSTNode<T> temp = root;
        MyBSTNode<T> parent = null;

        while(temp!=null){

            if(node.data.compareTo(temp.data) == 0){
                System.out.println("parent :"+ parent.data);
                return true;
            }
            if(node.data.compareTo(temp.data) > 0) {
                parent = temp;
                temp = temp.right;
            }
            if(node.data.compareTo(temp.data) < 0) {
                parent = temp;
                temp = temp.left;
            }
        }

        return false;
    }

    public boolean delete(MyBSTNode<T> node) {

        MyBSTNode<T> temp = root;
        MyBSTNode<T> parent = null;
        boolean isNodePresent = false;

        /*
        Search for node
         */
        while (temp != null) {
            if (node.data.compareTo(temp.data) == 0) {
                isNodePresent = true;
                break;
            }
            if (node.data.compareTo(temp.data) > 0) {
                parent = temp;
                temp = temp.right;
            }
            if (node.data.compareTo(temp.data) < 0) {
                parent = temp;
                temp = temp.left;
            }
        }

        if (!isNodePresent || temp == null) {
            return false;
        } else {
            /*
            If node to delete has only right child, connect parent to right child.
             */
            if (temp.left == null) {
                if (parent.left == temp) {
                    parent.left = temp.right;
                } else {
                    parent.right = temp.right;
                }
                return true;
                /*
                If node to delete has only left child, connect parent to left child.
                 */
            } else if (temp.right == null) {
                if (parent.left == temp) {
                    parent.left = temp.left;
                } else {
                    parent.right = temp.left;
                }
                return true;

                /*
                If node to delete has both childs, and if right child left is not null, find the lowest possible
                value from right left children. Replace value with node.
                 */
            } else if (temp.left != null && temp.right != null) {

                temp = getSuccessorNode(temp);

                return true;
            }
        }
        return false;
    }

    /*
    Helper method to find lowest inorder successor to replace the node to be deleted.
     */
    private MyBSTNode<T> getSuccessorNode(MyBSTNode<T> n) {
        MyBSTNode<T> successorParent = n.right;
        MyBSTNode<T> successor = successorParent.left;

        if(successor != null) {
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            n.data = successor.data;
            successorParent.left = successor.left;
        } else {
            n.data = successorParent.data;
            n.right = successorParent.right;
        }
        return n;
    }


    public void display(MyBSTNode<T> node) {
        if(node != null) {
            display(node.left);
            System.out.print(node.data + " ");
            display(node.right);
        }
    }

}
