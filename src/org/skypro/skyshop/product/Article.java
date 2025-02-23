package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    @Override
    public String getSearchTerm() {
        return this.text;
    }

    public Article(String TITLE, String TEXT) {
        this.title = TITLE;
        this.text = TEXT;
    }

    @Override
    public String toString() {
        return "Название статьи:\n" + title +
                "\nТекст статьи: \n" + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }
}
