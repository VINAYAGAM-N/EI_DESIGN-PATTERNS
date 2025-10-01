package com.ei.patterns.structural.filesystem_composite;
public class FileLeaf implements FSComponent {
    private final String name; private final long bytes;
    public FileLeaf(String name,long bytes){ this.name=name; this.bytes=bytes; }
    public String getName(){ return name; } public long size(){ return bytes; }
    public void print(String indent){ System.out.println(indent + "F: " + name + " (" + bytes + " bytes)"); }
}
