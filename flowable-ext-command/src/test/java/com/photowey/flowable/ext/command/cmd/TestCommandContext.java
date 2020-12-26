/*
 * Copyright © 2020 photowey (photowey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.photowey.flowable.ext.command.cmd;

import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;

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
