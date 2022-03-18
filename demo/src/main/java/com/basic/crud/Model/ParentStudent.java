package com.basic.crud.Model;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "fullName", column = @Column(name = "parent_first_name")),
        @AttributeOverride(name = "phoneNumber", column = @Column(name = "parent_phone_number"))
})
@Data
public class ParentStudent {
    private String fullName;
    private Integer phoneNumber;
}
