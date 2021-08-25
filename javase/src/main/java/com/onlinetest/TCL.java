package com.onlinetest;

/**
 * @author Faster
 * @date 2019/9/10 10:04
 */
public class TCL {
    public static void main(String[] args) {
//        if(args==null||new TCL(){
//            {
//                this.main(null);
//            }
//        }.equals(null)){
//            System.out.println("A");
//        }else{
//            System.out.println("B");
//        }
        new TCL().exception();
    }

    public void exception(){
        try {
            int a = 1;
            while(++a>0) {
                throw new MyException();
            }
        }catch (MyException e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
    }


    /**
     * 压缩字符串
     */
    public void yasuo(){
        StringBuilder result = new StringBuilder();
        String str = "welcometoTcl";
        char []arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            result.append(arr[i]);
            int count =1;
            boolean flag = false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    break;
                }else{
                    flag = true;
                    count ++;
                }
            }
            if(flag){
                result.append(count);
            }
            i += count -1;
        }
        System.out.println(result.toString());
    }
    class MyException extends Exception {
        public MyException(){
            super();
        }
    }
}
