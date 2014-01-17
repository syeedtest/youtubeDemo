package thesis01;

import java.util.Scanner;

public class Requirement01 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("Enter a String");
		String toProcess = k.nextLine();
		int length = toProcess.length();
		System.out.println("Dataset Length: " + length);
		String result[] = new String[10000];
		String numerical[] = new String[10000];
		int resultSize = 0;
		int numericalSize = 0;
// hello
		if (length > 1000 && length < 3000) {
			String str = "";
			int testLength = length - 3 - 1600;
			// for (int counter = 0; counter < testLength; counter++) {
			for (int counter = 0; counter < 600; counter++) {
				if (counter > 2) {
					str = createSetOfTwo(str);
				}
				if (counter == 0) {
					str = str + toProcess.charAt(counter);
					// System.out.println("c0: "+str);
				} else if (counter == 1) {
					str = str + toProcess.charAt(counter);
					// System.out.println("c1: "+str);
				} else {
					if (counter == 2) {
						str = str + toProcess.charAt(counter);
					} else {
						str = createSetOfThree(str, toProcess.charAt(counter));
					}
					boolean ifStartCodon = isStartCodon(str);
					if (ifStartCodon == true) {

						// System.out.println("String: " + str
						// + " is startcodon: " + ifStartCodon);
						System.out.println("Start Codon's found at Position: "
								+ counter);
					}
					if (ifStartCodon == true) {
						int skipStarts = counter + 1;
						int skipLength = skipStarts + 1600;
						System.out.println("Skipping starting at: "
								+ skipStarts);
						System.out.println("Skipping terminates at: "
								+ skipLength);
						String skippedString = skipProcess(str, skipStarts,
								skipLength, toProcess);
						// System.out.println("Skipped String: " +
						// skippedString);
						// counter = length + 1;
						String tempArray[] = findAllStopCodons(toProcess,
								skipLength + 1, length, skippedString);
						int tempArrayLength = tempArray.length;
						for (int tl = 0; tl < tempArrayLength; tl++) {
							result[resultSize] = tempArray[tl];
							resultSize++;
						}
						// int s = result.length;
						// for(int l = 0; l < s; l++){
						// System.out.println(result[l]);
						// }
					}

				}
			}
		} else if (length > 3000) {
			String str = "";
			int testLength = length - 3 - 3000;
			for (int counter = 0; counter < testLength; counter++) {
				if (counter > 2) {
					str = createSetOfTwo(str);
				}
				if (counter == 0) {
					str = str + toProcess.charAt(counter);
					// System.out.println("c0: "+str);
				} else if (counter == 1) {
					str = str + toProcess.charAt(counter);
					// System.out.println("c1: "+str);
				} else {
					if (counter == 2) {
						str = str + toProcess.charAt(counter);
					} else {
						str = createSetOfThree(str, toProcess.charAt(counter));
					}
					boolean ifStartCodon = isStartCodon(str);
					if (ifStartCodon == true) {
						System.out.println("String: " + str
								+ " is startcodon: " + ifStartCodon);
					}
					if (ifStartCodon == true) {
						int skipStarts = counter + 1;
						int skipLength = skipStarts + 3000;
						String skippedString = skipProcess(str, skipStarts,
								skipLength, toProcess);
						// System.out.println("Skipped String: " +
						// skippedString);
						String tempArray[] = findAllStopCodons(toProcess,
								skipLength + 1, length, skippedString);
						int tempArrayLength = tempArray.length;
						for (int tl = 0; tl < tempArrayLength; tl++) {
							result[resultSize] = tempArray[tl];
							resultSize++;
						}
						// counter = length + 1;
						// result = findAllStopCodons(toProcess, skipLength + 1,
						// length, skippedString);
						// int s = result.length;
						// for(int l = 0; l < s; l++){
						// System.out.println(result[l]);
						// }
					}

				}
			}
		} else {
			System.out
					.println("The length doesn't meet necessary requirement.");
		}
		int s = resultSize;
		for (int l = 0; l < s; l++) {
			String toConvert = result[l];
			toConvert = changeToNumerical(toConvert);
			numerical[numericalSize] = toConvert;
			numericalSize++;
		}
		System.out.println("final result length: " + s);
		for (int l = 0; l < s; l++) {
			System.out.println("Final Array Counter Confirmation: " + l);
			// System.out
			// .println("-----------------------------------------------------------------------------------");
			System.out.println(result[l]);
			System.out.println(numerical[l]);
			// System.out
			// .println("-----------------------------------------------------------------------------------");
		}
		k.close();
	}

	private static String changeToNumerical(String toConvert) {
		// TODO Auto-generated method stub
		String toReturn = "";
		int length = toConvert.length();
		for (int c = 0; c < length; c++) {
			String toproc = Character.toString(toConvert.charAt(c));
			if (toproc.equalsIgnoreCase("a")) {
				toReturn = toReturn + "0";
			} else if (toproc.equalsIgnoreCase("t")) {
				toReturn = toReturn + "1";
			} else if (toproc.equalsIgnoreCase("g")) {
				toReturn = toReturn + "2";
			} else {
				toReturn = toReturn + "3";
			}
		}
		return toReturn;
	}

	private static String[] findAllStopCodons(String toProcess, int start,
			int length, String skippedString) {
		// System.out.println("toProcess: " + toProcess + " \nstart: " + start
		// + " \nlength: " + length);
		// TODO Auto-generated method stub
		System.out.println("finding stop codon > starts at: " + start
				+ " \nfinding stop codon > terminates at: " + length);
		// adfadfa
		length = 2200;
		System.out.println("finding stop codon > actually terminates at: "
				+ length);
		// adfadfa
		String toReturn[] = new String[10000];
		String toSave = "";
		int toReturnSize = 0;
		int t = 0;
		String str = "";
		System.out.println("==FINDING STOP CODON PROCESS STARTS==");
		int dd = 1;
		for (int counter = start; counter < length; counter++) {
			if (t > 2) {
				str = createSetOfTwo(str);
			}
			toSave = toSave + toProcess.charAt(counter);
			if (t == 0) {
				str = str + toProcess.charAt(counter);
				t++;
			} else if (t == 1) {
				str = str + toProcess.charAt(counter);
				t++;
			} else {
				if (t == 2) {
					str = str + toProcess.charAt(counter);
					t++;
				} else {
					str = createSetOfThree(str, toProcess.charAt(counter));
					// System.out.println("stop str: "+str);
					boolean ifStopCodon = isStopCodon(str);
					if (ifStopCodon == true) {
						System.out.println("Stop Codon Found At: " + counter);
						// System.out.println("stop codon: " + dd);
						// System.out.println(toSave);
						toReturn[toReturnSize] = toSave;
						toReturnSize++;
						dd++;
					}
				}

			}

		}
		System.out.println("==FINDING STOP CODON PROCESS TERMINATES==");
		// for (int c = 0; c < toReturnSize; c++) {
		// System.out.println("Last Part: " + toReturn[c]);
		// }
		String finalToReturn[] = new String[toReturnSize];
		for (int c = 0; c < toReturnSize; c++) {
			finalToReturn[c] = skippedString + toReturn[c];
		}
		return finalToReturn;

	}

	private static boolean isStopCodon(String str) {
		if (str.equalsIgnoreCase("TAG") || str.equalsIgnoreCase("TGA")
				|| str.equalsIgnoreCase("TAA")) {
			return true;
		}
		return false;
	}

	private static String skipProcess(String str, int skipStarts,
			int skipLength, String toProcess) {
		String toReturn = str;
		String temp = "";
		for (int counter = skipStarts; counter < skipLength; counter++) {
			temp = temp + toProcess.charAt(counter);
		}
		toReturn = toReturn + temp;
		// TODO Auto-generated method stub
		// System.out.println("length: " + toReturn.length());
		return toReturn;
	}

	private static String createSetOfTwo(String str) {
		String toReturn = Character.toString(str.charAt(1))
				+ Character.toString(str.charAt(2));
		return toReturn;
	}

	private static boolean isStartCodon(String str) {
		if (str.equalsIgnoreCase("atg")) {
			return true;
		}
		return false;
	}

	private static String createSetOfThree(String str, char charAt) {
		// TODO Auto-generated method stub
		String toReturn = str + Character.toString(charAt);
		return toReturn;
	}
}
