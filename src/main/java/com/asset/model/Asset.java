package com.asset.model;
import lombok.*;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "asset_id")
    private int assetId;
    @Column(name = "asset_name")
    private String assetName;
    @Column(name = "asset_quantity")
    private int assetQuantity;
    @OneToOne
    private Employee employee;

    @Column(name = "asset_company")
    private String assetCompany;

}
