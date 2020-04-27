package ru.shara.restexample.service;

import org.springframework.stereotype.Service;
import ru.shara.restexample.model.Data;
import ru.shara.restexample.model.Letters;

import javax.management.ObjectName;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public Data[] getDataArray(String dataString) {

        String analysisString = dataString.replace("[^a-z^A-Z]", "").toLowerCase().trim();
        String[] arrayString = analysisString.split("\\s");

        Data[] dataArr = new Data[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            dataArr[i] = getData(arrayString[i]);
        }
        return dataArr;
    }

    private Data getData(String word) {
        List<Letters> stats = sortedByValueDesc(letterAppears(word));
        return new Data(word, stats);
    }

    private HashMap<Character, Integer> letterAppears(String word) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }

    private List<Letters> sortedByValueDesc(HashMap<Character, Integer> letterAppears) {
        List<Letters> letters = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : letterAppears.entrySet()) {
            letters.add(new Letters(entry.getKey(), entry.getValue()));
        }

        return letters.stream().sorted(new LetterComparator().reversed()).collect(Collectors.toList());

    }

    static class LetterComparator implements Comparator<Letters> {
        @Override
        public int compare(Letters o1, Letters o2) {
            return Integer.compare(o1.getCount(), o2.getCount());
        }
    }
}
