package com.example.SpringBootDemo.connectionJpa;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Long requestId;
    private String campaignName;
    private String leaderName;

    @OneToMany(mappedBy = "campaign")
    private Set<HiringDetails> details;

    protected Campaign(){}

    public Campaign(String campaignName, String leaderName) {
        this.campaignName = campaignName;
        this.leaderName = leaderName;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "requestId=" + requestId +
                ", campaignName='" + campaignName + '\'' +
                ", leaderName='" + leaderName + '\'' +
                '}';
    }

    public Long getRequestId() {
        return requestId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public String getLeaderName() {
        return leaderName;
    }
}
