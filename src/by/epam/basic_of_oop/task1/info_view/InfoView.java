package by.epam.basic_of_oop.task1.info_view;

import by.epam.basic_of_oop.task1.file.File;
import by.epam.basic_of_oop.task1.file_text.FileText;

public class InfoView {

	public static void showInfoFileText(FileText fileText) {

		if (fileText != null) {
			
			System.out.println("Имя файла >> " + fileText.getFileName()
					+ "; Дериктория: Имя директории >>"
					+ fileText.getDirectory().getDirectoryName()
					+ ", Путь директории >> "
					+ fileText.getDirectory().getDirectoryPath()
					+ ", Размер файла >> " + fileText.getFileSize() + " мб.");

		} else {
			System.out.println("Ошибка! Файла не существует.");
		}
	}
	
	public static void showInfoFile(File file) {

		if (file != null) {
			
			System.out.println("Имя файла >> " + file.getFileName()
					+ "; Дериктория: Имя директории >>"
					+ file.getDirectory().getDirectoryName()
					+ ", Путь директории >> "
					+ file.getDirectory().getDirectoryPath()
					+ ", Размер файла >> " + file.getFileSize() + " мб.");

		} else {
			System.out.println("Ошибка! Файла не существует.");
		}
	}
}
