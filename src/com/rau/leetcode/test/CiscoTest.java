package com.rau.leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CiscoTest {
    public static void main(String[] args) {
       //String input = "jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.";//21
        String input = "n? O, A? ir! FhL  gmaMbo? IQtz  Nx  rkQ?  17E? Fl-TX! P (n  r   745yDs  E 4y (bPg 1Vs, KGz-jgE 92lFDOLTE. cvuXh 5IL-h 6VN. Nqz  G. KsUj (k, Hjh 4j, q-Edw 2e,  )C  v-zyt-T 0q. BVrKLW 3u, B! Cz }DGZe-mn-jcw! hT! V? ySyJ 1k. wo. V 9wI  oR!  0JD. GLKSBUB 3Eyyg )Lft  oTHbC! apSa! ujCw, Es  z )ITnWSk. nn, w 1O-xmsw  JcB. ct? lSv {HpYTM? Mc 7C (lhM.  }G {J, w [IChoXO 6dbUgKs? MLr? o 17Q! fFh [(3x. CaGQhQ  akej }p.  (g? teS. B 8qKS )n ]E-HQ,  5Mm 2qX )xiYUO! DZ! cB! G-WZ  cZc, JqpdPEpC {d, Ce, m,  8b? HH 8W 68EM, sJ-VsgDo-u 4C   5U 5mMr ]s 1tMu 8GP 7b-MW-d 6w! v 4Vu 9mBV 58vyO? uxQa [xZ! P. DA! xNr 4nl?  5n  ElH! O 4QvCf. i 30tN 8bM 6y  Yei! jsxT-a 3CEy 5KMLYdg! L 7D 1xxQViNT. rucIiius  o? r, H {1aH 0g  is 9C 3olX }P? azL-ICWgwrC! tv [FIt?  1lF (m 9zrcAfSwNjetRkc [(DSqN. yfa. uu 6BiL (L (r 0Fo 7{hJ {Py   )4JH 14oWKQdI }L )2)PZz.  5(U. BreAl 8B-pYHla! O 6rEzI?  9LDwB! aG? F-OqB (6s-cu? Zx (cZ )xv. bkdBuPZR 2Gij 2hQ 60jV 9FukJPhQc )R 9ztytQ!  ]l 6(a, S? I  b {tS,  (s, u 6)P-irIWA-vj? O, e 8";//91
       String str[] = input.split(" ");
        int count =0,count2 =0;;
        for(String temp : str){
            if(temp.matches("[a-zA-Z-,.?!]*$")){
                if(!temp.trim().isEmpty()) {
                    count++;
                }

            }
        }
        System.out.println("count: "+count+"--count2:"+count2);
    }
    public static int perfectSubstring(String s, int k) {
        int len= s.length(),res=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                 if(isPerfect(s,i,j,k)){
                     res++;
                 }

            }
        }
        return res;
    }
    public static boolean isPerfect(String sub,int start,int end, int k) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=start;i<=end;i++){
            char ch = sub.charAt(i);
            Integer v = map.get(ch);
            if(v!=null){
                map.put(ch,map.get(ch)+1);
                if(map.get(ch)>k)
                    return false;
            }else {
                map.put(ch,1);
            }
        }
        for(char ch : map.keySet()){
            if(map.get(ch)!=k)
                return false;
        }
        return true;
    }

}

