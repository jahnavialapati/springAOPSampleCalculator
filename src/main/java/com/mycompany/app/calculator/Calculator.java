package com.mycompany.app.calculator;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.mycompany.app.aspectvalidation.ValidationAspect;

@Service
public class Calculator {
	public Integer addNumbers(int valueOne, int valueTwo) {
		Logger logger=Logger.getLogger(ValidationAspect.class.getName());
		int sum=valueOne+valueTwo;
		logger.info(" "+sum);
		return sum;
	}
}
