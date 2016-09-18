package com.meetup.recommendation;

public class Recommendation
{
    private Integer id;

    private Integer locationId;

    private String lead;

    private String alternateLead;

    public Recommendation()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public Recommendation(Integer id, Integer locationId, String lead, String alternateLead)
    {
        super();
        this.id = id;
        this.locationId = locationId;
        this.lead = lead;
        this.alternateLead = alternateLead;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getLocationId()
    {
        return locationId;
    }

    public void setLocationId(Integer locationId)
    {
        this.locationId = locationId;
    }

    public String getLead()
    {
        return lead;
    }

    public void setLead(String lead)
    {
        this.lead = lead;
    }

    public String getAlternateLead()
    {
        return alternateLead;
    }

    public void setAlternateLead(String alternateLead)
    {
        this.alternateLead = alternateLead;
    }

}
