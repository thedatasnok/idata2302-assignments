package no.ntnu.iir.halvao.idata2302;

/**
 * Represents a node in a tree structure.
 * Responsible for wrapping a value and maintaining 
 * pointers to the parent and the left and right sides.
 * Can form trees when connected together.
 */
public class Node {
  private Node parent;
  private Node left;
  private Node right;
  private int value;

  public Node(int value, Node parent) {
    this.value = value;
    this.parent = parent;
  }

  public Node(int value) {
    this(value, null);
  }

  /**
   * Returns the parent of the node.
   * 
   * @return the parent of the node
   */
  public Node getParent() {
    return this.parent;
  }

  /**
   * Returns true if the node has a parent node.
   * 
   * @return true if the node has a parent node
   */
  public boolean hasParent() {
    return this.parent != null;
  }

  /**
   * Sets the parent of the node.
   * 
   * @param parent the new parent of the node
   */
  public void setParent(Node parent) {
    this.parent = parent;
  }

  /**
   * Returns the value of the node.
   * 
   * @return the value of the node
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Returns the left side of the node.
   * 
   * @return the left side of the node
   */
  public Node getLeft() {
    return this.left;
  }

  /**
   * Returns true if the left side of the node is present.
   * 
   * @return true if the left side of the node is present
   */
  public boolean hasLeft() {
    return this.left != null;
  }
  
  /**
   * Sets the left side of the node.
   * 
   * @param left the node to set on the left side of the node
   */
  public void setLeft(Node left) {
    this.left = left;
  }

  /**
   * Clears the left side of the node.
   */
  public void clearLeft() {
    this.left = null;
  }

  /**
   * Returns the right side of the node.
   * 
   * @return the right side of the node
   */
  public Node getRight() {
    return this.right;
  }

  /**
   * Returns true if the right side of the node is present.
   * 
   * @return true if the right side of the node is present
   */
  public boolean hasRight() {
    return this.right != null;
  }

  /**
   * Sets the nodes right side.
   * 
   * @param right the node to set on the right side of the node
   */
  public void setRight(Node right) {
    this.right = right;
  }

  /**
   * Clears the nodes right side reference.
   */
  public void clearRight() {
    this.right = null;
  }

  /**
   * Returns true if the node is a leaf node.
   * 
   * @return true if the node is a leaf node
   */
  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }
}
