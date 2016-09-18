package com.meetup.recommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationRestController
{
    private static final List<Recommendation> recommendations = new ArrayList<Recommendation>();

    static
    {
        recommendations.add(new Recommendation(999, 100, "Biking", "River Rafting"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/recommendations")
    public List<Recommendation> getRecommendations()
    {
        return recommendations;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/recommendation/{id}")
    public Recommendation getRecommendation(@PathVariable("id") Integer id)
    {
        System.out.println("**********Reco:" + id);
        return recommendations.stream().filter(g -> g.getLocationId() == id).collect(Collectors.toList()).get(0);
    }
}
