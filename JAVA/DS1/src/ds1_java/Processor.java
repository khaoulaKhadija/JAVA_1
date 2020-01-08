package ds1_java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Processor extends Thread{
	private MyBuffer buff;
	private String PName;
	private HashMap<String,Integer> wordsCounts;
	public Processor(MyBuffer buff,String PName) {
		this.buff=buff;
		this.PName=PName;
		wordsCounts=new HashMap<String, Integer>();
	}

	public void run() {
		while(true){
			try {
				this.processe();
				if(Lecteur.stp==-1) break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void processe() throws InterruptedException {
		String a=buff.getWord();
		int c=0;
		Set<Entry<String,Integer>>set=wordsCounts.entrySet();
		Iterator<Entry<String,Integer>>it=set.iterator();
		while(it.hasNext()) {
			Entry<String,Integer>d=it.next();
			if(a.equals(d.getKey())) c=d.getValue();
		}
		if(wordsCounts.containsKey(a)) {
			wordsCounts.put(a,c+1);
		}else
		wordsCounts.put(a,1);
	}
	public HashMap<String,Integer> getWordsCounts(){
		return  wordsCounts;
	}
}