package FileOrganize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OrganizeFile {

	// Organize files by its extension to their specific folders
	public void organizeFiles(String sourcePath) {
		// If path is empty or not entered
		if (sourcePath.isEmpty()) {
			System.out.println("Please Enter the path, try again");
			return;
		}

		File directory = new File(sourcePath);
		// If the given path is not correct
		if (!directory.isAbsolute()) {
			System.out.println("The provide path is not valid");
			return;
		}
		// Get the list of files present in soucrePath
		File[] listFiles = directory.listFiles();
		if (listFiles.length == 0) {
			System.out.println("The current directory does not contain any files");
			return;
		}
		for (File file : listFiles) {
			String fileName = file.getName();
			// Extracting the extensions of files
			String fileExtension = getFileExtension(fileName);
			if (!fileExtension.isEmpty()) {
				// creating files by its extension name and getting its target path
				createFileByExtension(fileExtension, file);
				moveFilestoDirectories(fileExtension, file);
			}
		}
	}

	// get file extension
	private String getFileExtension(String fileName) {

		int lastIndexOf = fileName.lastIndexOf('.');
		// If fileName not contains '.' and the '.' is on the last postion of String
		if (!fileName.contains(".") && fileName.indexOf('.') == fileName.length() - 1) {
			return "";
		}
		return fileName.substring(lastIndexOf + 1).toLowerCase();
	}

	// creating files
	private void createFileByExtension(String directoryName, File file) {
		// Check this below condition working or not by undo the fileOrganizer
		if (!Files.exists(file.toPath().getParent().resolve(directoryName))) {
			try {
				Files.createDirectory(file.toPath().getParent().resolve(directoryName));
				System.out.println("File is created with name: " + directoryName + " at " + file.toPath().getParent());
			} catch (IOException e) {
				System.err.println("Failed to create a file name: " + directoryName);
				e.printStackTrace();
			}
		}
		return;
	}

	// Moving files
	private void moveFilestoDirectories(String directoryName, File file) {

		Path pathSource = file.toPath();
		Path targetDirectory = pathSource.getParent().resolve(directoryName);

		Path pathTarget = targetDirectory.resolve(file.getName());

		try {
			Files.move(pathSource, pathTarget,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Moved File " + file.getName() + " to directory : " + directoryName);
		} catch (IOException e) {
			System.err.println("Failed to move file " + file.getName() + " to directory " + directoryName);
			e.getStackTrace();
		}
	}
}
