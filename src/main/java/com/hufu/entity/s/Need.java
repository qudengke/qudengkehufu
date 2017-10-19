package com.hufu.entity.s;

import com.hufu.entity.u.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 需求问题
 */
@Entity
@Table(name = "hufu_need")
public class Need  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;
//需求问题
    @Column(name = "need_name")
    private String needName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNeedName() {
        return needName;
    }

    public void setNeedName(String needName) {
        this.needName = needName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
