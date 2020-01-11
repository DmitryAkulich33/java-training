package by.epam.exercise01.domain;

public abstract class EpamFile {
    private String name;
    private String path;

    public EpamFile() {
    }

    public EpamFile(String name, String path) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EpamFile file = (EpamFile) o;

        if (name != null ? !name.equals(file.name) : file.name != null) return false;
        return path != null ? path.equals(file.path) : file.path == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EpamFile{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
