//package boj.구현;
//
//import java.io.BufferedReader;
//
//public class boj18808Ref {
//    static int n, m, k;
//    static int[][] notebook;
//
//    public static void main(String[] args) {
//        BufferedReader br =
//    }
//
//    public static void attachSticker(int[][] sticker) {
//        for (int r = 0; r < 4; r++) {
//            for (int y = 0; y <=n-sticker.length; y++) {
//                for (int x = 0; x <=m-sticker[0].length; x++) {
//                    if (canAttach(y, x, sticker)) {
//                        placeSticker(y, x, sticker);
//                        return;
//                    }
//                }
//            }
//            sticker = rotateSticker(sticker);
//        }
//    }
//
//    public static boolean canAttach(int y, int x, int[][] sticker) {
//        for (int i = 0; i < sticker.length; i++) {
//            for (int j = 0; j < sticker[0].length; j++) {
//                if (sticker[i][j] == 1 && notebook[y + i][x + j] == 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void placeSticker(int y, int x, int[][] sticker) {
//        for (int i = 0; i < sticker.length; i++) {
//            for (int j = 0; j < sticker[0].length; j++) {
//                if (sticker[i][j] == 1) {
//                    notebook[y + i][x + j] = 1;
//                }
//            }
//        }
//    }
//
//    public static int[][] rotateSticker(int[][] sticker) {
//        int[][] newSticker = new int[sticker[0].length][sticker.length];
//
//        for (int i = 0; i < sticker.length; i++) {
//            for (int j = 0; j < sticker[0].length; j++) {
//                newSticker[j][sticker.length - 1 - i] = sticker[i][j];
//            }
//        }
//
//        return newSticker;
//    }
//}
