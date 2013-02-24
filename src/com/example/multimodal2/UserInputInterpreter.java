package com.example.multimodal2;

import java.util.Locale;

import multimodal.FuzzyTime;
import android.annotation.SuppressLint;
import android.util.Log;

@SuppressLint("DefaultLocale")
public class UserInputInterpreter {
	public class UserInput{
	   // public CommandType commandType;
	    public String time;
	    FuzzyTime exactTime;	    
	}


	
	
	public static FuzzyTime interpreteTime(String time) {
		time = time.toLowerCase(Locale.getDefault());
		if(time.contains("yesterday")){
			return FuzzyTime.nowPlusSeconds(-24*60*60);
		} else if(time.contains("day after tomorrow")){
			return FuzzyTime.nowPlusSeconds(48*60*60);
		} else if(time.contains("tomorrow")){
			return FuzzyTime.nowPlusSeconds(24*60*60);
		} else if(time.equals("next")){
			return FuzzyTime.now();
		} else {
			return null;
			//throw new UserInputNotUnderstoodException("Time: "+time);
		}
	}
	@SuppressLint("DefaultLocale")
	public static void userSaid(String text) {

		text = text.toLowerCase();
		FuzzyTime userTime;
		userTime = interpreteTime(text);
		UserAction returnObject;
		if(text.contains("when")) {
			//returnObject = UserAction(userTime );
			UserInputInterpreter.userSaidWhen();
		} else if(text.matches("where")) {
			UserInputInterpreter.userSaidWhere();
		} else if(text.matches("show")) {
			UserInputInterpreter.userSaidShow();
		} else if(text.matches("move")) {
			UserInputInterpreter.userSaidMove();
		} else if(text.matches("cancel")) {
			UserInputInterpreter.userSaidCancel();
		}		
	}
	
	class UserInputNotUnderstoodException extends Exception{
		UserInputNotUnderstoodException(String msg){
			super(msg);
		}
	}
	public static void userSaidCancel() {
		Log.d("SpeechRepeatActivity", "matched cancel!");
	}

	public static void userSaidMove() {
		Log.d("SpeechRepeatActivity", "matched move!");	
	}

	public static void userSaidShow() {
		Log.d("SpeechRepeatActivity", "matched show!");
	}

	public static void userSaidWhere() {
		
		Log.d("SpeechRepeatActivity", "matched where!");
	}

	public static void userSaidWhen() {
		Log.d("SpeechRepeatActivity", "matched when!");
	}
	
}
