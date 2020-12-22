package com.photowey.flowable.ext.common.hello;

import java.io.Serializable;

/**
 * HelloLambda
 *
 * @author photowey
 * @date 2020/12/21
 * @since 1.0.0
 */
public class Hello implements Serializable {

    private static final long serialVersionUID = 6265970703904250103L;

    private Long id;
    private String name;

    public Hello() {
    }

    public Hello(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
