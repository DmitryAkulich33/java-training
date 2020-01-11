package by.epam.exercise01.domain;

import java.util.List;

public class Directory {
    private String name;
    private String path;
    private List<EpamFile> fileList;

    public Directory() {
    }

    public Directory(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<EpamFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<EpamFile> fileList) {
        this.fileList = fileList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Directory directory = (Directory) o;

        if (name != null ? !name.equals(directory.name) : directory.name != null) return false;
        if (path != null ? !path.equals(directory.path) : directory.path != null) return false;
        return fileList != null ? fileList.equals(directory.fileList) : directory.fileList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (fileList != null ? fileList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
