package com.photowey.flowable.ext.command.context;

import java.util.Objects;

/**
 * TestCommandContext
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public class TestCommandContext extends AbstractCommandContext {

    public String requestUser;

    public String getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(String requestUser) {
        this.requestUser = requestUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestCommandContext)) return false;
        TestCommandContext that = (TestCommandContext) o;
        return Objects.equals(getRequestUser(), that.getRequestUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestUser());
    }
}
