package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;

public class BinarySearchTreeArrayOfNodesDeletion<Integer> {

    MyBSTNode<java.lang.Integer> root;

    public BinarySearchTreeArrayOfNodesDeletion() {
        root = null;
    }

    public void insertNode(MyBSTNode<java.lang.Integer> node) {
        if (root == null) {
            root = node;
            return;
        }

        MyBSTNode<java.lang.Integer> current = root;
        MyBSTNode<java.lang.Integer> parent;

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

    public void deleteArray(MyBSTNode<java.lang.Integer> root, int[] queries) {

        for(int i : queries) {
            delete(root,i);
        }
        display(root);
    }

    public boolean delete(MyBSTNode<java.lang.Integer> node ,int query) {

        java.lang.Integer q = query;
        MyBSTNode<java.lang.Integer> temp = node;
        MyBSTNode<java.lang.Integer> parent = null;
        boolean isNodePresent = false;

        /*
        Search for node
         */
        while (temp != null) {
            if (q.compareTo(temp.data) == 0) {
                isNodePresent = true;
                break;
            }
            else if (q.compareTo(temp.data) > 0) {
                parent = temp;
                temp = temp.right;
            }
            else if(q.compareTo(temp.data) < 0) {
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

    private MyBSTNode<java.lang.Integer> getSuccessorNode(MyBSTNode<java.lang.Integer> n) {

        MyBSTNode<java.lang.Integer> successor = n.right;
        MyBSTNode<java.lang.Integer> current = successor;
        MyBSTNode<java.lang.Integer> parent = n.right;

        if(successor.right != null && successor.left == null) {
            n.data = successor.data;
            n.right = successor.right;
        } else {
            while(successor.left !=  null) {
                parent = successor;
                successor = successor.left;
            }
            n.data = successor.data;
            parent.left = successor.right;
        }

        return n;
    }

    public void display(MyBSTNode<java.lang.Integer> node) {
        if(node != null) {
            display(node.left);
            System.out.print(node.data + " ");
            display(node.right);
        }
    }
}
