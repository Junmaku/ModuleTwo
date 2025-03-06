package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private ArrayList<Searchable> mass;

    public SearchEngine() {
        this.mass = new ArrayList<>();
    }

    public Map<String, Searchable> search(String str) {
        Map<String, Searchable> tempMap = new TreeMap<>();
        for (Searchable searchable : mass) {
            if (searchable != null && searchable.getSearchTerm().contains(str)) {
                tempMap.put(searchable.getName(), searchable);
            }
        }
        return tempMap;
    }

    public void add(Searchable o) {
        mass.add(o);
    }

    public Searchable getMostSuitableObject(String str) throws BestResultFound {
        Searchable mostSuitableObject = null;
        int count = 0;
        for (Searchable searchable : mass) {
            //Берем строку объекта Searchable из массива. Создаем счетчик вхождений.
            int tempCount = 0;
            StringBuilder s = new StringBuilder(searchable.getSearchTerm());
            int tempIndex = s.indexOf(str);
            //Через цикл считаем количество вхождений искомой строки
            while (tempIndex != -1) {
                tempCount++;
                s.delete(0, tempIndex);
                tempIndex = s.indexOf(str, tempIndex);
            }
            //Если количество вхождений больше, чем запомненное по предыдущим элементам - переприсваемся.
            if (count < tempCount) {
                mostSuitableObject = searchable;
                count = tempCount;
            }
        }
        //Если не найдено ниодного вхождения строки ни в одном элементе - выбрасываем исключение.
        if (mostSuitableObject != null) {
            return mostSuitableObject;
        } else {
            throw new BestResultFound(String.format("Строка %s не найдена", str));
        }

    }
}
