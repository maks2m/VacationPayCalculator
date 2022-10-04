package com.example.vacationpaycalculator;

import com.example.vacationpaycalculator.service.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class VacationPayCalculatorApplicationTests {

	@Test
	public void testCalculateSalaryWitchTwoParams() {
		CalcService calcService = new CalcService();
		assertEquals(7425, calcService.calculateSalary(50000, 5));
	}
	@Test
	public void testCalculateSalaryWitchThreeParams() {
		CalcService calcService = new CalcService();
		LocalDate startDate = LocalDate.of(2022, 10, 1);
		LocalDate finishDate = LocalDate.of(2022, 10, 5);
		assertEquals(7425, calcService.calculateSalary(50000, startDate,  finishDate));
	}

}
