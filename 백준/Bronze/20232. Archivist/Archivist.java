import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        
        if(a == 1995 || a == 1998 || a == 1999 || a == 2001 || a == 2002
          || a == 2003 || a == 2004 || a == 2005 || a == 2009 || a == 2010
          || a == 2011 || a == 2012 || a == 2014 || a == 2015
          || a == 2016 || a == 2017 || a == 2019) {
            System.out.println("ITMO");
        } else if(a == 1996 || a == 1997 || a == 2000 
                  || a == 2008 || a == 2007 || a == 2013 || a == 2018) {
            System.out.println("SPbSU");
        } else {
            System.out.println("PetrSU, ITMO");
        }
    }
}