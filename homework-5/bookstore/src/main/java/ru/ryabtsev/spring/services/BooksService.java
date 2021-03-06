//package ru.ryabtsev.spring.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ru.ryabtsev.spring.entities.Book;
//import ru.ryabtsev.spring.repositories.BooksRepository;
//
//import java.util.List;
//
///**
// * Implements service layer class for 'Book' objects manipulation.
// */
//@Service
//public class BooksService {
//    private BooksRepository booksRepository;
//
//    @Autowired
//    public void setBooksRepository(BooksRepository booksRepository) {
//        this.booksRepository = booksRepository;
//    }
//
//    public BooksService() {
//    }
//
//    /**
//     * Returns all books from repository.
//     * @return all books from repository
//     */
//    public List<Book> getAll() {
//        return (List<Book>) booksRepository.findAll();
//    }
//
//    /**
//     * Returns book with given id or null if this book doesn't exits in repository.
//     * @param id book identifier.
//     * @return book with given id or null if this book doesn't exits in repository.
//     */
//    public Book getById(Long id) {
//        return booksRepository.findById(id).get();
//    }
//
//    /**
//     * Adds new book into books list.
//     * @param book book which will be placed into books list.
//     */
//    public void add(Book book) {
//        booksRepository.save(book);
//    }
//
//    /**
//     * Removes book with given id.
//     * @param id id of the book which should be removed.
//     */
//    public void removeById(Long id) {
//        booksRepository.deleteById(id);
//    }
//}
