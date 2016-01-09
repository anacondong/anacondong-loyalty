package com.loyalty.unity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class Logger {

	private static org.apache.log4j.Logger logger;
	
	private static FileWriter writer;
	private static List<String> logList = new ArrayList<String>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat logSdf = new SimpleDateFormat("yyyyMMdd", new Locale("th", "TH"));
	private static String currentLogFileName;
	
	private static boolean batchEnable = false;
	
	private static String logFileName;
	private static String logPath;
	
	public static void setLogFileName(String logFileName) {
		Logger.logFileName = logFileName;
	}

	public static void setLogPath(String logPath) {
		Logger.logPath = logPath;
	}
	
	public Logger() {
		
	}
	
	public Logger(Class<?> clazz){
		
		logger = org.apache.log4j.Logger.getLogger(clazz);
	}
	
	public static Logger getLogger(Class<?> clazz){
		
		return new Logger(clazz);
	}
	
	public static void enableBatchLogger() throws IOException{
		
		if(batchEnable){
			
			logger.debug("Logger for batch file is already enabled. Disabling it ...");
			
			disableBatchLogger();
		}
		
		// log path
		File path = new File(logPath);
		if(!path.exists()){
			
			path.mkdirs();
		}
		
		// log name
		if(StringUtils.isBlank(logFileName)){
			
			throw new IllegalArgumentException("Invalid log file name for batch logger. [name : "+logFileName+"]");
		}
		
		// fileWriter
		if(writer != null){
			
			try {
				
				flush();
				writer.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			writer = null;
		}
		
		currentLogFileName = logFileName+"_"+logSdf.format(new Date())+".log";
		writer = new FileWriter(new File(logPath+File.separator+currentLogFileName));
		
		batchEnable = true;
	}
	
	public static void disableBatchLogger(){
		
		if(!batchEnable){
			
			logger.debug("Logger for batch file is already disabled.");
			
			return;
		}
		
		// fileWriter
		if(writer != null){
			
			try {
				
				flush();
				writer.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			writer = null;
		}
		
		batchEnable = false;
	}
	
	public static void flush(){
		
		if(writer != null){
			
			try {
				
				synchronized (logList) {
				
					while(!logList.isEmpty()){
						
						writer.write(logList.remove(0)+System.getProperty("line.separator"));
					}
				}
			
				writer.flush();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public void debug(Object message) {
		
		logger.debug(message);
		
		if(batchEnable && logger.isDebugEnabled()) logList.add(sdf.format(new Date())+"[DEBUG] "+message.toString());
	}
	
	public void info(Object message) {
		
		logger.info(message);
		
		if(batchEnable && logger.isInfoEnabled()) logList.add(sdf.format(new Date())+"[INFO] "+message.toString());
	}
	
	public void warn(Object message) {
		
		logger.warn(message);
		
		if(batchEnable) logList.add(sdf.format(new Date())+"[WARN] "+message.toString());
	}
	
	public void error(Object message) {
		
		logger.error(message);
		
		if(batchEnable) logList.add(sdf.format(new Date())+"[ERROR] "+message.toString());
	}
	
	public boolean isDebugEnabled(){
		
		return logger.isDebugEnabled();
	}
	
	public static String getCurrentLogFilePath(){
		
		return logPath;
	}
	
	public static String getCurrentLogFileName(){
		
		return currentLogFileName;
	}
}
