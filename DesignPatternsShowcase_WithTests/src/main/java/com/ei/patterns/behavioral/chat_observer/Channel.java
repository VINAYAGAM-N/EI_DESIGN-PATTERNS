package com.ei.patterns.behavioral.chat_observer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class Channel {
    private final String name;
    private final List<ChannelObserver> subs = new CopyOnWriteArrayList<>();
    public Channel(String name){ this.name = name; }
    public String getName(){ return name; }
    public void subscribe(ChannelObserver o){ if(!subs.contains(o)) subs.add(o); }
    public void unsubscribe(ChannelObserver o){ subs.remove(o); }
    public void post(Message m){ for(ChannelObserver o: subs) o.onMessage(m, this); }
}
