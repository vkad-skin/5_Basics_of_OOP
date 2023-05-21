package by.epam.basic_of_oop.task1.directory;



public class Directory {

	private String directoryName;
	private String directoryPath; // Path-путь

	public Directory() {
		directoryName = "D";
		directoryPath = "D//:";
	}

	public Directory(String directoryName, String directoryPath) {
		this.directoryName = directoryName;
		this.directoryPath = directoryPath;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((directoryName == null) ? 0 : directoryName.hashCode());
		result = prime * result
				+ ((directoryPath == null) ? 0 : directoryPath.hashCode());
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
		Directory other = (Directory) obj;
		if (directoryName == null) {
			if (other.directoryName != null)
				return false;
		} else if (!directoryName.equals(other.directoryName))
			return false;
		if (directoryPath == null) {
			if (other.directoryPath != null)
				return false;
		} else if (!directoryPath.equals(other.directoryPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Directory [directoryName=" + directoryName + ", directoryPath="
				+ directoryPath + "]";
	}

}
