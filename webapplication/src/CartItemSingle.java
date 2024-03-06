public class CartItemSingle {
    private BookSingle book;
    private int quantity;

    public CartItemSingle(BookSingle book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public CartItemSingle() {

    }

    public BookSingle getBook() {
        return book;
    }

    public void setBook(BookSingle book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(){
        this.quantity++;
    }


}
