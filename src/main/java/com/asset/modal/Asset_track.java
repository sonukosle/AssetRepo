package com.asset.modal;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Asset_track {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int asset_track_id;
    private int shipping_id;
    private String shipping_company;
//    private int asset_raise_id;
    @OneToOne
    @JoinColumn(name = "asset_raised_id")
    private Asset_raise_request f_asset_raise_request;
    private double shipping_expense;
    private Boolean asset_track_status;

    @ManyToOne
    private Asset_raise_request asset_raise_request;

}
