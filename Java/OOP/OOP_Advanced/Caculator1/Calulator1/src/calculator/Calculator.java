package calculator;



public class Calculator {
	private double operand1;
	private String operation;
	private double operand2;
	private double results;
	
//	Constructor
	public Calculator() {}
	
//	Setters and Getters
	public double getOperand1() {
		return operand1;
	}
	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getOperand2() {
		return operand2;
	}

	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}

	public double getResults() {
		return results;
	}


	public void setResults(double results) {
		this.results = results;
	}
	
//	methods
	public void doOperation() {
		if (operation.equals("+")) {
			results=operand1+operand2;
		}else if (operation.equals("-")) {
			results=operand1+operand2;
		}else {
			System.out.print("Invalid input");
		}
	}


	public static void main(String[] args) {
		 Calculator calculator= new Calculator();
		 calculator.setOperand1(100);
		 calculator.setOperation("+");
		 calculator.setOperand2(200);// TODO Auto-generated method stub
		 
		 calculator.doOperation();
		 System.out.print(calculator.getResults());
	}

}
