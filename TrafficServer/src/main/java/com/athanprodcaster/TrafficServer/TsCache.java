package com.athanprodcaster.TrafficServer;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TsCache {
	
	// sync but concurrent
	//public static List<Object> objList = Collections.synchronizedList(new ArrayList<Object>());
	
	public static Queue<TsMosque> mosques = new ConcurrentLinkedQueue<TsMosque>();
	
	public static ConcurrentHashMap<String,TsMosque> mosquesMap=new ConcurrentHashMap<String,TsMosque>();

}


