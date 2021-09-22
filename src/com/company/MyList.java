package com.company;

public class MyList<T> {
    private Integer capacity;
    private T arr[];
    private T arrCopy[];
    private int indexcontrol = 0;

    public MyList(Integer capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
        this.arrCopy = (T[]) new Object[this.capacity];
        this.indexcontrol = 0;
    }

    public MyList() {
        this.capacity = 10;
        this.arr = (T[]) new Object[this.capacity];
        this.arrCopy = (T[]) new Object[this.capacity];
        this.indexcontrol = 0;
    }

    public int size() {
        int size = 0;
        for (Object l : arr) {
            if (l != null) {
                size++;
            }
        }
        return size;
    }

    public void add(T data) {

        if (checkCapacity()) {

            arr = changeCapacity();

        }
        arr[lookIndex()] = data;

    }

    public void remove(int index) {
        arr[index] = null;
        for (int i = index + 1; i < capacity; i++) {
            arr[i - 1] = arr[i];
        }
    }

    public void set(int index, T data) {
        if (index >= capacity) {
            return;
        } else {
            arr[index] = data;
        }
    }

    public int indexOf(T data) {
        int index=0;
        for (int i = 0; i < size(); i++) {
            if(arr[i]==data){
                index=i;
                return index;
            }

        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int index=0;
        boolean isLast=false;
        for (int i = 0; i < size(); i++) {
            if(arr[i]==data){
                if(isLast){
                    index=i;
                    return index;
                }else
                    isLast=true;
            }

        }
        return -1;
    }

    public boolean isEmpty(){
        if (size()==0){
            return true;
        }else
            return false;
    }

    public T[] toArray(){
        return arr;
    }

    public void clear(){
        this.arr = (T[]) new Object[this.capacity];
        this.arrCopy = (T[]) new Object[this.capacity];
    }

    public MyList<T> sublist(int start,int finish){
       MyList<T> temp = new MyList<T>(capacity);
        for (int i = start; i <=finish; i++) {
            temp.add(arr[i]);
        }
        return temp;
    }

   public boolean contains(T data){
       for (int i = 0; i < size(); i++) {
           if(arr[i]==data){
              return true;
           }}
       return false;
   }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (T element : arr) {
            if (element != null) {
                str.append(element);
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

    private T[] changeCapacity() {
        capacity *= 2;
        this.arrCopy = (T[]) new Object[this.capacity];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

    private boolean checkCapacity() {
        return capacity <= this.size();
    }

    private int lookIndex() {
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == null) {
                indexcontrol = i;
                return indexcontrol;
            }
        }
        return -1;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T get(int index) {
        return arr[index];
    }


}
