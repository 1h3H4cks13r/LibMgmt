class Book {
    final private String isbn, name, author;
    private short count;

    Book(String isbn, String name, String author) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.count = 1;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public Short getCount() {
        return this.count;
    }

    public void incCount() {
        this.count++;
    }

    public void decCount() {
        this.count--;
    }
}