package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    @Override
    public String getSearchTerm() {
        return this.text;
    }

    public Article(String title, String text) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле 'title' не может быть пустым.");
        }
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле 'text' не может быть пустым.");
        }
        this.title = title;
        this.text = text;
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
