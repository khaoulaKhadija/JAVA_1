package ds1_java;


import java.util.LinkedList;


public class MyBuffer {
	
private LinkedList<String> data;
	
private int size;
	
public MyBuffer(int size) {
		
this.size = size;
		
data = new LinkedList<String>();
	}

	
public synchronized void addWord(String w) throws InterruptedException {
	
	while(data.size()==this.getsize())
		
wait();
		data.add(w);
	
	System.out.println("********** Ajouter un mot *********** "+w);
		
notify();
		
	}
	
public synchronized String getWord() throws InterruptedException {
		
while(data.size()==0)
		
wait();
		
String a=data.poll();
	
	System.out.println("********* Get le mot ***********"+a);

		notify();
		
return a;
	}
	
public  LinkedList<String> getdata(){
	
	return data;
	}
	public int getsize() {
		
return this.size;
	}

}

