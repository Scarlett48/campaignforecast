package com.example.SpringBootDemo.connectionJpa;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class HiringDetails {
    @Id
    @Column(name = "s_no")
    private Long sno;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Campaign campaign;

    @Column(name = "head_count")
    private int hiringCount;

    @Column(name = "level")
    private int level;

    public HiringDetails(Long sno, int level, int hiringCount) {
        this.sno = sno;
        this.level = level;
        this.hiringCount = hiringCount;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
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
