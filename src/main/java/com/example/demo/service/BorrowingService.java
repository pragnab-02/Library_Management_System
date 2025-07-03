package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BorrowingService {

    private final BorrowingRecordRepository recordRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BorrowingService(BorrowingRecordRepository recordRepository,
                            BookRepository bookRepository,
                            UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BorrowingRecord borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        long activeBorrowings = recordRepository.findByUser(user).stream()
                .filter(r -> r.getStatus() == BorrowingRecord.Status.BORROWED)
                .count();

        if (activeBorrowings >= 3) {
            throw new RuntimeException("User has reached max borrowing limit (3).");
        }

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("No copies available.");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        BorrowingRecord record = new BorrowingRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setStatus(BorrowingRecord.Status.BORROWED);
        return recordRepository.save(record);
    }

    public BorrowingRecord returnBook(Long borrowId, Long userId) {
        BorrowingRecord record = recordRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        if (!record.getUser().getId().equals(userId)) {
            throw new RuntimeException("User mismatch.");
        }

        if (record.getStatus() == BorrowingRecord.Status.RETURNED) {
            throw new RuntimeException("Book already returned.");
        }

        record.setReturnDate(LocalDate.now());
        record.setStatus(BorrowingRecord.Status.RETURNED);

        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        return recordRepository.save(record);
    }

    public List<BorrowingRecord> getUserBorrowHistory(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return recordRepository.findByUser(user);
    }

    public long calculateFine(BorrowingRecord record) {
        if (record.getStatus() == BorrowingRecord.Status.BORROWED) {
            long daysBorrowed = ChronoUnit.DAYS.between(record.getBorrowDate(), LocalDate.now());
            long overdueDays = daysBorrowed - 14;
            return overdueDays > 0 ? overdueDays : 0;
        } else if (record.getReturnDate() != null) {
            long daysBorrowed = ChronoUnit.DAYS.between(record.getBorrowDate(), record.getReturnDate());
            long overdueDays = daysBorrowed - 14;
            return overdueDays > 0 ? overdueDays : 0;
        }
        return 0;
    }
}
