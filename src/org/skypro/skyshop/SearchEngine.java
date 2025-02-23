package org.skypro.skyshop;

public class SearchEngine {
    private int size;
    private Searchable[] mass;

    public SearchEngine(int size) {
        this.size = size;
        this.mass = new Searchable[size];
    }

    public String[] search(String str) {
        int count = 0;
        int tempSize = 5;
        String[] temp = new String[tempSize];
        for (int i = 0; i < this.mass.length; i++) {
            if (count < tempSize && mass[i] != null && mass[i].getSearchTerm().contains(str)) {
                temp[count++] = mass[i].getSearchTerm();
            }
        }
        return temp;
    }

    public void add(Searchable o) {
        for (int i = 0; i < this.size; i++) {
            if (mass[i] == null) {
                mass[i] = o;
                break;
            }
        }

    }
}
