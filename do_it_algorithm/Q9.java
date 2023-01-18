package do_it_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9 {
    static int p, s, ans;
    static int a, c, g, t;
    static char[] dna;
    static int[] cnt = new int[20];

    public static void main(String[] args) throws IOException {


                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                s = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                dna = br.readLine().toCharArray();

                st= new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                g = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());

                slidingWindow();
                System.out.println(ans);
            }

// A B C D E F G H I J K  L  M  N  O  P  Q  R  S  T
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
            static void slidingWindow(){
                for(int i=0; i<p; i++){
                    System.out.println(dna[i]-'A');
                    cnt[dna[i]-'A']++;
                }

                check();

                for(int i=p; i<s; i++){
                    cnt[dna[i-p]-'A']--;
                    cnt[dna[i]-'A']++;
                    check();
                }
            }

            static void check(){
                if(cnt[0] >= a && cnt[2] >=c && cnt[6]>=g && cnt[19] >= t){
                    ans++;
                }
            }
        }



