package com.onlinelearningplatform.entity;


import com.onlinelearningplatform.utility.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="user_tb")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username",unique = true,nullable = false)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email",unique = true,nullable = false)
    private String email;

    @Column(name="last_loggin")
    private Date lastLoggin;

    @Column(name="role")
    private Role role;

    @Column(name="active_status")
    private String activeStatus;

    @Column(name="creation_date")
    private Date createDate;


    public UserEntity() {
    }

    public UserEntity(long id, String username, String password, String email, Date lastLoggin, Role role,String activeStatus,Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastLoggin = lastLoggin;
        this.role = role;
        this.activeStatus = activeStatus;
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

    public Date getLastLoggin() {
        return lastLoggin;
    }

    public void setLastLoggin(Date lastLoggin) {
        this.lastLoggin = lastLoggin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getActiveStatus().equals("YES");
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getActiveStatus().equals("YES");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.getActiveStatus().equals("YES");
    }

    @Override
    public boolean isEnabled() {
        return this.activeStatus.equals("YES");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastLoggin=" + lastLoggin +
                ", role=" + role +
                ", activeStatus="+activeStatus+
                ", creationDate="+createDate+
                '}';
    }
}
