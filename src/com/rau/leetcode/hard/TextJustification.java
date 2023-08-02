package com.rau.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {

    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len = words.length,count=0,start=0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<len;i++){
            count = count + words[i].length()+1;
            if(count+words[i].length()<=maxWidth){

                if(count+words[i+1].length()+1 > maxWidth) {//then construct here and add in res and make count=0
                    int diff = maxWidth-count,gap = i-start;
                    int extraSpace = diff/gap;
                    String str = getSpace(extraSpace+1);

                    if(diff%gap==0) {//equal gap
                        while (start<i){
                              sb.append(words[start]).append(str);
                              start++;
                        }
                    }else {//not equal
                        while (start< i-1){
                            sb.append(words[start]).append(str);
                            start++;
                        }
                        sb.append(words[start++]).append(getSpace(diff%gap+1));
                    }

                    sb.append(words[start]);
                    res.add(sb.toString());

                    count=0;
                    start=i;
                    sb.delete(0,sb.length());
                }else {

                }
            }else {
                //add to res and count =0;

                res.add(sb.toString());
                count=0;
                sb.delete(0,sb.length());
            }
        }


        return res;
    }
    final private static String SPACE=" ";
    private static String getSpace(int size) {
        StringBuilder sb = new StringBuilder();
        while (size-->0) sb.append(SPACE);
        return sb.toString();
    }
}
