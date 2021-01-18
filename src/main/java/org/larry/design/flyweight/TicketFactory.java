package org.larry.design.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {
    private static Map<String,SearchTicket> searchTicketMap = new ConcurrentHashMap<>();

    public static SearchTicket queryTicketPrice(String from ,String to){
        String key = from+"_"+to ;
        if(searchTicketMap.containsKey(key)){
            return searchTicketMap.get(key);
        }
        SearchTicket searchTicket = new SearchTicket(from,to);
        searchTicketMap.put(key,searchTicket);
        return searchTicket ;
    }
}
