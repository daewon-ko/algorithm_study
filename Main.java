//import java.util.*;
//import java.io.*;
//
//public class Main{
//        class Solution {
//            public static String regex(String str, int len){
//                if(str.length() == len ) return str;
//                StringBuilder sb = new StringBuilder();
//                for(int i= 0; i<len- str.length(); i++){
//                    sb.append(0);
//                }
//                sb.append(str);
//                return sb.toString();
//            }
//            public String[] solution(int n, int[] arr1, int[] arr2) {
//
//
//                        String[] answer = new String[n];
//                        StringBuilder sb = new StringBuilder();
//
//                        String [] binaryArray1 = new String [n];
//                        String [] binaryArray2 = new String [n];
//
//                        for(int i= 0; i<n; i++){
//                            binaryArray1[i] = regex(Integer.toBinaryString(arr[i],n);
//                            binaryArray2[i] = regex(Integer.toBinaryString(arr2[i]),n);
//
//                        }
//
//                        int[][] map1 = new int [n][n];
//                        for(int i= 0; i< map1.length; i++){
//                            char [] temp = binaryArray1[i].toCharArray();
//                            for(int j=0; j< map1[i].length; j++){
//                                map1[i][j] = temp[j];
//                            }
//                        }
//                        int[][] map2 = new int [n][n];
//                        for(int i= 0; i< map2.length; i++){
//                            char [] temp = binaryArray2[i].toCharArray();
//                            for(int j=0; j< map2[i].length; j++){
//                                map2[i][j] = temp[j];
//                            }
//                        }
//                        int [][] map3 = new int[n][n];
//                        for(int i= 0; i<map1.length; i++){
//                            for(int j=0; j<map1.length; j++){
//                                if(map1[i][j] == 1 && map2[i][j] ==1){
//                                    map3[i][j] = 1;
//                                    sb.append("#");
//                                }else if(map1[i][j]==0 && map2[i][j]==0){
//                                    map3[i][j] = 0;
//                                    sb.append(" ");
//                                }
//                            }
//                            sb.append("\n");
//                        }
//
//                        StringTokenizer st = new StringTokenizer(sb.toString());
//                        for(int i= 0; i<n; i++){
//                            answer[i] = st.nextToken();
//                        }
//
//                        return answer;
//                    }
//                }
//
//
//            }
//        }
//
