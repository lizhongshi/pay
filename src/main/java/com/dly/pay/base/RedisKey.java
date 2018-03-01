package com.dly.pay.base;

public enum RedisKey {
	PERSON_TODAY_RANKING("person_today_ranking:"),//
	PERSON_TOMONTH_RANKING("person_tomonth_ranking:");//
	private String key;
	RedisKey(String key){
		this.key=key;
	}
	  public String getKey() {
	        return key;
	    }
}
