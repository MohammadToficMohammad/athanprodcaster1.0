package com.athanprodcaster.ZuulGateway;

import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SecretContainer {
	//for jwt debugger add this -----END PUBLIC KEY----- 
	public static String rsaPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugVQkLggzy8IeKXD6xIpRkzfn1w5e1rjw+5+6RoT1WQBvs1455lsp4rfKcJzF2fwQ23darDrvgSS3hnI4EVK/RBu2KWEo1ghS5Qzu/pLV1lY/doi0Wy3U9VZ8JH6pWVqWpsKzsYY8cRXo0ld82JUP64AmIj+5Z/O4eZCIE+hILQ3P80HTlqdIYGBmt79mUiCqhs1f6aRvh9XagydjQWJ7QHYwfDO6v6qwGwBgDiS68IJldFzt2BjkItP9GFIbC7BWvSpOe0ttSGZmB61CnTnGYf9A0a1kk72BoY37lnprrVZ+1Bgd/etxqo9NWBMAnqT7Yop6TEnbVWC+Rhl2edGWQIDAQAB";
	public static String rsaPrivateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC6BVCQuCDPLwh4pcPrEilGTN+fXDl7WuPD7n7pGhPVZAG+zXjnmWynit8pwnMXZ/BDbd1qsOu+BJLeGcjgRUr9EG7YpYSjWCFLlDO7+ktXWVj92iLRbLdT1VnwkfqlZWpamwrOxhjxxFejSV3zYlQ/rgCYiP7ln87h5kIgT6EgtDc/zQdOWp0hgYGa3v2ZSIKqGzV/ppG+H1dqDJ2NBYntAdjB8M7q/qrAbAGAOJLrwgmV0XO3YGOQi0/0YUhsLsFa9Kk57S21IZmYHrUKdOcZh/0DRrWSTvYGhjfuWemutVn7UGB3963Gqj01YEwCepPtiinpMSdtVYL5GGXZ50ZZAgMBAAECggEBAIYuGTwapQftjDXClHy2v/EGuHNyCcCSAiMtoHuyJMZS+fNQsTqV78s2n9y2d2BVx/hLgmBYN+P71pjAjqY/NWUvelVppzBP/MxQnbSlSb07JLcPpvfbbK3bAqJGGj891SaAGZ6nRAz4rKKK5GsP7Wd1stZUU1D9IjTOa7p01ewI99Mf17XwJIaoLI/Tp6YDmajHe5VtLry6PqT3pfgO2txPNCsJPv2OHVYwA0I3AcmVK0KFRa+TX+7TCcPAehK3cNiOBZOsQJUo9vNPX19yJt5FO07t504XU64sr8iHzgQhJCDj8dv3KrE9osBieJGT2/Latg2O0tjm5qRqoOxMi5ECgYEA2mAym7zSJ9HRqm5amPQYP2YD7PUUIbFe1OBNDZqoSoUtW3gNBzmlf4BM1Ku69cX71VTUXvx3J7CvHp/q7tnSzv7fyySriZjgO9hXF4sjDNjVxF2xiMA0AEJkd+GjGXJgJDaVaRh7x24T9Fz6OuJTun/eC4I2yQpdQh71XwuOKaUCgYEA2hIMjLYt9bMWWhs2xFNViHHvwpkzPYUG70AJ0AMPjHLs/cWiPkjf757Rc5i93JGovXK3BBmzenQE2RUcuKiq6m/i3IZqo6oBMZR813xl5KBR5/UJHzemjYX2KuulEHkTdfkFRY9yl7fj3Ao3/61T5DIYLsFSsN/vkGxvwUBrg6UCfx+Px8C6iaU3rhXz3SQ+I0MGe4rD4ST9fbdGs9xDfg9HMEcIEtn4evLymCgkqeDbvIoYuJkB5DbYUncapdnfoZhJPg8ePayla8M6gVvlwCsbK8o1wHMDVIC1F9A7zFbhMQQK341Q/JLWVgv7ZC8ehvttf6oqJ8DmvpPP5abXBLUCgYEAuFmnyFC+m8Yw8C2vZ9r3JOkFAmKW4bwSt7FQWkwsGdSSKpqn5LWgsiZ19J48azmsB7PxqgK8Kpnn+0iQxj64doXtp/XuMrumVK6tt1FPpi4t78TDWGOoZl3IVFJvcXSZkhLZdQummUH42+y7mGaD1BbRQL1n1WUKVfKFqz51ZY0CgYEA1XVpqEIy5f2+zC9d7oYv6Ib2CaLFn6dBvD1fhUsU6KJmhbi+EhlDafvfZXXInwcPOiVpPzg0lovqFn74AfcxGbJ1cgOM36TgvUI3Fu0eFpmL2iscEAcsID3IWrkidnfJzGv6fZX1C6kqGD3i5EnmN3E3hw0/NODaifhvFn/qizI=";
			
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
        while (salt.length() < 64) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
