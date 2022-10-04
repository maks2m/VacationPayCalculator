package com.example.vacationpaycalculator.controller;

import com.example.vacationpaycalculator.service.CalcService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculacte")
public class CalcController {

    private final CalcService service;

    public CalcController(CalcService service) {
        this.service = service;
    }

    @GetMapping
    public long getCalculate(
            @RequestParam(name = "average_salary") Long averageSalary,
            @RequestParam(name = "vacation_days", required = false) Integer vacationDays,
            @RequestParam(name = "date_start_vacation", required = false) LocalDate dateStartVacation,
            @RequestParam(name = "date_finish_vacation", required = false) LocalDate dateFinishVacation) {
        if ((dateStartVacation == null && dateFinishVacation == null) && vacationDays != null) {
            return service.calculateSalary(averageSalary, vacationDays);
        } else if((dateStartVacation != null && dateFinishVacation != null) && vacationDays == null){
            return service.calculateSalary(averageSalary, dateStartVacation, dateFinishVacation);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    // /calculacte?average_salary=50000&vacation_days=14
    // /calculacte?average_salary=50000&vacation_days=14&date_start_vacation=04.10.2022&date_finish_vacation=15.10.2022
}
