package tdd;

import static org.testng.Assert.assertTrue;

import java.util.Scanner;

import org.testng.annotations.Test;

import base.BasePage;

public class AngleOfTriangle extends BasePage {

	
	@Test(priority=3)
	public void calculateAreaOfTriangleUsingScannerClass()	
	{
		
		//PLEASE NOTE: You will need to enter values of width and height in your console
		@SuppressWarnings("resource")
		Scanner s= new Scanner(System.in);

		System.out.println("Enter the width of the Triangle:");
		double b= s.nextDouble();

		System.out.println("Enter the height of the Triangle:");
		double h= s.nextDouble();

		//Area = (width*height)/2
		double area=(b*h)/2;
		System.out.println("Area of Triangle is: " + area);      
	}
	
	@Test(priority=4)
	public void calculateAreaOfTriangle()	
	{
		  double base = 20.0;
	      double height = 110.5;
	      double area = (base* height)/2;
	      System.out.println("Area of Triangle is: " + area); 
	      assertTrue(area==1105.0);
	    }	
	
	
}




