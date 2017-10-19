package com.hufu.entity.u;

import com.hufu.entity.r.Question;
import com.hufu.repository.u.ResourceRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Table(name = "hufu_role")
public class Role  implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",length=10)
    private Integer id;

    //角色名称
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rid")
    Collection<Role> roles=new ArrayList<Role>();

    //所属角色
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rid")
    private Role role;

//资源权限
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "hufu_role_resource",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "resource_id"))
    Collection<Resource> resources=new ArrayList<Resource>();


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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

    public Collection<Resource> getResources() {
        return resources;
    }

    public void setResources(Collection<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource){
        this.resources.add(resource);
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
