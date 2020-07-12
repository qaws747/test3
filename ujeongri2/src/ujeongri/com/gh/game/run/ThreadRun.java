package ujeongri.com.gh.game.run;

import ujeongri.com.gh.game.thread.FoxThread;
import ujeongri.com.gh.game.thread.FoxThread2;

public class ThreadRun {

	public static void main(String[] args) {
		FoxThread f = new FoxThread();
		FoxThread2 f2 = new FoxThread2();
		
		Thread t1 = f;
		Thread t2 = f2;
		
		t1.start();
		t2.start();

	}

}
