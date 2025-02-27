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

    public Searchable getMostSuitableObject(String str) throws BestResultFound {
        int mostSuitableIndex = -1;
        int count = 0;
        for (int i = 0; i < mass.length; i++) {
            //Пустые элементы пролистываем.
            if (mass[i] == null) {
                continue;
            }

            //Берем строку объекта Searchable из массива. Создаем счетчик вхождений.
            int tempCount = 0;
            StringBuilder s = new StringBuilder(mass[i].getSearchTerm());
            int tempIndex = s.indexOf(str);
            //Через цикл считаем количество вхождений искомой строки
            while (tempIndex != -1) {
                tempCount++;
                s.delete(0, tempIndex);
                tempIndex = s.indexOf(str, tempIndex);
            }
            //Если количество вхождений больше, чем запомненное по предыдущим элементам - переприсваемся.
            if (count < tempCount) {
                mostSuitableIndex = i;
                count = tempCount;
            }
        }
        //Если не найдено ниодного вхождения строки ни в одном элементе - выбрасываем исключение.
        if (mostSuitableIndex != -1) {
            return mass[mostSuitableIndex];
        } else {
            throw new BestResultFound(String.format("Строка %s не найдена", str));
        }

    }
}
