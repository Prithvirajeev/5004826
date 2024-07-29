package Exercise6;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "1984", "George Orwell"),
            new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B004", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("B005", "Pride and Prejudice", "Jane Austen")
        };

        Library library = new Library(books);

        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found");

        System.out.println("Binary Search:");
        Book sortedBook = library.binarySearchByTitle("1984");
        System.out.println(sortedBook != null ? sortedBook : "Book not found");
    }
}

