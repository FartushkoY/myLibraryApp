package de.telran.mylibraryapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private int id;
    private String name;
    private String surname;
    private String authorInfo;

    public static List<Author> authorList = new ArrayList<>(List.of(
            new Author(1, "William", "Shakespeare", "English playwright, poet, and actor, widely regarded as the greatest writer in the English language."),
            new Author(2, "Jane", "Austen", "English novelist known primarily for her six major novels, which interpret, critique and comment upon the British landed gentry at the end of the 18th century."),
            new Author(3, "Charles", "Dickens", "English writer and social critic. He created some of the world's best-known fictional characters and is regarded by many as the greatest novelist of the Victorian era."),
            new Author(4, "George", "Orwell", "English novelist, essayist, journalist and critic, whose work is marked by lucid prose, awareness of social injustice, opposition to totalitarianism, and outspoken support of democratic socialism."),
            new Author(5, "Virginia", "Woolf", "English writer, considered one of the most important modernist 20th-century authors and also a pioneer in the use of stream of consciousness as a narrative device."),
            new Author(6, "Agatha", "Christie", "English writer known for her sixty-six detective novels and fourteen short story collections, particularly those revolving around her fictional detectives Hercule Poirot and Miss Marple."),
            new Author(7, "J.R.R.", "Tolkien", "English writer, poet, philologist, and academic, best known as the author of the high fantasy works The Hobbit and The Lord of the Rings."),
            new Author(8, "C.S.", "Lewis", "British writer and lay theologian. He held academic positions in English literature at both Oxford University and Cambridge University and is best known for his works of fiction, especially The Screwtape Letters, The Chronicles of Narnia, and The Space Trilogy."),
            new Author(9, "Mary", "Shelley", "English novelist who wrote the Gothic novel Frankenstein; or, The Modern Prometheus, which is considered an early example of science fiction."),
            new Author(10, "Arthur", "Conan Doyle", "British writer and physician, best known for his creation of the detective Sherlock Holmes, generally considered a milestone in the field of crime fiction.")
    ));
}
