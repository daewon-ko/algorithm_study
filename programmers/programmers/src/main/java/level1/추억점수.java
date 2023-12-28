package level1;

import java.util.*;
import java.util.stream.IntStream;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] scoreList = new int[photo.length];

        Map<String, Integer> nameBindingYear = new HashMap<>();
        IntStream.range(0, name.length).forEach( i -> {
            nameBindingYear.put(name[i], yearning[i]);
        });

        for (String[] peopleList : photo) {

//            IntStream.range(0, peopleList.length).filter(
//
//            );

            for (String people : peopleList) {

                if (nameBindingYear.containsKey(people)) {
//                    scoreList[] += nameBindingYear.get(people);
                }
            }
        }

        for (int i = 0; i < photo.length; i++) {
            String[] peopleList = photo[i];
            for (int j = 0; j < peopleList[j].length(); j++) {
                String s = peopleList[j];
                IntStream.range(0, name.length).filter(
                        k -> s.equals(name[k])
                ).forEach(k -> scoreList[k]+=yearning[k]);
            }
        }

//        for (String[] peopleList : photo) {
//            IntStream.range(0, photo.length).filter(
//                    i -> peopleList[i].equals()
//            )
//
//        }

//        Map<String[], Integer> photoScore = createPhotoMap(photo);
//
//        for (Map.Entry<String[], Integer> entry : photoScore.entrySet()) {
//            String[] peopleList = entry.getKey();
//            IntStream.range(0, Math.min(peopleList.length, name.length)).filter(
//                    i -> peopleList[i].equals(name[i])
//            ).forEach(i -> scoreList[i] += yearning[i]);
//        }
        return scoreList;
    }




}
