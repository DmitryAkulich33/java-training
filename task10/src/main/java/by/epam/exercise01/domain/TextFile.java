package by.epam.exercise01.domain;

import java.util.List;

public class TextFile extends EpamFile {
    private String fileType;
    private List<String> content;

    public TextFile() {
    }

    public TextFile(String name, String path, String fileType) {
        super(name, path);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextFile textFile = (TextFile) o;

        if (fileType != textFile.fileType) return false;
        return content != null ? content.equals(textFile.content) : textFile.content == null;
    }

    @Override
    public int hashCode() {
        int result = fileType != null ? fileType.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "fileType is " + fileType;
    }
}
