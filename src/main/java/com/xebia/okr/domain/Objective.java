package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "objective")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn
    private Plan plan;

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }

    @OneToMany(mappedBy = "objective")
    private List<KeyResult> keyResults;

    //constructors
    Objective() {
    }
    public Objective(String title) {
        this.title = title;
    }
    public Objective(String title, Plan plan_id) {
        this.title = title;
        this.plan = plan_id;
    }





    //getter and setter methods
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
