package com.alphacoder.datastructure;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LinkedList {
    @Setter
    private Node head;
    private int size;

    public boolean isEmpty(){
        return (size== 0);
    }

    public int size(){
        return this.size;
    }

    public void insert(int element, int index){
        if(index< 0 || index> size){
            throw new IndexOutOfBoundsException();
        }
        Node node= new Node();
        node.setData(element);

        if(head==null){
            head= node;
        }else{
            Node temp= head;
            Node previous= head;

            for(int i= 0; i< index; i++){
                previous= temp;
                temp= temp.getNext();
            }
            previous.setNext(node);
            node.setNext(temp);
        }
        size++;
    }

    public int get(int index){
        if(index< 0 || index>= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node temp= head;

        for(int i= 0; i< index; i++){
            temp=temp.getNext();
        }

        return temp.getData();
    }

    public void update(int element, int index){
        if(index<0 || index>=this.size){
            throw new IndexOutOfBoundsException();
        }

        Node temp= head;

        for(int i=0; i<index; i++){
            temp=temp.getNext();
        }
        temp.setData(element);
    }

    public void delete(int index){
        if(index<0 || index>= this.size){
            throw new IndexOutOfBoundsException();
        }

        Node temp= head;
        Node previous= head;
        Node next= head.getNext();

        for(int i=0; i<index; i++){
            previous= temp;
            temp=temp.getNext();
            next= temp.getNext();
        }

        previous.setNext(next);
        temp= null;
        this.size--;
    }

    public void reverse(){
        if(size==0){
            System.out.print("LinkedList is empty.");
            throw new UnsupportedOperationException();
        }
        Node temp= head;
        Node previous= null;
        Node next= head.getNext();

        while(next!= null){
            previous= temp;
            temp= next;
            next= next.getNext();
            temp.setNext(previous);
        }

        head.setNext(null);
        head= temp;
    }

    public void reverseRecursively(){
        if(size==0){
            System.out.print("LinkedList is empty.");
            throw new UnsupportedOperationException();
        }
        reverse(this.head);
    }

    private Node reverse(Node head){
        if(head== null){
            return null;
        }

        if(head.getNext()== null){
            return head;
        }

        Node newHeadNode= reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        this.head= newHeadNode;
        return newHeadNode;
    }

    public void print(){
        Node node= this.getHead();
        System.out.print("[ ");

        while(node!= null){
            System.out.print(node.getData());
            System.out.print(" ");
            node= node.getNext();
        }

        System.out.print("]");
    }

}
