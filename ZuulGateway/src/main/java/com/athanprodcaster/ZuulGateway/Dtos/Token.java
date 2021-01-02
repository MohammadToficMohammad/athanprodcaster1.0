package com.athanprodcaster.ZuulGateway.Dtos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Timestamp;
import java.util.Base64;

import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.LoginResultDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
	
	public TokenHeader header;
	public LoginResultDto payload;
	public String signature;
	
	public static String getToken( Timestamp expireTimestamp ,LoginResultDto payload,String secret ) throws Exception 
	{
		Token token =new Token();
		TokenHeader tHeader=new TokenHeader();
		tHeader.expireTimestamp=expireTimestamp;
		token.header=tHeader;
		token.payload=payload;
		token.AssignSignature(secret);
		
		ObjectMapper mapper = new ObjectMapper();
		
			try {
				String tokenjson = mapper.writeValueAsString(token);
				String encodedtokenjson = Base64.getEncoder().encodeToString(tokenjson.getBytes());
				return encodedtokenjson;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			throw new Exception("Token create failed");
		
	}
	
	public void AssignSignature(String secret) 
	{
		ObjectMapper mapper = new ObjectMapper();

		try {
			String headerjson = mapper.writeValueAsString(header);
			String payloadjson = mapper.writeValueAsString(payload);
			String tokenPre = headerjson+"."+payload+"."+secret;
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(tokenPre.getBytes());
			String stringHash = new String(messageDigest.digest());
			
			signature=stringHash;
		} catch (com.fasterxml.jackson.core.JsonProcessingException | NoSuchAlgorithmException e) {
		
			e.printStackTrace();
		}

		
	}

	
	public static String createJWT(long expireTimestampMillis, LoginResultDto payload,String secret)  {
		  
		/*
		ObjectMapper mapper = new ObjectMapper();

	    String payloadjson = mapper.writeValueAsString(payload);
		*/
		
		
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
	   // byte[] apiKeySecretBytes  =Base64.getEncoder().encode(secret.getBytes());
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    //Let's set the JWT Claims
	    //JwtBuilder builder = Jwts.builder().setId(id)
	    var payloadClaim=new HashMap<String,Object>();
	    payloadClaim.put("payload", payload);
	    JwtBuilder builder = Jwts.builder()
	            .setIssuedAt(now)
	            .setSubject("AthanProdcaster")
	           // .setPayload(payloadjson)
	            .setIssuer("AthanProdcaster")
	            .addClaims(payloadClaim).signWith(signingKey);
	           // .signWith(signatureAlgorithm, signingKey);
	  
	    //if it has been specified, let's add the expiration
	    if (expireTimestampMillis > 0) {
	        long expMillis = nowMillis + expireTimestampMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }  
	  
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	public static String createRsaJWT(long expireTimestampMillis, LoginResultDto payload,String secret)  {
		  
		
		
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
	   // byte[] apiKeySecretBytes  =Base64.getEncoder().encode(secret.getBytes());
	    //Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	
	    
	    byte [] pkcs8EncodedBytes = Base64.getDecoder().decode(secret);

        // extract the private key

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
        KeyFactory kf;
        PrivateKey privKey =null;
		try {
			kf = KeyFactory.getInstance("RSA");
		    privKey = kf.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
	    
	    
	    //Let's set the JWT Claims
	    //JwtBuilder builder = Jwts.builder().setId(id)
	    var payloadClaim=new HashMap<String,Object>();
	    payloadClaim.put("payload", payload);
	    JwtBuilder builder = Jwts.builder()
	            .setIssuedAt(now)
	            .setSubject("AthanProdcaster")
	           // .setPayload(payloadjson)
	            .setIssuer("AthanProdcaster")
	            .addClaims(payloadClaim).signWith(privKey);
	           // .signWith(signatureAlgorithm, signingKey);
	  
	    //if it has been specified, let's add the expiration
	    if (expireTimestampMillis > 0) {
	        long expMillis = nowMillis + expireTimestampMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }  
	  
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	
	public static LoginResultDto decodeRsaJWT(String jwt,String secret) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
		
		
		byte[] decoded = Base64.getDecoder().decode(secret);
		//org.bouncycastle.asn1.pkcs.RSAPublicKey pkcs1PublicKey = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(decoded);
		//BigInteger modulus = pkcs1PublicKey.getModulus();
		//BigInteger publicExponent = pkcs1PublicKey.getPublicExponent();
		//RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, publicExponent);
		KeyFactory kf;
		PublicKey generatedPublic =null;
		try {
			kf = KeyFactory.getInstance("RSA");
		    //generatedPublic = kf.generatePublic(keySpec);
		    generatedPublic = kf.generatePublic(new X509EncodedKeySpec(decoded));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( Jwts.parserBuilder().setSigningKey(generatedPublic).build().isSigned(jwt));
		

		  
	    Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(generatedPublic).build().parse(jwt).getBody();
	            
		ObjectMapper mapper = new ObjectMapper();

		LoginResultDto loginResultDto = mapper.convertValue(claims.get("payload"), LoginResultDto.class);

	    return loginResultDto;
	}
	
	
	public static LoginResultDto decodeJWT(String jwt,String secret) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
		
		 SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;



		    //We will sign our JWT with our ApiKey secret
		    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
		   // byte[] apiKeySecretBytes  =Base64.getEncoder().encode(secret.getBytes());
		    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
	    Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(signingKey).build().parse(jwt).getBody();
	            
		ObjectMapper mapper = new ObjectMapper();

		LoginResultDto loginResultDto = mapper.convertValue(claims.get("payload"), LoginResultDto.class);

	    return loginResultDto;
	}
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class TokenHeader 
{
	public Timestamp issuedTimestamp = new Timestamp(System.currentTimeMillis());
	public Timestamp expireTimestamp ;
	/*
	 * Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.HOUR, 3);
    Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
    
    *Timestamp later = new Timestamp(old.getTime() + (1000 * 60 * 60 * 3));*/
	
}