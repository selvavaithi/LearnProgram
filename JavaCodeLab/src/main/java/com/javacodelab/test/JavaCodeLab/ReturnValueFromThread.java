package com.javacodelab.test.JavaCodeLab;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ReturnValueFromThread {
	private static final int MYTHREADS = 30;
	private static long startTime,endTime,totalTime;

	public static void main(String[] args){
		System.out.println("Started ***********");
		String[] hostList = { "https://crunchify.com", "http://yahoo.com",
				"http://www.ebay.com", "http://google.com",
				"http://www.example.co", "https://paypal.com",
				"http://bing.com/", "http://techcrunch.com/",
				"http://mashable.com/", "http://thenextweb.com/",
				"http://wordpress.com/", "http://wordpress.org/",
				"http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google.co.uk/",
				"http://www.wikipedia.org/",
				"http://en.wikipedia.org/wiki/Main_Page" };
		getStartTime();
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		Future<String>  task;
		try {
		for (int i = 0; i < hostList.length; i++) {
			 
			String url = hostList[i];
			
			task=executor.submit(new MyRunnable(url));
			
				System.out.println("i: "+i+" URL: "+url + "\t\tStatus:" + task.get());
			
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
		
		getTotalTime();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Now new method is started");
		getStartTime();
		for (int i = 0; i < hostList.length; i++){
			String url = hostList[i];
			System.out.println("i: "+i+" "+new MyRunnable(url).JustRUNURL(url));
		}
		getTotalTime();
		
	}
	
	public static void getStartTime(){
		startTime = System.currentTimeMillis();
	}
	
	public static void getEndTime(){
		endTime   = System.currentTimeMillis();
	}
	
	public static void getTotalTime(){
		getEndTime();
		totalTime = (endTime - startTime)/1000; 
		System.out.println("Total time taken by this system is "+totalTime);
	}
}



class MyRunnable implements Callable<String> {
	private final String url;

	MyRunnable(String url) {
		this.url = url;
	}

	public String call() throws Exception {
		String result = JustRUNURL(url);
		
		return result;
	}

	public String JustRUNURL(String url2) {
		int code = 200;
		String myResult="";
		try {
			URL siteURL = new URL(url2);
			HttpURLConnection connection = (HttpURLConnection) siteURL
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			code = connection.getResponseCode();
			if (code == 200) {
				myResult = "Green\t";
			}
		} catch (Exception e) {
			myResult = "->Red<-\t";
		}
		return myResult;
	}
	
}
