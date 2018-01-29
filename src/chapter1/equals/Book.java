package chapter1.equals;

public class Book {

    private int isbn;

    public Book(int isbn){
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o){
        if( ! (o instanceof Book)){
            return false;
        }

        Book other = (Book) o;

        // es ist möglich auf private Member zuzugreifen
        return this.isbn == other.isbn;

    }
}
