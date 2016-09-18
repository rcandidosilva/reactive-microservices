package com.meetup.location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationRestController
{
    private static final List<Location> locations = new ArrayList<Location>();

    static
    {
        locations.add(new Location(100, 1, "Bangalore"));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/locations")
    public List<Location> getLocations()
    {
        return locations;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/location/{id}")
    public Location getLocation(@PathVariable("id") Integer id)
    {
        System.out.println("**********Location:" + id);
        return locations.stream().filter(g -> g.getUserId() == id).collect(Collectors.toList()).get(0);
    }

}
