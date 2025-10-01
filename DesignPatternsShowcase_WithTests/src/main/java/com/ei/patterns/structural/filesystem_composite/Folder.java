package com.ei.patterns.structural.filesystem_composite;
import java.util.ArrayList; import java.util.List;
public class Folder implements FSComponent {
    private final String name; private final List<FSComponent> children = new ArrayList<>();
    public Folder(String name){ this.name = name; }
    public void add(FSComponent c){ children.add(c); }
    public void remove(FSComponent c){ children.remove(c); }
    public String getName(){ return name; }
    public long size(){ long s=0; for(FSComponent c: children) s+=c.size(); return s; }
    public void print(String indent){ System.out.println(indent + "D: " + name + " ("+size()+" bytes)"); for(FSComponent c: children) c.print(indent + "  "); }
}
