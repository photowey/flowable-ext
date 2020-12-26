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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestCommand
 *
 * @author photowey
 * @date 2020/12/19
 * @since 1.0.0
 */
public class TestCommand extends AbstractCommandAdapter<TestCommandContext, Void> {

    private static final Logger log = LoggerFactory.getLogger(TestCommand.class);

    @Override
    protected void init(TestCommandContext context) {
        super.init(context);
    }

    @Override
    protected void preInspect(TestCommandContext context) {
        super.preInspect(context);
    }

    @Override
    protected void postInspect(TestCommandContext context) {
        super.postInspect(context);
    }

    @Override
    protected void preRule(TestCommandContext context) {
        super.preRule(context);
    }

    @Override
    protected void postRule(TestCommandContext context) {
        super.postRule(context);
    }

    @Override
    protected void preStorage(TestCommandContext context) {
        super.preStorage(context);
    }

    @Override
    protected void postStorage(TestCommandContext context) {
        super.postStorage(context);
    }

    @Override
    protected Void handleCommand() {
        return null;
    }

    @Override
    public Void execute(TestCommandContext context) {
        return super.execute(context);
    }
}
