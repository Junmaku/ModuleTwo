package org.skypro.skyshop;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private HashSet<Searchable> mass;

    public SearchEngine() {
        this.mass = new HashSet<>();
    }

    public Set<Searchable> search(String str) {
        return mass.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getSearchTerm().contains(str))
                .collect(Collectors.toCollection(TreeSet::new));
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
