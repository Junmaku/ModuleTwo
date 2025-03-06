package org.skypro.skyshop;

public interface Searchable extends Comparable<Searchable> {

    String getSearchTerm();

    String getContentType();

    String getName();

    @Override
    default int compareTo(Searchable o) {
        return getName().compareTo(o.getName());
    }

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getContentType();
    }
}
