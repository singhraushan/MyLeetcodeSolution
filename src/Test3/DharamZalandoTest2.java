package Test3;

import java.util.concurrent.atomic.AtomicBoolean;

public class DharamZalandoTest2 {
    public static void main(String[] args) {
        System.out.println("res:"+new DharamZalandoTest2().solution("CBACD"));//C
        System.out.println("res:"+new DharamZalandoTest2().solution("CABABD"));//""
        System.out.println("res:"+new DharamZalandoTest2().solution("ACBDACBD"));//ACBDACBD
    }
    private AtomicBoolean isABNotDone=new AtomicBoolean(true), isBANotDone=new AtomicBoolean(true);
    private AtomicBoolean isCDNotDone=new AtomicBoolean(true), isDCNotDone=new AtomicBoolean(true);

    public String solution(String S) {
       while (isABNotDone.get() && isBANotDone.get() && isCDNotDone.get() && isDCNotDone.get()){
           S = replaceAll(S,"AB",isABNotDone);
           S = replaceAll(S,"BA",isBANotDone);
           S = replaceAll(S,"CD",isCDNotDone);
           S = replaceAll(S,"DC",isDCNotDone);
       }
       return S;
    }
    private String replaceAll(String S,String regex, AtomicBoolean flag){
        String temp = S.replaceAll(regex,"");
        if(temp!=S){
            S = temp;
        }else flag.set(false);
        return S;
    }
}
