public class AddToCart {
    public BookSingle[] books;
    public double price;
    public int index;

    public AddToCart(BookSingle[] books, double price) {
        this.books = books;
        this.price = price;
    }

    public AddToCart() {

    }

    public BookSingle[] getBooks() {
        return books;
    }

    public void setBooks(BookSingle[] books) {
        books = books;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookSingle[] addBook(BookSingle book) {
        if (index < books.length) {
            if (book.getPrice() + getTotalPrice() <= 1000) {
                this.books[index++] = book;
            } else {
                String message="System is full!";
                return null;
            }
        } else {
            String message="Too many books for an order!";
            return null;
        }
        return books;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (BookSingle book : this.books) {
            if (book != null) {
                totalPrice += book.getPrice();
            }
        }
        return totalPrice;

    }

    public String printOrder() {
        if (index == 0) {
            System.out.println("Order is in progrerss");
            return null;
        } else {
            //System.out.println("The candies from order " + this.id + " for client " + client.getName() + " are:");
            for (BookSingle book : this.books) {
                if (book != null) {
                    return book.getTitle();
                }
            }
        }
        return null;
    }
}