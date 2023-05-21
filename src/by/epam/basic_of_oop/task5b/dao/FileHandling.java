package by.epam.basic_of_oop.task5b.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import by.epam.basic_of_oop.task5b.bean.Product;

public interface FileHandling {
	public List<Product> getFile(File file) throws IOException;
	public boolean setFile(File file, List<Product> productArray) throws IOException;
}
