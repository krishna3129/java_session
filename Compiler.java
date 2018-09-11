import java.util.*;
class Compiler{
  public static void invoke_special(String[] s, List<String> list){
    int len= s.length;
    for(int i=1;i<len;i++){
      if(list.contains(s[i]) && !s[i-1].equals("void")){
          s[i] ="invoke_special: "+ s[i];
        //  System.out.println("Hello");
      }
    }
  }
  public static void printList(String[] s,List<String> list){
    int len= s.length;
    int active=0;
    int cnt=0;
    for(int i=0;i<len;i++){
      if(list.contains(s[i])){ cnt=0;
        //active=false;
      };
      //if(s[i].equals("{")){
        //active++;
      //}
      if(s[i].equals("}"))
        active--;
      if(s[i].equals(""));
      else {
        //if(s[i].equals("{") || s[i].equals())
        System.out.print(s[i]+" ");
    }
      if(s[i].startsWith("Function:"))
       active++;
      if(s[i].equals(";") || s[i].equals("{"))
       {
         System.out.println();
         if(active > 0)
         System.out.print(cnt+" ");
         cnt++; }
    }
  }
  public static void add_lines(String[] s){

  }
  public static void main(String[] args) {
    String str = "public static void main ( String args[] ) { "+
       "int n ; "+
       "int num = 3 ; "+
       "Object obj = new Object() ; "+
       "System.out.println(\"First 100 prime numbers are:\") ; "+
       "int sum=0 ; } "+
       "public void trial ( ) { " +
       "Pascal cre =new Pascal() ; " +
       "for ( int i=2; i<=100;  ) { "+
       "trial ( ) ; "+
          "for ( int j = 2; j <= Math.sqrt(num); j++ ) { "+
            " System.out.println(num) ; "+
          "num++ ; } "+
       "System.out.println( \"Sum of first 100 prime number is: \"+ sum ) ; ";
      // System.out.println(str.length());
       String[] s = str.split("\\s+");
       int len= s.length;
      // System.out.println(s.length);
       int in=1;
       int fl=1;
       int ob=1;
       int fn=1;
       ArrayList<String> list = new ArrayList<String>();
       for(int i=0;i<len;i++){
         if(s[i].equals("int")){
           //String a=in;
           s[i] ="i_Store";
            s[i+1]=" ";
            in++;
            //System.out.print(s[i]+" ");
            i++;
         }
         else if(s[i].equals("float")){
          // s[i] =fl + "_int";
          s[i] = "f_Store";
            s[i+1]=" ";
            fl++;
            i++;
         }
         else if(s[i].equals("new")){
           //s[i] =ob + "_Store";
           s[i] ="a_Store";
            s[i+1]="";
            s[i-3]=s[i-2]=s[i-1]="";
            ob++;
            i++;
         }
         else if(s[i].equals("=new")){
          // s[i] =ob + "_Store";
          s[i] ="a_Store";
            s[i+1]="";
            s[i-2]=s[i-1]="";
            ob++;
            i++;
         }
         else if(s[i].equals("void")){ //I'm assuming there must be Public ,private or protected keyword before void in function.
            s[i-1]="Function:";
            list.add(s[i+1]);
            fn++;
            if(s[i-2].equals("public") || s[i-2].equals("private") )
             //System.out.println(s[i-2]);
              s[i-2]="";
              //System.out.println(s[i-2]);
              i++;
         }
       }
    //   System.out.println(list);
       invoke_special(s,list);
       String out = String.join(" ", s);
      // System.out.println(out);
      printList(s,list);
  }
}
