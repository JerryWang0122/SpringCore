package session03.bean;

public class LibraryManager {

    private Book comicBook;
    private Book computerBook;

    public LibraryManager(Book comicBook, Book compterBook) {
        this.comicBook = comicBook;
        this.computerBook = compterBook;
    }

    public void displayComic() {
        comicBook.display();
    }

    public void displayComputer() {
        computerBook.display();
    }
}
