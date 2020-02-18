package StackAndQueue;


import Utils.CatDogUtil;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 题目设计猫狗队列：
 *  猫狗类 ， 要求设计方法：add 、 pollAll 、pollDog 、 pollCat 、 isEmpty
 *  isDogEmpty 、 isCatEmpty
 *
 * 标注答案 ： 设计时间戳 类
 */
public class CatDogQueue {
    private Queue<CatDogUtil> catQueue = new Queue<CatDogUtil>() {
        @Override
        public boolean add(CatDogUtil catDogUtil) {
            return false;
        }

        @Override
        public boolean offer(CatDogUtil catDogUtil) {
            return false;
        }

        @Override
        public CatDogUtil remove() {
            return null;
        }

        @Override
        public CatDogUtil poll() {
            return null;
        }

        @Override
        public CatDogUtil element() {
            return null;
        }

        @Override
        public CatDogUtil peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<CatDogUtil> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends CatDogUtil> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
    private Queue<CatDogUtil> dogQueue = new Queue<CatDogUtil>() {
        @Override
        public boolean add(CatDogUtil catDogUtil) {
            return false;
        }

        @Override
        public boolean offer(CatDogUtil catDogUtil) {
            return false;
        }

        @Override
        public CatDogUtil remove() {
            return null;
        }

        @Override
        public CatDogUtil poll() {
            return null;
        }

        @Override
        public CatDogUtil element() {
            return null;
        }

        @Override
        public CatDogUtil peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<CatDogUtil> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends CatDogUtil> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
    private ArrayList<Integer> index = new ArrayList<>();

    public CatDogUtil add(CatDogUtil pet){
         if (pet.getPetType().equals( "cat")){
             catQueue.add(pet);
             index.add(0);
         }
         if (pet.getPetType().equals("dog")){
             dogQueue.add(pet);
             index.add(1);
         }
        return pet;
    }
    public CatDogUtil pollAll(){
        if (index.isEmpty())
            return null;
        int petType = index.get(index.size() - 1);
        CatDogUtil pollElement = new CatDogUtil();
        if ( petType == 0 ){
            pollElement = catQueue.poll();
            index.remove(index.size() - 1);
        }
        if ( petType == 1 ){
            pollElement = dogQueue.poll();
            index.remove(index.size() - 1);
        }
        return pollElement;
    }
    public CatDogUtil pollCat(){
        for (int i = 0 ; i < index.size() ; i++){
            if ( index.get(i) == 0 ){
                index.remove(i);
                return catQueue.poll();
            }
        }
        return null;
    }
    public CatDogUtil pollDog(){
        for (int i = 0 ; i < index.size() ; i++){
            if ( index.get(i) == 1 ){
                index.remove(i);
                return dogQueue.poll();
            }
        }
        return null;
    }
    public Boolean isEmpty(){
        return index.isEmpty();
    }
    public Boolean isCatEmpty(){
        return catQueue.isEmpty();
    }
    public Boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }
}
