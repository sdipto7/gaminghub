package com.gaminghub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author rumi.dipto
 * @since 8/21/22
 */
@Getter
@Setter
@Entity
@Table(name = "gh_game")
public class Game extends Persistent {

    private static final long serialVersionUID = 1L;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price_daily")
    private BigDecimal priceDaily;

    @Column(name = "price_weekly")
    private BigDecimal priceWeekly;

    @Column(name = "price_monthly")
    private BigDecimal priceMonthly;
}
