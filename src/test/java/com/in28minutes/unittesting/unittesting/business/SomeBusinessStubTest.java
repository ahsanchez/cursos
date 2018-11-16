package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessStubTest {
	
	class SomeDataServiceStub implements SomeDataService {

		@Override
		public int[] retrieveAllData() {
			return new int [] {1,2,3};
		}
		
	}

	class SomeDataServiceEmptyStub implements SomeDataService {

		@Override
		public int[] retrieveAllData() {
			return new int [] {};
		}
		
	}
	
	class SomeDataServiceOneElementStub implements SomeDataService {

		@Override
		public int[] retrieveAllData() {
			return new int [] {1};
		}
		
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}

}
