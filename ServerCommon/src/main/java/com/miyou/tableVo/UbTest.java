package com.miyou.tableVo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@ToString
public class UbTest {

    @Id
    @GeneratedValue
    String id;

    @Column(name = "name", nullable = true, length = 20)
    String name;


    @JsonCreator
    public UbTest(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
