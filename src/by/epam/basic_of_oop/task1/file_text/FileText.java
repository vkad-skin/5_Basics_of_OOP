package by.epam.basic_of_oop.task1.file_text;

import by.epam.basic_of_oop.task1.directory.Directory;
import by.epam.basic_of_oop.task1.file.File;

public class FileText extends File {

	private String text;
	
	public FileText(){
		super();
		text = null;
	}
	
	public FileText(String fileName,Directory directory,double fileSize, String text) {
		super(fileName, directory, fileSize);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void showFileContent() {
		System.out.println(text);
	}
	
	public void changeFileContent(String text) {
		this.text += text;
	}
	
	@Override
	public FileText deleteFile() {
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileText other = (FileText) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileText [text=" + text + ", toString()=" + super.toString()
				+ "]";
	}
}
