package assignment07;

public class TestCases {
	
	public TestCases(){
		
	}
	
	public int testCaseOne(){
		System.out.println("testCaseOne with int return value: SHOULD NOT RUN");
		return 0;
	}
	
	public void testCaseTwo(int value){
		System.out.println("testCaseTwo with one parameter: SHOULD NOT RUN");
	}
	
	public void caseTestThree(){
		System.out.println("caseTestThree without starting with test name: SHOULD NOT RUN");
	}
	
	public void caseTestFour(int value){
		System.out.println("caseTestThree without starting with test name and one parameter: SHOULD NOT RUN");
	}
	
	public void testCaseFive(){
		System.out.println("testCaseFive with everything as expected: SHOULD RUN");
	}
	
	public void testCaseSix(){
		System.out.println("testCaseSix with everything as expected: SHOULD RUN");
	}
	
	public void testCaseSeven(){
		System.out.println("testCaseSeven with everything as expected: SHOULD RUN");
	}
	
	@SuppressWarnings("unused")
	private void testCaseEight(){
		System.out.println("testCaseEight with everything as expected but private: SHOULD NOT RUN");
	}
	
	public void testCaseNine() throws Exception{
		throw new Exception("Launching exception");
	}

}
