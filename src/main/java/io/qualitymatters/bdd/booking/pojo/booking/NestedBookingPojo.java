package io.qualitymatters.bdd.booking.pojo.booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NestedBookingPojo {

  private Embedded _embedded;
  private Links _links;

  @JsonProperty("_embedded") 
  public Embedded get_embedded() { 
    return this._embedded; 
  }

  public void set_embedded(Embedded _embedded) { 
    this._embedded = _embedded; 
  } 

  @JsonProperty("_links") 
  public Links get_links() { 
    return this._links; 
  }

  public void set_links(Links _links) { 
    this._links = _links; 
  } 
  
}