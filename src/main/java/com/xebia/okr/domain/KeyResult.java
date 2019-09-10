package com.xebia.okr.domain;

import javax.persistence.*;

@Entity
@Table(name = "key_result")
public class KeyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Objective objective;

    private String title;
    private KeyResultStatus status = KeyResultStatus.NOT_STARTED;
    private int confidenceScore=0;
    private int percentageFinished=0;

    KeyResult() {
    }

    public KeyResult(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public KeyResultStatus getStatus() {
        return status;
    }

    public void setStatus(KeyResultStatus status) {
        this.status = status;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(int confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public int getPercentageFinished() {
        return percentageFinished;
    }

    public void setPercentageFinished(int percentageFinished) {
        this.percentageFinished = percentageFinished;
    }
}


