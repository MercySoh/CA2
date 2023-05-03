/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import ApplicationData.Appointments;
import java.util.NoSuchElementException;

/**
 *
 * @author asus
 */
public class PriorityQueue extends LinkedList {

//    private int capacity;
//
//    public PriorityQueue() {
//
//    }
//
//    public PriorityQueue(int capacity) {
//        this.capacity = capacity;
//    }
//
//    /**
//     * Get the size of Queue.
//     *
//     * @return size in Queue
//     */
//    @Override
//    public int size() {
//        return super.size();
//    }

//    /**
//     * Check the Queue is empty or not.
//     *
//     * @return true when Queue is empty else return false
//     */
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }

//    /**
//     * Check the Queue is full or not.
//     *
//     * @return true when Queue size is over than capacity else return false
//     */
//    public boolean isFull() {
//        return size >= capacity;
//    }

    /**
     * Adds a task to the Queue.
     *
     * @param value is use for the specified, it add value in order of triage level where 1 is higher than 5
     * @return true when value added else return false when value not added
     * @throws IllegalStateException when queue is full
     * @throws DuplicateElementException when task is duplicate
     */
    @Override
    public boolean add(Appointments value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
            size++;
            return true;
        } else if (isFull()) {
            throw new IllegalStateException("Task is full.");
        } else {
            for (int i = 0; i < size; i++) {
//                if (this.get(i).equals(value)) {
//                    throw new DuplicateElementException("Task already exists.");
//                }
            }
            last.next = newNode;
            last = newNode;
            size++;

            return true;
        }
    }
    
      /**
     * Peeks first task from the Queue.
     *
     * @return first task when the Queue not empty
     * @throws NoSuchElementException when queue is empty
     */
    public Appointments peek() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    /**
     * Remove first task from the Queue.
     *
     * @return first task when removed
     * @throws NoSuchElementException when queue is empty
     */
    public Appointments remove() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }
        Appointments original = first.data;
        first = first.next;
        size--;
        return original;
    }
}
