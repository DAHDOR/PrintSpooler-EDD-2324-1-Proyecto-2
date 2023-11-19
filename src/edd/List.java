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
public class List <T> {
    private Node <T> pFirst;
    private Node <T> pLast;
    private int size;
    
    // Constructor
    public List() {
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return pFirst == null;
    }
    
    public Node first() {
        return pFirst;
    }
    
    public Node last() {
        return pLast;
    }
    
    public T read(Node <T> pValue) {
        return pValue.tInfo;
    }
    
    public Node <T> next(Node <T> pValue) {
        if (pValue != null) {
            return pValue.pNext;
        } else {
            return null;
        }
    }
    
    public void add(T elem) {
        Node <T> pNew = new Node(elem);
        if (pFirst == null) {
            pFirst = pNew;
            pLast = pNew;
        } else {
            pLast.pNext = pNew;
            pLast = pNew;
        }
        size++;
    }
    public void delete(T elem) {
        Node <T> pCurr = pFirst;
        Node <T> pPrev = null;
        boolean found = false;
        while ((pCurr != null) && (!found)) {
            found = (pCurr.tInfo == elem);
            if (!found) {
                pPrev = pCurr;
                pCurr = pCurr.pNext;
            }
        }
        if (pCurr != null) {
            if (pCurr == pFirst) {
                pFirst = pCurr.pNext;
            } else {
                pPrev.pNext = pCurr.pNext;
            }
        }
    }
    
    public void clear() {
        while (pFirst != null) {
            pFirst = pFirst.pNext;
        }
    }
    
    public boolean contains(T elem) {
        for (Node <T> pAux = pFirst; pAux != null; pAux = pAux.pNext) {
            if (elem == pAux.tInfo) {
                return true;
            }
        }
        return false;
    }
    
    public void show() {
        Node <T> pValue = first();
        while (pValue != null) {
            System.out.println(pValue.tInfo);
            pValue = pValue.pNext;
        }
    }
}
