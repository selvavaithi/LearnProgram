package com.javacodelab.test.JavaCodeLab;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 
public class MultiThreadGetPingStatusWithExecutorService {
	private static final int MYTHREADS = 30;
	
	private static long startTime,endTime,totalTime;
 
	public static void main(String args[]) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
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
		for (int i = 0; i < hostList.length; i++) {
 
			String url = hostList[i];
			Runnable worker = new MyRunnable(url);
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
		getTotalTime();
		
		System.out.println("Now new method is started");
		getStartTime();
		for (int i = 0; i < hostList.length; i++){
			String url = hostList[i];
			JustRunURL(url);
		}
		getTotalTime();
	}
 
	public static class MyRunnable implements Runnable {
		private final String url;
 
		MyRunnable(String url) {
			this.url = url;
		}
 
		public void run() {
			JustRunURL(url);
			
		}
	}
	
	public static void JustRunURL(String url){
		String result = "";
		int code = 200;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			code = connection.getResponseCode();
			if (code == 200) {
				result = "Green\t";
			}
		} catch (Exception e) {
			result = "->Red<-\t";
		}
		System.out.println(url + "\t\tStatus:" + result);
		
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