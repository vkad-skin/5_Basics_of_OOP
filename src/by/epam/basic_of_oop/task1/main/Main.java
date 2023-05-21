package by.epam.basic_of_oop.task1.main;

import by.epam.basic_of_oop.task1.directory.Directory;
import by.epam.basic_of_oop.task1.file_text.FileText;
import by.epam.basic_of_oop.task1.info_view.InfoView;

/*
 * Задача 1: Создать объект класса Текстовый файл, используя классы Файл, Директория. 
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directory directory = new Directory("2 курс", "D://Lesson/2 курс");
		FileText fileText = new FileText("Курсовая", directory, 23.5,
				"Тема: Программирование");
		
		InfoView.showInfoFileText(fileText);

		fileText.renameFile("Лабораторная");
		InfoView.showInfoFileText(fileText);
		fileText.changeFileContent(" в Java");
		fileText.showFileContent();
		fileText = fileText.deleteFile();
		InfoView.showInfoFileText(fileText);
	}

}
