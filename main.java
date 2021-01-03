import javafx.scene.chart.PieChart;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        loan l[] = new loan[1000];
        for (int i = 0; i < 1000; i++) {
            l[i] = new loan();
        }
        int m = 0;
        int i = 4;
        int z = 0;
        Date today = new Date();
        book b[] = new book[100];
        for (int j = 0; j < 100; j++) {
            b[j] = new book();
        }
        for (int j = 0; j < i + 1; j++) {
            b[j].setState("mojoud");
        }
        String s=" ";
       while (true) {


            b[0].setName("great gatsby");
            b[0].setWriter("scott fitzgerald");
            b[0].setEditiondate(2014);
            b[0].setShabekid(13540);
            b[1].setName("the girl on the train");
            b[1].setWriter("paula hawkins");
            b[1].setEditiondate(2016);
            b[1].setShabekid(13541);
            b[2].setName("alien");
            b[2].setWriter("alber camo");
            b[2].setEditiondate(2012);
            b[2].setShabekid(13542);
            b[3].setName("blindness");
            b[3].setWriter("jose saramago");
            b[3].setEditiondate(2017);
            b[3].setShabekid(13543);
            b[4].setName("veronica decided to die");
            b[4].setWriter("paulo coelho");
            b[4].setEditiondate(2009);
            b[4].setShabekid(13544);

            System.out.println("for adding book enter book add");
            System.out.println("for  deleting book enter book delete <shabek id> ");
            System.out.println("for loaning book enter book loan <shabek id >");
            System.out.println("for returning book enter book return <shabek id>");
            System.out.println("for finding a book by name enter book search[name]");
            System.out.println("for finding a book by shabek id enter book search[shabek id]");
            System.out.println("for finding all books enter book search[all]");
            String a = input.nextLine();
            if (a.equals("book add")) {
                System.out.println("please enter book name");
                b[i + 1].setName(input.next());
                System.out.println("please enter writer name");
                b[i + 1].setWriter(input.next());
                System.out.println("please enter shabek id");
                b[i + 1].setShabekid(input.nextInt());
                System.out.println("please enter edition date");
                b[i + 1].setEditiondate(input.nextInt());
            }
            i++;
            /* peyda kardan shabek id dar reshte vared shode*/
            if (!a.equals("book add")) {
                char[] f = a.toCharArray();
                for (int j = 0; j < a.length(); j++) {
                    if (f[j] == '<') {
                        while (f[j + 1] != '>') {
                            z = z * 10 + f[j + 1] - '0';
                            j++;
                        }
                    }

                }
            }
            if (a.equals("book delete <" + z + ">")) {
                for (int j = 0; j < i + 1; j++) {
                    if (z == b[j].getShabekid()) {
                        if (j == i) {
                            /* jabejayi onsor aval o akhar zamani ke onsor mored nazar baraye hazf onsor akhar bashad*/
                            int t = b[0].getShabekid();
                            int n = b[0].getEditiondate();
                            String p = b[0].getName();
                            String q = b[0].getWriter();
                            b[0].setName(b[j].getName());
                            b[0].setWriter(b[j].getWriter());
                            b[0].setEditiondate(b[j].getEditiondate());
                            b[0].setShabekid(b[j].getShabekid());
                            b[j].setShabekid(t);
                            b[j].setEditiondate(n);
                            b[j].setName(p);
                            b[j].setWriter(q);
                            j = 0;
                        }
                        for (int k = j; k < i; k++) {
                            /*hazf onsori az araye ba ravesh shift dadan be ghabl */
                            b[k].setName(b[k + 1].getName());
                            b[k].setWriter(b[k + 1].getWriter());
                            b[k].setEditiondate(b[k + 1].getEditiondate());
                            b[k].setShabekid(b[k + 1].getShabekid());
                        }
                    }
                }

            }
            if (a.equals("book loan <" + z + ">")) {

                for (int j = 0; j < i + 1; j++) {
                    if (z == b[j].getShabekid()) {
                        /*barresi vaziat ketab mored nazar*/
                        if (b[j].getState() == "mojoud") {
                            b[j].setState("namojoud");
                            l[m].setBooknum(j);
                        } else System.out.println("this book have loaned before");
                    }
                }
                System.out.println("please enter name of loaner");
                l[m].setName(input.nextLine());
                l[m].setLoandate(today);
            }
            if (a.equals("book return <" + z + ">")) {
                for (int j = 0; j < i + 1; j++) {
                    if (z == b[j].getShabekid()) {
                        if (b[j].getState() == "namojoud")
                            b[j].setState("mojoud");
                        else System.out.println("this book didnt have loaned");
                    }
                }
            }
            if (a.equals("book search [all]")) {
                /* chap etelaat hame ketab ha*/
                for (int j = 0; j < i; j++) {
                    int min = j;
                    for (int k = j + 1; k < i + 1; k++) {
                        if (b[min].getEditiondate() > b[k].getEditiondate()) {
                            min = k;
                        }
                        System.out.println(b[min].getName());
                        System.out.println(b[min].getShabekid());
                        System.out.println(b[min].getEditiondate());
                        System.out.println(b[min].getState());
                        for (int n = 0; n < m + 1; n++) {
                            if (l[n].getBooknum() == min) {
                                System.out.println("loan date =" + l[n].getLoandate());
                                System.out.println("return date =" + l[n].getReturndate());
                                System.out.println("loaner =" + l[n].getName());
                            }
                        }

                    }


                }
            }
            if(!a.equals("book search [all]")){
                char k[]=a.toCharArray();
                /* peyda kardan shabek id dar reshte vared shode*/
                for (int j = 0; j <a.length() ; j++) {
                    if( k[j]=='['){
                        z=0;
                        while(k[j+1]-'0'>=0 && k[j+1]-'0'<=9){
                            z=z*10+k[j+1]-'0';
                            j++;
                        }
                    }
                }

           }
            if(a.equals("book search ["+z+"]")){
                for (int j = 0; j <i+1 ; j++) {
                    if(z==b[j].getShabekid()){
                        System.out.println(b[j].getName());
                        System.out.println(b[j].getState());
                        System.out.println(b[j].getWriter());
                        System.out.println(b[j].getEditiondate());
                        System.out.println(b[j].getShabekid());
                        for (int k = 0; k <m+1 ; k++) {
                            if(l[k].getBooknum()==j){
                                System.out.println("loan date =" + l[k].getLoandate());
                                System.out.println("return date =" + l[k].getReturndate());
                                System.out.println("loaner =" + l[k].getName());
                            }
                        }
                    }
                }
            }
           int cnt=0;
           if(!a.equals("book search [all]") &&  !a.equals("book search ["+z+"]")){
               /*peyda kardan name ketab dar reshte vared shode ba estefade az tabe valueof */
               char k[]=a.toCharArray();

               for (int j = 0; j <a.length() ; j++) {
                   if(k[j]=='['){
                       while (k[j+1]!=']') {
                           cnt++;
                           j++;
                       }
                   }
               }
               char n[]=new char[cnt];
               for (int j = 0; j <a.length() ; j++) {
                   if( k[j]=='['){
                      int d=0;
                       while(k[j+1]>=97 && k[j+1]<=122){

                         n[d]=k[j+1];
                         j++;
                         d++;
                       }
                       d--;
                       s=String.valueOf(n);
                   }
               }
           }
           if (a.equals("book search ["+s+"]")){
               for (int j = 0; j <i+1 ; j++) {
                   if(s.equals(b[j].getName())){
                       System.out.println(b[j].getName());
                       System.out.println(b[j].getState());
                       System.out.println(b[j].getWriter());
                       System.out.println(b[j].getEditiondate());
                       System.out.println(b[j].getShabekid());
                       for (int k = 0; k <m+1 ; k++) {
                           if(l[k].getBooknum()==j){
                               System.out.println("loan date =" + l[k].getLoandate());
                               System.out.println("return date =" + l[k].getReturndate());
                               System.out.println("loaner =" + l[k].getName());
                           }
                       }
                   }
               }
           }


        }


    }
}
