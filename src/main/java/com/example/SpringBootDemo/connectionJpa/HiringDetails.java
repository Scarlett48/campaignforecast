package com.example.SpringBootDemo.connectionJpa;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class HiringDetails {
    @Id
    @Column(name = "request_id")
    private Long requestId;

    private int level;
    private int hiringCount;

    @ManyToOne
    @JoinColumn(name = "request_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Campaign campaign;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHiringCount() {
        return hiringCount;
    }

    public void setHiringCount(int hiringCount) {
        this.hiringCount = hiringCount;
    }
}
