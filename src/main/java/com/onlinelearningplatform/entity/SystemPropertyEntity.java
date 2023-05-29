package com.onlinelearningplatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name="system_property_tb")
public class SystemPropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="prop_key")
    private String key;

    @Column(name="prop_value")
    private String value;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="description")
    private String description;

    public SystemPropertyEntity() {
    }

    public SystemPropertyEntity(long id, String key, String value, boolean enabled, String description) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.enabled = enabled;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SystemProperty{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", enabled=" + enabled +
                ", description='" + description + '\'' +
                '}';
    }
}
