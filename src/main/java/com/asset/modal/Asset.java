package com.asset.modal;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Asset")
@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int asset_id;
    private String asset_name;
    private int asset_quantity;
    private String asset_company;

}
