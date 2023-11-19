/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Admin
 * @param <T>
 */
public class Node <T> {
    protected T tInfo;
    protected Node <T> pNext;
    
    public Node(T elem) {
        tInfo = elem;
        pNext = null;
    }
    
    public Node <T> next() {
        return pNext;
    }
    
    public T info() {
        return tInfo;
    }
}
