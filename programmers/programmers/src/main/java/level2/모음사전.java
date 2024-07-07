package level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 브루트 포스?, 재귀?>
 * 어떤 식으로 문제를 구성해야하지>?
 *
 * 재귀를 한다고 하면 BaseCondition?
 * 재귀로 푼다고 하면 어떻게 word=A라고 하면 return 1;
 * f(k)를 구할 수 있을때 => f(k+1)을 보이면 재귀적으로 만족한다.
 * f(Map, word,size())
 * Map -> Key : Integer(자리수), Value :
 */
public class 모음사전 {

    List<String> list;
    String[] words = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        list = new ArrayList<>();

        recursive("");

        return list.indexOf(word);

    }
    public void recursive(String word){
        list.add(word);
        if (word.length() == 5) {
            return;
        }

        for (String w : words) {
            recursive(word + w);
        }
    }

}
