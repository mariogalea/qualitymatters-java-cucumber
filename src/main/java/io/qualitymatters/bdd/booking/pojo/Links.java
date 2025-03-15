package io.qualitymatters.bdd.booking.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

    private SelfLink selfLink;
    private BookingsLink bookingsLink;

    @JsonProperty("selfLink") 
    public SelfLink getSelfLink() { 
		return this.selfLink; 
    }

    public void setSelfLink(SelfLink selfLink) { 
		this.selfLink = selfLink; 
    }

    @JsonProperty("bookingsLink") 
    public BookingsLink getBookingsLink() { 
	    return this.bookingsLink; 
    } 

    public void setBookingsLink(BookingsLink bookingsLink) { 
	    this.bookingsLink = bookingsLink; 
    } 

}