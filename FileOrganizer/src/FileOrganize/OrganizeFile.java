package FileOrganize;

import java.io.File;
import java.nio.file.Files;

public class OrganizeFile {

	// Organize files by its extension to their specific folders
	public void organizeFiles(String sourcePath) {
		//If path is empty or not entered
		if (sourcePath.isEmpty()) {
			System.out.println("Please Enter the path, try again");
			return;
		}
	
		File directory = new File(sourcePath);
		//If the given path is not correct
		if (!directory.isDirectory() && !directory.isAbsolute()) {
			System.out.println("The provide path is not a directory OR valid");
			return;
		}
		//Get the list of files present in soucrePath
		File[] listFiles = directory.listFiles();
		
		for (File file : listFiles) {
			String fileName = file.getName();
			
			//Extracting the extensions of files
			String fileExtension = getFileExtension(fileName);
			if (!fileExtension.isEmpty()) {
				
				//creating files by its extension name and getting its target path
				String targetFilePath = createFileByExtension(fileExtension, sourcePath,file);
				if(!targetFilePath.isEmpty()) {
					System.out.println("file is created at :"+targetFilePath);
					//moving the file into thier specific folder
					moveFilestoDirectories(targetFilePath,sourcePath);
				}
			}
		}

	}

	private String getFileExtension(String fileName) {

		int lastIndexOf = fileName.lastIndexOf('.');
		// If fileName not contains '.' and the '.' is on the last postion of String
		if (lastIndexOf == -1 && lastIndexOf == fileName.length() - 1) {
			return "";
		}
		/*
		 * if(!fileName.contains(".") && fileName.indexOf('.')==fileName.length()-1) {
		 * return""; }
		 */
		return fileName.substring(lastIndexOf + 1).toLowerCase();
	}

	private String createFileByExtension(String directoryName, String sourcePath,File file) {
		
			File newFile = new File(sourcePath,directoryName);
			newFile.mkdir();
		
		return newFile.toString() ;
	}
	
	private void moveFilestoDirectories(String targetFilePath, String sourcePath) {
		// TODO Auto-generated method stub
		
	}
}
