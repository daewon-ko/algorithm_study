package level1;

public class 삼총사 {
        public int solution(int[] number) {
            int answer = 0;

            for(int i=0; i<number.length-2; i++){
                int chosen1 =number[i];

                for(int j=i+1; j<number.length-1; j++){
                    int chosen2 =number[j];
                    for(int k=j+1; k<number.length; k++){
                        int chosen3 = number[k];

                        // i,j,k가 같은 수이면 안된다. 즉 모두 다르수여야 한다.

                        // (i!=j) &&(j!=k) &&(k!=i)

                        if(chosen1+chosen2+chosen3==0){
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }
