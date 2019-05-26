//package ru.ryabtsev.spring.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.ryabtsev.spring.entities.Book;
//import ru.ryabtsev.spring.services.BooksService;
//
//import java.util.List;
//
///**
// * Implements controller for 'Book' entity.
// */
//@Controller
//@RequestMapping("/books")
//public class BooksController {
//
//    private static final String DEFAULT_BOOK_TITLE = "Unknown Title";
//
//    private BooksService booksService;
//
//    @Autowired
//    public void setBooksService(BooksService booksService) {
//        this.booksService = booksService;
//    }
//
//    @RequestMapping("/list")
//    private String showList(Model model) {
//        List<Book> books = booksService.getAll();
//        model.addAttribute("booksList", books);
//        return "books-list";
//    }
//
//    @RequestMapping(path="/add", method= RequestMethod.GET)
//    public String showAddForm(Model model) {
//        Book book = new Book();
//        book.setTitle(DEFAULT_BOOK_TITLE);
//        model.addAttribute("book", book);
//        return "add-book-form";
//    }
//
//    @RequestMapping(path="/add", method=RequestMethod.POST)
//    public String showAddForm(Book book) {
//        booksService.add(book);
//        return "redirect:/books/list";
//    }
//
//    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
//    public String removeById(@PathVariable(value = "id") Long id) {
//        booksService.removeById(id);
//        return "redirect:/books/list";
//    }
//}
