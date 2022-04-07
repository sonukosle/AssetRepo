package com.asset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Asset_track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asset_track_id")
    private int assetTrackId;
    @Column(name = "shipping_id")
    private int shippingId;
    @Column(name = "shipping_company")
    private String shippingCompany;
//    private int asset_raise_id;
    @OneToOne
    @JoinColumn(name = "asset_raised_id")
    private Asset_raise_request f_asset_raise_request;
   @Column(name = "shipping_expense")
    private double shippingExpense;
   @Column(name = "asset_track_status")
    private Boolean assetTrackStatus;

    @ManyToOne
    @JoinColumn(name = "asset_raise_request_id")
    private Asset_raise_request assetRaiseRequest;

}
