package com.asset.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Asset_raise_request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "asset_raise_id")
    private int assetRaiseId;
//    private int asset_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;
    @Column(name = "asset_req_name")
    private String assetReqName;
//    private int employee_id;
    @OneToOne
    @JoinColumn(name = "emp_id",insertable = false, updatable = false)
    private Employee fEmployee;
    @Column(name = "approve_status")
    private boolean approveStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @OneToMany(mappedBy = "assetRaiseRequest",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Asset_track> assetTrack;

}
