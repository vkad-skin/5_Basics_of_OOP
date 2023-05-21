package by.epam.basic_of_oop.task1.file;

import by.epam.basic_of_oop.task1.directory.Directory;

public class File {
	
	private String fileName;
	private Directory directory;
	private double fileSize;
	
	public File() {
		this.fileName = "Безимянный";
		this.directory = new Directory();
		this.fileSize = 0;
	}
	
	public File(String fileName,Directory directory,double fileSize) {
		this.fileName = fileName;
		this.directory = directory;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	
	public void renameFile(String fileName) {
		this.fileName = fileName;
	}
	
	public  File deleteFile(){
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((directory == null) ? 0 : directory.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fileSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (directory == null) {
			if (other.directory != null)
				return false;
		} else if (!directory.equals(other.directory))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (Double.doubleToLongBits(fileSize) != Double
				.doubleToLongBits(other.fileSize))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", directory="
				+ directory.toString() + ", fileSize=" + fileSize + "]";
	}
}
