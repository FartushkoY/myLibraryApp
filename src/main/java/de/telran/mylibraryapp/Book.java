package de.telran.mylibraryapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private  String title;

    private String author;

    private String category;

    private  int availableAmount;

    private String isbn;

    public static List<Book> library = new ArrayList<>(List.of(
            new Book("Java in action", "Urma R.-G., Fusco M., Mycroft A.", "Java", 2, "1"),
            new Book("Algorithms", "Robert Sedgewick, Kevin Wayne", "Java", 1, "2"),
            new Book("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides", "Java", 4, "3"),
            new Book("Sherlock Holmes", "Arthur Conan Doyle", "Detective", 3, "4"),
            new Book("Harry Potter and the Philosopher's stone", "J. K. Rowling", "Fantasy", 4, "5"),
            new Book("1984", "George Orwell", "Dystopian", 5, "9780451524935"),
            new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 7, "9780061120084"),
            new Book("Pride and Prejudice", "Jane Austen", "Romance", 3, "9781503290563"),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 4, "9780743273565"),
            new Book("Moby Dick", "Herman Melville", "Adventure", 2, "9781503280786"),
            new Book("War and Peace", "Leo Tolstoy", "Fiction", 6, "9780199232765"),
            new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 5, "9780316769488"),
            new Book("The Odyssey", "Homer", "Epic", 10, "9780140268867"),
            new Book("The Divine Comedy", "Dante Alighieri", "Epic", 4, "9780142437223"),
            new Book("Jane Eyre", "Charlotte Brontë", "Romance", 3, "9781503278196"),
            new Book("Wuthering Heights", "Emily Brontë", "Fiction", 4, "9780141439556"),
            new Book("Brave New World", "Aldous Huxley", "Dystopian", 7, "9780060850524"),
            new Book("Madame Bovary", "Gustave Flaubert", "Fiction", 5, "9780140449129"),
            new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Magic Realism", 8, "9780060883287"),
            new Book("In Search of Lost Time", "Marcel Proust", "Modernist", 2, "9780143039570"),
            new Book("Ulysses", "James Joyce", "Modernist", 3, "9780199535675"),
            new Book("Don Quixote", "Miguel de Cervantes", "Adventure", 7, "9780060934347"),
            new Book("The Iliad", "Homer", "Epic", 5, "9780140275360"),
            new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 9, "9780345339683"),
            new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 4, "9781451673319")
    ));

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
}
