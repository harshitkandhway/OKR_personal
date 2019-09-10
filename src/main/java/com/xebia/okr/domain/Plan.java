package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //We are using Long wrapper class instead of long datatype just to initialize
    //id with 0 instead of null in case of long

    private String title;
    private Date startOn;
    private Date endsOn;

    @OneToMany(mappedBy = "plan")
    private List<Objective> objectives;

    public Plan(String title, Date startOn, Date endsOn, List<Objective> objectives) {
        this.title = title;
        this.startOn = startOn;
        this.endsOn = endsOn;
        this.objectives = objectives;
    }

    public Plan(String title, Date startOn, Date endsOn) {
        this.title = title;
        this.startOn = startOn;
        this.endsOn = endsOn;
    }

    public Plan() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startOn=" + startOn +
                ", endsOn=" + endsOn +
                ", objectives=" + objectives +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartOn() {
        return startOn;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }

    public Date getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(Date endsOn) {
        this.endsOn = endsOn;
    }

}
