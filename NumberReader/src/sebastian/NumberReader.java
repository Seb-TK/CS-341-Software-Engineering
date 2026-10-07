package sebastian;

import java.io.File;
import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Reads integer data from a text file and adds the values to a
 * NumberReaderList.
 */
public class NumberReader {
	
	NumberReaderList numberList;
	
	/**
	 * Constructs a NumberReader with an empty NumberReaderList.
	 */
	public NumberReader() {
		numberList = new NumberReaderList();
	}
	
	/**
	 * Returns the NumberReaderList containing the numbers read from a file.
	 *
	 * @return the NumberReaderList
	 */
	public NumberReaderList getNumberList() {
		return numberList;
	}
	
	/**
	 * Opens a file chooser that allows the user to select a file.
	 *
	 * @return the selected file, or null if no file was selected
	 */
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
	
	/**
	 * Represents the possible results of attempting to read a file.
	 */
	public enum Result {
		SUCCESS(""),
		FILE_NOT_FOUND("Error: File not found!\nMake sure to pick a .txt file."),
		INVALID_FILE_TYPE("Error: invalid file type!\nMake sure to pick a file that ends with .txt"),
		INVALID_DATA_TYPE("Error: File contains invalid data/format!\nMake sure that there is nothing but one real number per line.");
		
		private String errorMessage;
		
		/**
		 * Constructs a Result with the specified error message.
		 *
		 * @param errorMessage the error message associated with this result
		 */
		Result (String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
		/**
		 * Returns the error message associated with this result.
		 *
		 * @return the error message
		 */
		String getErrorMessage(){
			return errorMessage;
		}
	}
	
	/**
	 * Reads integers from the specified file and adds them to the
	 * NumberReaderList.
	 *
	 * @param file the file containing the integer data
	 * @return the result of the file-reading operation
	 */
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
					numberList.addNode(Double.parseDouble(scanner.nextLine()));
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
