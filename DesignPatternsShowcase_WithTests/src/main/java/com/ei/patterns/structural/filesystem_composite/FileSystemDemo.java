package com.ei.patterns.structural.filesystem_composite;
public class FileSystemDemo {
    public static void main(String[] args){
        Folder root = new Folder("root");
        Folder docs = new Folder("docs"); docs.add(new FileLeaf("a.txt", 1200)); docs.add(new FileLeaf("b.pdf", 50000));
        Folder pics = new Folder("pics"); pics.add(new FileLeaf("img1.jpg", 200000)); pics.add(new FileLeaf("img2.png", 150000));
        root.add(docs); root.add(pics);
        root.print(""); System.out.println("Total size: " + root.size());
    }
}
