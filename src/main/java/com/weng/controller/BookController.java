package com.weng.controller;

import com.weng.pojo.Books;
import com.weng.service.BookService;
import com.weng.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {

        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper() {

        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
}
