package com.athanprodcaster.ZuulGateway;

import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SecretContainer {
	
	public static String secret= getSaltString();
	public static long expireTimestamp= System.currentTimeMillis()+(1000 * 60 * 60 * 24);
	@Scheduled(cron ="0 0 4 * * *")
	public void ChangeSecret() {
		 secret=getSaltString();
		 expireTimestamp= System.currentTimeMillis()+(1000 * 60 * 60 * 24);
	}
	
	protected static  String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
