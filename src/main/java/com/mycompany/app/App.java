package com.mycompany.app;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.app.calculator.Calculator;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Calculator calculator=context.getBean(Calculator.class);
		calculator.addNumbers(0,0);
		
    }
}
