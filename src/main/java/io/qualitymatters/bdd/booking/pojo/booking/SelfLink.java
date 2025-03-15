package io.qualitymatters.bdd.booking.pojo.booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelfLink{

    private String href;

    @JsonProperty("href") 
    public String getHref() { 
		 return this.href; 
    }

    public void setHref(String href) { 
		 this.href = href; 
    }
     
}
