package com.asset.modal;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Asset_raise_request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int asset_raise_id;
//    private int asset_id;

    @OneToOne
    private Asset asset;
    private String asset_req_name;
//    private int employee_id;
    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee f_employee;
    private boolean approve_status;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "asset_raise_request")
    private List<Asset_track> asset_track;

}
