package com.chein.task7;

import java.util.Iterator;

public class Collection <T> implements Iterator<PartCollection<T>> {


    private PartCollection<T> head;
    private PartCollection<T> tail;
    private PartCollection<T> curr;
    private int size;



    public void add(T value) {
        PartCollection<T> newElem = new PartCollection<>(value, null, tail);
        if (tail == null) {
            head = tail = newElem;
        } else {
            tail.next = newElem;
            tail = newElem;
        }
        size++;
    }

    public PartCollection<T> delete(){
        PartCollection<T> tailDel = tail;
        tail = tail.prev;
        if (tail!= null){
            tail.next = null;
        } else {
            head = null;
        }

        size--;
        return tailDel;
    }

    public PartCollection<T> delete(T value){

        for (PartCollection<T> curr = head; curr != null; curr = curr.next){
            if (curr.value.equals(value)){
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                } else {
                    head = curr.next;
                }

                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                } else {
                    tail = curr.prev;
                }
                size--;
                return curr;
            }
        }
        return null;
    }

    public PartCollection<T> findByValue(T value){
        curr = head;
        while(hasNext()){
            PartCollection<T> current = next();
            if (current.value.equals(value)){
                return current;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    public PartCollection<T> getHead() {
        return head;
    }

    public PartCollection<T> getTail() {
        return tail;
    }


    @Override
    public boolean hasNext() {
        if (curr != null){
            return true;
        }
        return false;
    }

    @Override
    public PartCollection<T> next() {
        PartCollection<T> temp = curr;
        curr = curr.next;
        return temp;
    }
}
