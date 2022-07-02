class Book {
    final private String isbn, name, author;
    private short stock;

    Book(String isbn, String name, String author, Short stock) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.stock = stock;
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

    public Short getStock() {
        return this.stock;
    }

    public void addStock(short newStock) {
        this.stock += newStock;
    }
}