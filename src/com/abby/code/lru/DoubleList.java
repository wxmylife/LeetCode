package com.abby.code.lru;

/**
 * @author wxmylife
 */
public class DoubleList {

  private Node header, tail;

  private int size;

  /**
   * 链表头部增加节点 x
   */
  public void addFirst(Node node) {
    if (header == null) {
      header = tail = node;
    } else {
      Node n = header;
      n.prev = node;
      node.next = n;
      header = node;
    }
    size++;
  }

  /**
   * 删除链表中的 X 节点（x 一定存在）
   * 由于是双链表且给的是目标 Node 节点
   */
  public void remove(Node node) {
    if (header == node && tail == node) {
      header = null;
      tail = null;
    } else if (tail == node) {
      node.prev.next = null;
      tail = node.prev;

    } else if (header == node) {
      node.next.prev = null;
      header = node.next;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    size--;
  }

  /**
   * 删除链表中最后一个节点
   */
  public Node removeLast() {
    Node node = tail;
    remove(node);
    return node;
  }

  /**
   * 返回链表长度
   */
  public int size() {
    return size;
  }

}
