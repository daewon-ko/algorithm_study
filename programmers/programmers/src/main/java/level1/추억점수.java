package programmers.programmers.src.main.java.level1;

import java.util.*;
import java.util.stream.IntStream;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] scoreList = new int[photo.length];

        Map<String, Integer> nameBindingYear = new HashMap<>();
        IntStream.range(0, name.length).forEach( i -> {
            nameBindingYear.put(name[i], yearning[i]);
        });



        for (int i = 0; i < photo.length; i++) {
            String[] peopleList = photo[i];
            for (int j = 0; j < peopleList[j].length(); j++) {
                String s = peopleList[j];
                if (nameBindingYear.containsKey(s)) {
                    scoreList[i]+=nameBindingYear.get(s);
                }

//                IntStream.range(0, name.length).filter(
//                        k -> s.equals(name[k])
//                ).forEach(k -> scoreList[k]+=yearning[k]);
            }
        }


        return scoreList;
    }




}
