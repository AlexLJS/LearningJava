package JavaFeatures;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    /**
     * java 比较器 demo
     *
     * 用于自定义类型的比较，避免系统根据内存地址排序
     *
     * 负数在前
     *
     * 也可以实现 comparable 接口
     */

    public static void main(String[] args) {
        Book book1 = new Book(1,"a",29);
        Book book3 = new Book(3,"c",21);
        Book book2 = new Book(2,"b",31);

        Book[] books = {book1,book2,book3};
        Arrays.sort(books , new IdComparator());
        printBooks(books);
        Arrays.sort(books , new PriceComparator());
        printBooks(books);
    }
    private static void printBooks(Book[] books){
        for (int i = 0; i < books.length; i++) {
            System.out.print(books[i]);
            System.out.println();
        }
        System.out.println("==============");
    }
    public static class Book{
        private int id;
        private String name;
        private int price;

        public Book(int id, String name, int price){
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    static class IdComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            if (a.id < b.id){
                return -1;
            }else if (a.id > b.id){
                return 1;
            }else {
                return 0;
            }
        }
    }
    static class PriceComparator implements Comparator<Book> {
        public int compare(Book a, Book b) {
            if (a.price < b.price){
                return -1;
            }else if (a.price > b.price){
                return 1;
            }else {
                return 0;
            }
        }
    }
}

