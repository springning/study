package com.nsp.test.multi.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;



/**
 * 多线程断点下载测试
 * @author ningsiping
 *
 */
public class MultiThreadBreakDownLoad 
{
	public static final int THREAD_COUNT = 3;
	
	public static final String DOWNLOAD_FILE_NAME = "test.exe";
	
	public static void main(String[] args) throws IOException
	{
		String path = "http://118.26.57.12:81/1Q2W3E4R5T6Y7U8I9O0P1Z2X3C4V5B/dl1sw.baidu.com/client/Baidusd_Setup_1.3.0.1055_Full.exe";
		URL url = new URL(path);
		
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setConnectTimeout(5000);
		
		int code = urlConnection.getResponseCode();
		if (200 == code) 
		{
			int length = urlConnection.getContentLength();
			System.out.println(length);
			
			RandomAccessFile randomAccessFile = new RandomAccessFile(DOWNLOAD_FILE_NAME, "rwd");
			randomAccessFile.setLength(length);
			randomAccessFile.close();
			
			CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
			
			int blockSize = length / THREAD_COUNT;
			for (int i = 0; i < THREAD_COUNT; i++)
			{
				int startIndex = i * blockSize;
				int endIndex = i == THREAD_COUNT - 1 ? length : (i + 1) * blockSize - 1;
				System.out.println("线程[" + (i + 1) + "]:startIndex = " + startIndex + ", endIndex = " + endIndex);
				
				new Thread(new PartionDownloadThread(startIndex, endIndex, path, i, countDownLatch)).start();
			}
			
			try 
			{
				countDownLatch.await();
				for (int i = 0; i < THREAD_COUNT; i++)
				{
					File file = new File(i + ".txt");
					file.delete();
				}
				
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	static class PartionDownloadThread implements Runnable
	{
		private int startIndex;
		private int endIndex;
		private String path;
		private int threadMark;
		private CountDownLatch countDownLatch;
		
		public PartionDownloadThread(int startIndex, int endIndex, String path, int threadMark,  CountDownLatch countDownLatch) 
		{
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.path = path;
			this.threadMark = threadMark;
			this.countDownLatch = countDownLatch;
		}



		public void run() 
		{
			try 
			{
				int downloadCount = 0;
				File tempFile = new File(threadMark + ".txt");
				if (tempFile.exists() && tempFile.length() > 0)
				{
					FileInputStream fileInputStream = new FileInputStream(tempFile);
					byte[] threadMarkBuffer = new byte[1024 * 4];
					int readCount = fileInputStream.read(threadMarkBuffer);
					String downloadedString = new String(threadMarkBuffer, 0, readCount);
					downloadCount = Integer.valueOf(downloadedString);
					startIndex += downloadCount;
					fileInputStream.close();
				}
				
				
				
				
				URL url = new URL(path);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.setRequestMethod("GET");
				httpURLConnection.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
				
				int code = httpURLConnection.getResponseCode();
				System.out.println("code:" + code);
				
				InputStream inputStream = httpURLConnection.getInputStream();
				RandomAccessFile randomAccessFile = new RandomAccessFile(DOWNLOAD_FILE_NAME, "rwd");
				randomAccessFile.seek(startIndex);
				
				byte[] buffer = new byte[1024 * 4];
				int count = 0;
				int total = downloadCount;
				while ((count = inputStream.read(buffer)) != -1) 
				{
					randomAccessFile.write(buffer, 0, count);
					total += count;
					System.out.println("thread:" + threadMark + "has download " + total);
					RandomAccessFile downloadCountSaveFile = new RandomAccessFile(tempFile, "rwd");
					
					downloadCountSaveFile.write((total + "").getBytes());
					downloadCountSaveFile.close();
				}
				randomAccessFile.close();
				inputStream.close();
				
				countDownLatch.countDown();
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}
