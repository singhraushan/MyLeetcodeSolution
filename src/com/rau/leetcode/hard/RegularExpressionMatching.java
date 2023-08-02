package com.rau.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*..c*"));//true
        /*System.out.println(isMatch("ab", ".*.."));//true
        System.out.println(isMatch("a", "a*ba"));//false
        System.out.println(isMatch("aaa", "aaaa"));//false
        System.out.println(isMatch("aaa", "a*a"));//true
        System.out.println(isMatch("ab", ".*c"));//false
        System.out.println(isMatch("mississippi", "mis*is*ip*."));//true
        System.out.println(isMatch("aa", "a"));//false
        System.out.println(isMatch("aa", "a*"));//true
        System.out.println(isMatch("ab", ".*"));//true
        System.out.println(isMatch("aab", "c*a*b"));//true
        System.out.println(isMatch("mississippi", "mis*is*p*."));//false*/
    }

    public static boolean isMatch(String s, String p) {
        int inputStrLen = s.length(), matcherLen = p.length(), matcherIndex = 0, inputIndex = 0;

        while (matcherIndex < matcherLen) {
            char mChar = p.charAt(matcherIndex);

            if (mChar == '.') {
                inputIndex++;
                matcherIndex++;
            } else if (mChar == '*') {
                char prevMatcher = p.charAt(matcherIndex-1);

                if (inputIndex == inputStrLen-1) {
                    matcherIndex++;
                }
                while (inputIndex < inputStrLen) {
                    if (prevMatcher == s.charAt(inputIndex) || prevMatcher=='.') {
                        inputIndex++;
                    }else {

                    }
                }
            } else if (inputIndex < inputStrLen) {
                char inputChar = s.charAt(inputIndex);
                if (!(mChar == inputChar)) {
                    return false;
                }
                inputIndex++;
                matcherIndex++;
            } else return false;

        }
        if (matcherIndex < matcherLen || inputIndex < inputStrLen)
            return false;
        return true;
    }

    //'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
    public static boolean isMatch2(String s, String p) {
        if (!p.contains("*") && !p.contains(".")) {
            if (!s.equals(p)) return false;
        }
        if (p.length() == 0 && s.length() > 0)
            return false;
        if (s.equals(p))
            return true;
        else {
            List<String> list = getMappedPattern(p);
            int sLen = s.length();
            int i = 0, j = 0, listSize = list.size();
            if (sLen == 0 && listSize > 0) {
                for (String str : list) {
                    if (!str.contains("*")) return false;
                }
                return true;
            }
            for (; i < sLen && j < listSize; i++) {
                String currentSStr = String.valueOf(s.charAt(i));
                String currentPStr = list.get(j);
                if (currentSStr.equals(currentPStr) || currentPStr.contains(".")) {
                    j++;
                } else if (currentPStr.contains("*")) {
                    if (currentPStr.length() == 1 || currentPStr.contains(".")) {
                        //return true;
                    } else {
                        if (currentSStr.contains(currentPStr.substring(0, 1))) {

                        } else {
                            j++;
                            for (; j < listSize; j++) {
                                currentPStr = list.get(j);
                                if (currentPStr.contains("*")) {
                                    if (currentPStr.length() == 1 || currentPStr.contains(".")) {
                                        //return true;
                                    } else if (currentSStr.contains(currentPStr.substring(0, 1))) {
                                        break;
                                    }
                                } else if (currentSStr.equals(currentPStr) || currentPStr.contains(".")) {
                                    j++;
                                    break;
                                } else return false;
                            }
                        }
                    }
                } else return false;
            }
            if (i <= sLen - 1)
                return false;
            if (j <= listSize - 1) {
                for (; j < listSize; j++) {
                    if (!list.get(j).contains("*")) {
                        if (list.get(j).contains(String.valueOf(s.charAt(sLen - 1))) && !(s.length() == 1))
                            return true;
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static List<String> getMappedPattern(String p) {
        List<String> list = new ArrayList<String>();
        int pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            String currentStr = String.valueOf(p.charAt(i));
            if (currentStr.equals("*")) {
                if (i == 0) {
                    list.add(currentStr);
                } else {
                    String lastListStr = list.get(list.size() - 1);
                    if (lastListStr.contains("*")/* || lastListStr.contains("."*)*/)
                        list.add(currentStr);
                    else
                        list.set(list.size() - 1, lastListStr + currentStr);
                }

            } else
                list.add(currentStr);
        }
        return list;
    }

}
