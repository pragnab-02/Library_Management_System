package com.example.demo.controller;

import com.example.demo.entity.BorrowingRecord;
import com.example.demo.service.BorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping("/borrow")
    public BorrowingRecord borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return borrowingService.borrowBook(userId, bookId);
    }

    @PostMapping("/return/{borrowId}")
    public BorrowingRecord returnBook(@PathVariable Long borrowId, @RequestParam Long userId) {
        return borrowingService.returnBook(borrowId, userId);
    }

    @GetMapping("/users/{userId}/borrowing")
    public List<String> getUserBorrowingHistory(@PathVariable Long userId) {
        return borrowingService.getUserBorrowHistory(userId).stream().map(record -> {
            long fine = borrowingService.calculateFine(record);
            return "Book: " + record.getBook().getTitle() +
                    " | Borrowed: " + record.getBorrowDate() +
                    " | Returned: " + (record.getReturnDate() != null ? record.getReturnDate() : "Not yet") +
                    " | Fine: $" + fine;
        }).collect(Collectors.toList());
    }
}
