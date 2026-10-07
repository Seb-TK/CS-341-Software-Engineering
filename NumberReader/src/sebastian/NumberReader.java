package sebastian;

import java.io.File;
import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NumberReader {
	
	NumberReaderList numberList;
	
	public NumberReader() {
		numberList = new NumberReaderList();
	}
	
	public NumberReaderList getNumberList() {
		return numberList;
	}
	
	public File chooseFile() {
		JFileChooser chooser = new JFileChooser();
		
		int choice = chooser.showOpenDialog(null);
		
		if(choice == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}
	
	public enum Result {
		SUCCESS(""),
		FILE_NOT_FOUND("Error: File not found!\nMake sure to pick a .txt file."),
		INVALID_FILE_TYPE("Error: invalid file type!\nMake sure to pick a file that ends with .txt"),
		INVALID_DATA_TYPE("Error: File contains invalid data/format!\nMake sure that there is nothing but one integer per line.");
		
		private String errorMessage;
		
		Result (String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
		String getErrorMessage(){
			return errorMessage;
		}
	}
	
	
	public Result addFileToList(File file) {
		if(file == null) {
			return Result.FILE_NOT_FOUND;
		}
		
		String fileName = file.getName();
		try {
			if(!fileName.substring(fileName.lastIndexOf(".")).equals(".txt")) {
				return Result.INVALID_FILE_TYPE;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return Result.INVALID_FILE_TYPE;
		}
		
		try (Scanner scanner = new Scanner(file)){
			while(scanner.hasNextLine()) {
				try {
					numberList.addNode(Integer.parseInt(scanner.nextLine()));
				} catch(NumberFormatException e) {
					return Result.INVALID_DATA_TYPE;
				}
			}
		} catch(FileNotFoundException e) {
			return Result.FILE_NOT_FOUND;
		}
		
		return Result.SUCCESS;
	}
}
