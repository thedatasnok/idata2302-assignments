package no.ntnu.iir.halvao.idata2302;

import java.util.ArrayDeque;
import java.util.Stack;

public class Tree {
  private Node root;

  public void insert(int item) {
    Node parent = this.findParentOfItem(item);

    if (parent == null) {
      root = new Node(item);
    } else {
      if ((parent.hasLeft() && parent.getLeft().getValue() == item) 
          || (parent.hasRight() && parent.getRight().getValue() == item)) {

        throw new IllegalArgumentException("Cannot insert duplicates into the tree.");
        
      } else if (item < parent.getValue()) {
        parent.setLeft(new Node(item, parent));
      } else {
        parent.setRight(new Node(item, parent));
      }
    }
  }

  public void delete(int item) {
    Node parent = this.findParentOfItem(item);

    Node node = null;
    Boolean left = null;

    if (parent.hasLeft() && parent.getRight().getValue() == item) {
      node = parent.getLeft();
      left = true;
    } else if (parent.hasRight() && parent.getRight().getValue() == item) {
      node = parent.getRight();
      left = false;
    } else {
      throw new IllegalArgumentException("Tree does not contain a node with value: " + item);
    }

    if (!node.hasLeft() && !node.hasRight()) {
      
      if (left.booleanValue()) parent.clearLeft();
      else parent.clearRight();

    } else if (node.hasLeft() && node.hasRight()) {
      Node successor = this.findSuccessor(node);

      if (node.getRight() != successor) {
        if (successor.hasRight()) {
          successor.getParent().setLeft(successor.getRight());
          successor.getRight().setParent(successor.getParent());
        } else {
          successor.getParent().clearLeft();
        }

        successor.setRight(node.getRight());
        node.getRight().setParent(successor);
      }

      successor.setParent(parent);

      if (left.booleanValue()) parent.setLeft(successor);
      else parent.setRight(successor);

      successor.setLeft(node.getLeft());
      successor.getLeft().setParent(successor);

    } else if (node.hasLeft()) {
      
      if (left.booleanValue()) {
        parent.setLeft(node.getLeft());
        node.getLeft().setParent(parent);
      } else {
        parent.setRight(node.getLeft());
        node.getLeft().setParent(parent);
      }

    } else {

      if (left.booleanValue()) {
        parent.setLeft(node.getRight());
        node.getRight().setParent(parent);
      } else {
        parent.setRight(node.getRight());
        node.getRight().setParent(parent);
      }
    }
  }

  public Node findParentOfItem(int item) {
    Node node = root;
    Node previousNode = null;

    while (node != null) {
      if (item < node.getValue()) {
        previousNode = node;
        node = node.getLeft();
      } else if (item > node.getValue()) {
        previousNode = node;
        node = node.getRight();
      }
    }

    return previousNode;
  }

  public Node findSuccessor(Node node) {
    if (node.hasRight()) {
      node = node.getRight();

      while (node.hasLeft()) {
        node = node.getLeft();
      }

      return node;
    }

    Node parent = node.getParent();

    if (!parent.hasParent()) throw new IllegalArgumentException("Node has no successor");

    while (parent.hasParent() && node == parent.getRight()) {
      node = parent;
      parent = parent.getParent();
    }

    return parent;
  }

  public void inOrderTraversal(Node node) {
    if (node == null) return;

    inOrderTraversal(node.getLeft());

    System.out.println("" + node.getValue());

    inOrderTraversal(node.getRight());
  }

  public void postOrderTraversal(Node node) {
    if (node == null) return;

    postOrderTraversal(node.getLeft());
    postOrderTraversal(node.getRight());

    System.out.println("" + node.getValue());
  }

  public void preOrderTraversal(Node node) {
    if (node == null) return;

    System.out.println("" + node.getValue());
    preOrderTraversal(node.getLeft());
    preOrderTraversal(node.getRight());
  }

  public void iterativePreorderTraversal() {
    ArrayDeque<Node> stack = new ArrayDeque<>();
    stack.push(this.root);

    while (!stack.isEmpty()) {
      Node current = stack.pop();
      System.out.println(current.getValue());
      
      if (current.hasRight()) stack.push(current.getRight());
      if (current.hasLeft()) stack.push(current.getLeft());
    }
  }

  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(4);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
    tree.insert(2);
    tree.insert(5);

    tree.inOrderTraversal(tree.root);
    tree.postOrderTraversal(tree.root);
    System.out.println("preorder recursive");
    tree.preOrderTraversal(tree.root);
    System.out.println("preorder iter");
    tree.iterativePreorderTraversal();
  }
}
