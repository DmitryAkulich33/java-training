package by.epam.composite.domain;

public class Listing implements Component{
    private String content;

    public Listing() {
    }

    public Listing(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public ComponentType getType() {
        return ComponentType.LISTING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        return content != null ? content.equals(listing.content) : listing.content == null;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getContent();
    }
}
