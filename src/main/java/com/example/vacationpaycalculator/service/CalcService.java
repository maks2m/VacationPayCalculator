package com.example.vacationpaycalculator.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Service
public class CalcService {
    public Long calculateSalary(long averageSalary,
                                int vacationDays) {
        return calc(averageSalary, vacationDays);
    }
    public Long calculateSalary(long averageSalary,
                                LocalDate dateStartVacation,
                                LocalDate dateFinishVacation) {
        long vacationDays = dateFinishVacation.toEpochDay() - dateStartVacation.toEpochDay() + 1;
/*
        Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        long workingVacationDays = dateStartVacation.datesUntil(dateFinishVacation)
                .filter(d -> !weekend.contains(d.getDayOfWeek()))
                .count();
*/
        return calc(averageSalary, vacationDays);
    }

    private long calc(Long averageSalary, long vacationDays) {
        long salaryPerDay = Math.round((averageSalary / 29.3) * 0.87);
        return salaryPerDay * vacationDays;
    }
}
