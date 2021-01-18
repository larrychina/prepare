package org.larry.design.flyweight;

public class Test {

    public static void main(String[] args) {
        /*SearchTicket searchTicket = TicketFactory.queryTicketPrice("北京", "上海");
        searchTicket.showPrice();

        SearchTicket searchTicket1 = TicketFactory.queryTicketPrice("北京", "广州");
        searchTicket1.showPrice();


        SearchTicket searchTicket2 = TicketFactory.queryTicketPrice("北京", "深圳");
        searchTicket2.showPrice();

        SearchTicket searchTicket3 = TicketFactory.queryTicketPrice("北京", "上海");
        searchTicket3.showPrice();*/

        String s1 = "hello" ;
        String s2 = "hello" ;
        String s3 = "hel" + "lo" ;
        String s4 = "hel" + new String("lo") ;

        System.out.print("s1 == s2 :");
        System.out.println(s1 == s2);

        System.out.print("s1 == s3 :");
        System.out.println(s1 == s3);

        System.out.print("s1 == s4 :" );
        System.out.println(s1 == s4);

        String s5 = new String("hello") ;
        System.out.print("s1 == s5 :" );
        System.out.println(s1 == s5);



        String s6 = s5.intern() ;
        System.out.print("s1 == s6 :" );
        System.out.println(s1 == s6);

        String s7 = "h" ;
        String s8 = "ello" ;
        String s9 = s7 + s8 ;
        System.out.print("s1 == s9 :" );
        System.out.println(s1 == s9);

        System.out.print("s4 == s5 :" );
        System.out.println(s4 == s5);

    }
}
