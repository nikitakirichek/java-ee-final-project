package lu.uni2016.finalproject.jsf.bean.model;


import lu.uni2016.finalproject.ejb.entity.Ride;
import lu.uni2016.finalproject.ejb.facades.RideFacade;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kirichek on 12/10/16.
 */

@Named
@ViewScoped
public class SearchModel implements Serializable {
    @Inject
    private RideFacade rideFacade;

    private String startpoint;
    private String endpoint;
    private List<Ride> searchResult;

    public String getEndpoint() {
        return endpoint;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public void setSearchResult(List<Ride> searchResult) {
        this.searchResult = searchResult;
    }

    public List<Ride> getSearchResult() {
        return searchResult;
    }

    @PostConstruct
    void init(){
        this.setSearchResult(rideFacade.getAllRides());
    }
}

