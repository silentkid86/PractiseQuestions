package com.silentkid.practice;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 
 3 2 A2 4 5 * A1 A1 B2 / 2 + 3 39 B1 B2 * /
 */

public class SpreadSheet {

	private static BigDecimal[] resultMatrixs;
	private static String[] inputExprMatrix;
	private static boolean[][] adjMatrix;
	private static int columnInput;
	private static int rowInput;
	private static boolean[] visiteds;
	private static boolean circular;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		String n = sc.nextLine();

		StringTokenizer stk = new StringTokenizer(n.trim());
		columnInput = Integer.parseInt(stk.nextToken());
		rowInput = Integer.parseInt(stk.nextToken());

		int totalNode = rowInput * columnInput;
		adjMatrix = new boolean[totalNode][totalNode];

		inputExprMatrix = new String[totalNode];
		resultMatrixs = new BigDecimal[rowInput * columnInput];

		for (int i = 0; i < totalNode; i++) {

			inputExprMatrix[i] = sc.nextLine();

			String[] tokens = inputExprMatrix[i].split(" ");
			for (String tkn : tokens) {
				boolean containsAlphabet = tkn.matches(".*[a-zA-Z]+.*");
				if (containsAlphabet) {
					updateAdjMatrix(i, tkn);
				}
			}

		}

		processGraph();
		
		if(circular){
			System.out.println("Error: Circular dependency!");
		}else{
			DecimalFormat df = new DecimalFormat("#0.00000");
			for (BigDecimal r : resultMatrixs) {
				System.out.println(df.format(r));
			}
			
		}
		

		sc.close();

	}

	private static void processGraph() {
		visiteds = new boolean[rowInput * columnInput];
		for (int i = 0; i < resultMatrixs.length; i++) {
			if (null == resultMatrixs[i]) {
				dfs(i, new Vector<Integer>(rowInput * columnInput));

			}
			if(circular) return;
		}

	}

	private static void dfs(int node, Vector<Integer> vistHistory) {

		visiteds[node] = true;
		vistHistory.add(node);

		boolean[] neighbours = adjMatrix[node];

		for (int i = 0; i < rowInput * columnInput; i++) {
			if (neighbours[i]) {

				if (vistHistory.contains(i) && visiteds[i]) {
					
					circular = true;
					return;
				}

				if (!visiteds[i])
					dfs(i, vistHistory);

			}
		}
		
		if(circular) return;
		
		resultMatrixs[node] = evalRPN(node);

	}

	private static void updateAdjMatrix(int node, String cellNumber) {
		int indexOf = getIndexOf(cellNumber);

		adjMatrix[node][indexOf] = true;
	}

	private static int getIndexOf(String cellNumber) {
		// Assume rows only A-Z
		int rowNumber = getRowNum(cellNumber);

		int targetIndex = rowNumber * columnInput;

		int columnNumber = getColumnNumber(cellNumber);

		targetIndex += columnNumber;

		return targetIndex;
	}

	private static int getColumnNumber(String cellNumber) {
		return Integer.parseInt(cellNumber.substring(1)) - 1;
	}

	private static int getRowNum(String cellNumber) {
		char cellChar = cellNumber.charAt(0);
		int rowNumber = cellChar - 'A';
		return rowNumber;
	}

	/**
	 * @param index
	 * @return
	 */
	public static BigDecimal evalRPN(int index) {
		String[] tokens = inputExprMatrix[index].split(" ");

		Stack<Object> stack = new Stack<Object>();
		String operators = "+-*/";

		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(token);
			} else {
				BigDecimal operand1 = getNext(stack.pop());
				BigDecimal operand2 = getNext(stack.pop());

				int indexOf = operators.indexOf(token);
				switch (indexOf) {
				case 0:
					stack.push(operand1.add(operand2));
					break;
				case 1:
					stack.push(operand2.subtract(operand1));
					break;
				case 2:
					stack.push(operand1.multiply(operand2));
					break;
				case 3:
					stack.push(operand2.divide(operand1, 5,
							RoundingMode.HALF_UP));
					break;

				}
			}

		}

		return getNext(stack.pop());
	}

	private static BigDecimal getNext(Object popped) {
		if (popped instanceof String) {
			String poppedStr = (String) popped;

			boolean containsAlphabet = poppedStr.matches(".*[a-zA-Z]+.*");
			if (containsAlphabet) {
				int indexOf = getIndexOf(poppedStr);
				return resultMatrixs[indexOf];
			} else {
				BigDecimal decimal = new BigDecimal(poppedStr);
				return decimal.setScale(5);
			}
		} else {
			return (BigDecimal) popped;
		}



	}

}
