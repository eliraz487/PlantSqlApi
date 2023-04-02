/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author manra
 */

@Table(catalog = "Plants", schema = "dbo")

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Ages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String name;



}
