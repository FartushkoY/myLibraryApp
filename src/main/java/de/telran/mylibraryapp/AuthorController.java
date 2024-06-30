package de.telran.mylibraryapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @GetMapping
    public List<Author> getAllAuthors() {
        return Author.authorList;
    }


    @GetMapping("/searchById")
    public ResponseEntity<Author> getAuthorById(@RequestParam Integer id) {
        Optional<Author> author = Author.authorList.stream().filter(a -> a.getId() == id).findFirst();
        if (author.isPresent()) {
            return new ResponseEntity<>(author.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author.authorList.add(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        if (Author.authorList.contains(author)) {
            int index = Author.authorList.indexOf(author);
            Author.authorList.add(index, author);
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            Author.authorList.add(author);
            return new ResponseEntity<>(author, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAuthorById(@RequestParam int id) {
            Author.authorList.removeIf(author -> author.getId() == id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/searchByNameOrSurname")
    public ResponseEntity<List<Author>> getAuthorByNameOrSurname(@RequestParam String nameOrSurname) {
        if (Author.authorList.stream().map(Author::getName).anyMatch(n -> nameOrSurname.equals(n))) {
            List<Author> listByName = Author.authorList.stream().filter(author -> nameOrSurname.equals(author.getName())).toList();
            return new ResponseEntity<>(listByName, HttpStatus.OK);
        } else if (Author.authorList.stream().map(Author::getSurname).anyMatch(s -> nameOrSurname.equals(s))) {
            List<Author> listBySurname = Author.authorList.stream().filter(author -> nameOrSurname.equals(author.getSurname())).toList();
            return new ResponseEntity<>(listBySurname, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/serchByKeyworts")
    public ResponseEntity<List<Author>> getAuthorsByKeyworts(@RequestParam String keywort) {
        if (Author.authorList.stream().map(Author::getName).anyMatch(s -> s.contains(keywort))) {
            List<Author> listRes = Author.authorList.stream().filter(author -> author.getName().contains(keywort)).toList();
            return new ResponseEntity<>(listRes, HttpStatus.OK);
        } else if (Author.authorList.stream().map(Author::getSurname).anyMatch(s -> s.contains(keywort))) {
            List<Author> listRes = Author.authorList.stream().filter(author -> author.getSurname().contains(keywort)).toList();
            return new ResponseEntity<>(listRes, HttpStatus.OK);
        } else if (Author.authorList.stream().map(Author::getAuthorInfo).anyMatch(s -> s.contains(keywort))) {
                List<Author> listRes = Author.authorList.stream().filter(author -> author.getAuthorInfo().contains(keywort)).toList();
                return new ResponseEntity<>(listRes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
