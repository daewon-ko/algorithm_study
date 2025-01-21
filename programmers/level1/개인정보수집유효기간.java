package programmers.level1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class 개인정보수집유효기간 {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> store = new ArrayList<>();

            for (String term : terms) {
                String policy = term.split(" ")[0];
                Integer validTerm = Integer.parseInt(term.split(" ")[1]);
                for (int i = 0; i < privacies.length; i++) {
                    String calender = privacies[i].split(" ")[0];
                    if (policy.equals(privacies[i].split(" ")[1])) {
                        String[] date = splitDateByDot(calender);
                        String[] todaysplitByDot = splitDateByDot(today);
                        int year = Integer.parseInt(date[0]);
                        int month = Integer.parseInt(date[1]);
                        int day = Integer.parseInt(date[2]);

                        int todayYear = Integer.parseInt(todaysplitByDot[0]);
                        int todayMonth = Integer.parseInt(todaysplitByDot[1]);
                        int todayDay = Integer.parseInt(todaysplitByDot[2]);

                        LocalDate todayDate = LocalDate.of(todayYear, todayMonth, todayDay);

                        if (validTerm+month > 12) {
                            year++;
                            month = validTerm + month -12;
                            LocalDate localDate = LocalDate.of(year, month, countDay(day));
                            isDelete(localDate, todayDate, store, i);

                        }
                        month = month + validTerm - 1;
                        LocalDate localDate = LocalDate.of(year, month, countDay(day));
                        isDelete(localDate, todayDate, store, i);

                    }


                }
            }

            int[] answer = store.stream().mapToInt(Integer::intValue).toArray();
            return answer;

        }

        private void isDelete(final LocalDate localDate, final LocalDate todayDate , List<Integer> store, int i) {
            if (localDate.isBefore(todayDate)) {
                store.add(i);
            }
        }

        private String[] splitDateByDot(final String calender) {
            return calender.split("\\.");
        }

        private int countDay(int day) {
            if (day == 1) {
                return 28;
            } else {
                day = day - 1;
                return day;
            }
        }

    }
}



