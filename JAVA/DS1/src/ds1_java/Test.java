package ds1_java;

import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyBuffer myb=new MyBuffer(100);
		Lecteur l=new Lecteur("Lecteur", "Fichier.txt", myb);
		Processor p=new Processor(myb, "P");
		l.start();
		p.start();
		while(l.isAlive()) {}
		
		Set<Entry<String,Integer>>set=p.getWordsCounts().entrySet();
		Iterator<Entry<String,Integer>>it=set.iterator();
		while(it.hasNext()) {
			Entry<String,Integer>d=it.next();
			System.out.println(d.getKey()+" "+d.getValue());
		}
	}
}
