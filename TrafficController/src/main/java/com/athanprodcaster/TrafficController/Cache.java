package com.athanprodcaster.TrafficController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.athanprodcaster.TrafficControllerRpcClient.Dtos.TsServer;


public class Cache {
	
	public static List<TsServer> tsServers = Collections.synchronizedList(new ArrayList<TsServer>());


}


