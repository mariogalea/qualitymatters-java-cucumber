package io.qualitymatters.bdd.booking.pojo.booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking{

    private int id;
    private String firstName;
    private String lastName;
    private Links _links;

    @JsonProperty("id") 
    public int getId() { 
		 return this.id;
    }

    public void setId(int id) { 
		 this.id = id; 
    }

    @JsonProperty("firstName") 
    public String getFirstName() { 
		 return this.firstName; 
    }

    public void setFirstName(String firstName) { 
		 this.firstName = firstName; 
    }

    @JsonProperty("lastName") 
    public String getLastName() { 
		 return this.lastName; 
    }

    public void setLastName(String lastName) { 
		 this.lastName = lastName; 
    }

    @JsonProperty("_links") 
    public Links get_links() { 
		 return this._links; 
    }

    public void set_links(Links _links) { 
		 this._links = _links; 
    } 
}
