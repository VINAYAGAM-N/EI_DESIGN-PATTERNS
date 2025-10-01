package com.ei.patterns.structural.graphics_flyweight;
import java.util.concurrent.ConcurrentHashMap; import java.util.Map;
public class IconFactory {
    private static final Map<String, Icon> POOL = new ConcurrentHashMap<>();
    public static Icon getIcon(String id){
        return POOL.computeIfAbsent(id, k -> new Icon(k, ("ICONDATA:" + k).repeat(100)));
    }
    public static int poolSize(){ return POOL.size(); }
}
