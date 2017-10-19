package com.hufu.entity.u;

import com.hufu.entity.r.Record;
import com.hufu.entity.r.ViolationInfo;
import com.hufu.entity.s.Need;
import com.hufu.entity.s.Strategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "hufu_user")
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="id",length=10)
    private Integer id;
//  真实用户名
    private String name;
//    登录用户名
    private String username;

    private String password;

    private String email;
//    用户角色
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_user_role",joinColumns = @JoinColumn(name = "u_id"),inverseJoinColumns = @JoinColumn(name = "r_id"))
    Collection<Role> roles=new ArrayList<Role>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    Collection<Strategy> strategies=new ArrayList<Strategy>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    Collection<Need> needs=new ArrayList<Need>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    Collection<Record> records=new ArrayList<Record>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    Collection<ViolationInfo> violationInfos=new ArrayList<ViolationInfo>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}
