package com.icanstudioz.bootstraper.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class User{

	@SerializedName("result")
	private int result;

	@SerializedName("SKey")
	private String sKey;

	@SerializedName("message")
	private String message;

	@SerializedName("userClientID")
	private int userClientID;

	public void setResult(int result){
		this.result = result;
	}

	public int getResult(){
		return result;
	}

	public void setSKey(String sKey){
		this.sKey = sKey;
	}

	public String getSKey(){
		return sKey;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUserClientID(int userClientID){
		this.userClientID = userClientID;
	}

	public int getUserClientID(){
		return userClientID;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"result = '" + result + '\'' + 
			",sKey = '" + sKey + '\'' + 
			",message = '" + message + '\'' + 
			",userClientID = '" + userClientID + '\'' + 
			"}";
		}
}