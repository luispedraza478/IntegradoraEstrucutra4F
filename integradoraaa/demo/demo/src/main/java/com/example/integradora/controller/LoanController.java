package com.example.integradora.controller;

import com.example.integradora.dto.LoanRequest;
import com.example.integradora.service.LibraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LibraryService libraryService;

    public LoanController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public String createLoan(@RequestBody LoanRequest loanRequest) {
        return libraryService.createLoan(loanRequest.getUserId(), loanRequest.getBookId());
    }

    @PostMapping("/{loanId}/return")
    public String returnLoan(@PathVariable int loanId) {
        return libraryService.returnLoan(loanId);
    }

    @PostMapping("/undo")
    public String undoLoan() {
        return libraryService.undoLastAction();
    }

    @PostMapping("/cancel")
    public String cancelLoan(@RequestBody LoanRequest loanRequest) {
        return libraryService.cancelReservation(loanRequest.getUserId(), loanRequest.getBookId());
    }
}
