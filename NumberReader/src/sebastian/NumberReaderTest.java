package sebastian;

import java.io.File;
import java.util.ArrayList;

import sebastian.NumberReader.Result;


public class NumberReaderTest {
	public static void main (String[]args) {
		
		NumberReader reader = new NumberReader();
		File file = reader.chooseFile();
		Result result = reader.addFileToList(file);
		
		NumberReaderList numberList = reader.getNumberList();
		System.out.println("List: " + numberList.getList().toString());
		System.out.println("Mean: " + numberList.getMean());
		System.out.println("Standard Dev: " + numberList.getStandardDerivative());
	}
}
