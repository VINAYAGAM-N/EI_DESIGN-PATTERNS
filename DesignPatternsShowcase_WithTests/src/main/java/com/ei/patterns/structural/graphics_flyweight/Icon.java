package com.ei.patterns.structural.graphics_flyweight;
public class Icon {
    private final String id; private final String data;
    public Icon(String id, String data){ this.id=id; this.data=data; }
    public String getId(){ return id; }
    @Override public String toString(){ return "Icon["+id+"] size="+ (data==null?0:data.length()); }
}
