package com.gaminghub.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author rumi.dipto
 * @since 8/21/22
 */
@Getter
@Setter
@Entity
@Table(name = "gh_order")
public class Order extends Persistent {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "game_id")
    private Game game;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    private Date returnDate;
}
