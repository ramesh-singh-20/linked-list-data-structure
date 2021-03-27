package com.alphacoder.datastructure;

import lombok.Data;
import lombok.Getter;

@Getter
public class LinkedList {
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
}
