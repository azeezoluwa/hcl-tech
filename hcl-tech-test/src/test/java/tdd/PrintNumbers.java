package tdd;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BasePage;

public class PrintNumbers extends BasePage {

	
	@Test(priority=1)
	public void printNumbers() 
	{
		//print the numbers 1,2,3,4,5,6,7,8,9,10
		for(int number : numbers)
		{
			System.out.println(number);
		}	
	}

	@Test(priority=2)
	public void unitTestIndexex() 
	{
		//Should return true
		System.out.println((numbers[0]==1 || numbers[9]==10));

		//Should return false
		System.out.println((numbers[0]==0 || numbers.length -1==10));

		assertTrue(numbers[0]==1);
		assertTrue(numbers[1]==2);
		assertTrue(numbers[2]==3);
		assertTrue(numbers[3]==4);
		assertTrue(numbers[4]==5);
		assertTrue(numbers[5]==6);
		assertTrue(numbers[6]==7);
		assertTrue(numbers[7]==8);
		assertTrue(numbers[8]==9);
		assertTrue(numbers[9]==10);
	}
}
