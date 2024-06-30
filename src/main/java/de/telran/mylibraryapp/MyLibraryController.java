package de.telran.mylibraryapp;

import org.apache.tomcat.jni.Library;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class MyLibraryController {

    private List<Book> library;

    public MyLibraryController() {
        library = new ArrayList<Book>();
        library.add(new Book("Java in action", "Urma R.-G., Fusco M., Mycroft A.", "Java", 2, "1"));
        library.add(new Book("Algorithms", "Robert Sedgewick, Kevin Wayne", "Java", 1, "2"));
        library.add(new Book("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides", "Java", 4, "3"));
        library.add(new Book("Sherlock Holmes", "Arthur Conan Doyle", "Detectives", 3, "4"));
        library.add(new Book("Harry Potter and the Philosopher's stone", "J. K. Rowling", "Fantasy", 4, "5"));
    }


    @GetMapping
    public String helloMessage() {
        return "Hello from my excellent website!";
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return library;
    }

    @GetMapping("/{category}")
    public List<Book> getAllByCategory(@PathVariable String category) {
        List<Book> result = library.stream().filter(b -> b.getCategory().equals(category)).toList();
        if (result.isEmpty()) {
            throw new RuntimeException("No books by category " + category + " found. Try serch by another category");
        }
        return result;
    }

    @GetMapping("/serchByTitle")
    public List<Book> getAllByTitle(@RequestParam String title, @RequestParam(required = false) Integer amount) {
        return library.stream()
                .filter(b -> b.getTitle().startsWith(title))
                .filter(b -> amount == null || b.getAvailableAmount() >= amount)
                .toList();
    }

    //REST запрос на вывод одной книги по ее isbn
    @GetMapping("/serchByIsbn")
    public ResponseEntity<Book> getByIsbn(@RequestParam String isbn) {
        Optional<Book> book = library.stream().filter(b -> b.getIsbn().equals(isbn)).findAny();
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //REST запрос на вывод общего числа книг в библиотеке (с учетом копий)
    @GetMapping("/totalAmount")
    public int getTotalAmount() {
        return library.stream().mapToInt(Book::getAvailableAmount).sum();
    }

    //REST запрос на вывод общего числа книг в отдельной категории
    @GetMapping("/amountByCategory")
    public int getAmountByCategory(@RequestParam String category) {
        return library.stream().filter(b -> b.getCategory().equals(category)).mapToInt(Book::getAvailableAmount).sum();
    }

    //REST запрос на заполнение всех пустых полей author значением "Unknown"
    @PatchMapping("/changeToUnknown")
    public List<Book> changeToUnknownAuthor() {
        return library.stream().filter(b -> b.getAuthor() == null).peek(b -> b.setAuthor("Unknown")).toList();
    }

    //REST запрос на удаление из списка книг всех книг, у которых не указан title
    @DeleteMapping("/deleteUntitled")
    public ResponseEntity<?> deleteUntitledBooks() {
        library.removeIf(b -> b.getTitle() == null);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        library.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        if (library.contains(book)) {
            int index = library.indexOf(book);
            library.set(index, book);
            return new ResponseEntity<>(book, HttpStatus.valueOf(204));
        } else {
            library.add(book);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        }
    }

    @PatchMapping
    public ResponseEntity<Book> updateAmountOfBooks(@RequestParam String isbn, @RequestParam Integer amount) {
        Optional<Book> book = library.stream().filter(b -> b.getIsbn().equals(isbn)).peek(b -> b.setAvailableAmount(amount)).findAny();

        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByIsbn(@RequestParam String isbn) {
        library.removeIf(b -> b.getIsbn().equals(isbn));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

//    вид запроса зависит только от логики, прописанной разработчиком, а не от типа указанного запроса
    // пример некорректного запроса
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> delete() {
//        library.add(new Book("", "", "" ,0, ""));
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }





}
