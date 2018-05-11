package com.icanstudioz.bootstraper.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Res{

	@SerializedName("result")
	private int result;

	@SerializedName("message")
	private String message;

	public void setResult(int result){
		this.result = result;
	}

	public int getResult(){
		return result;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Res{" + 
			"result = '" + result + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}