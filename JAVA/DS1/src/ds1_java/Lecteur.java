package ds1_java;

import java.io.*;


public class Lecteur extends Thread {
	
private String fileName;
	
private String threadName;
	
private MyBuffer buff;
	
BufferedInputStream bfi;
	
public static int stp = 0;

	
public Lecteur(String threadName, String fileName, MyBuffer buff) throws FileNotFoundException {
		
this.threadName = threadName;
		
this.fileName = fileName;
		
this.buff = buff;
		
bfi = new BufferedInputStream(new FileInputStream(new File(this.fileName)));
	}

	
public String readWord() throws IOException {
		
byte[] b = new byte[1];
		int n = 0;
		
String word ="";
		
while ((n = this.bfi.read(b)) >= 0 && Character.toString((char) b[0]).matches("\\w")&&((char) b[0])!='\n') {
			
word += (char) b[0];
		}
		stp = n;
		return word;
	}

	public void run() {
	
	while (true) {
			try {
				String s=readWord();
				if(s!="")
		
		buff.addWord(s);
				if(stp==-1) break;
			} catch (IOException e) {
			
	// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
	
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

