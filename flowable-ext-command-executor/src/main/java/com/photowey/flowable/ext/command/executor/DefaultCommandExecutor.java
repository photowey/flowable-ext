package com.photowey.flowable.ext.command.executor;

import com.photowey.flowable.ext.command.cmd.Command;
import com.photowey.flowable.ext.plugin.api.context.AbstractCommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * DefaultCommandExecutor
 *
 * @author photowey
 * @date 2020/12/27
 * @since 1.0.0
 */
public class DefaultCommandExecutor<T extends AbstractCommandContext, R> implements CommandExecutor<T, R> {

    private static final Logger log = LoggerFactory.getLogger(DefaultCommandExecutor.class);

    @Override
    public R execute(Command<T, R> command, T context) {
        StopWatch sw = new StopWatch("execute-command");
        sw.start();
        if (log.isInfoEnabled()) {
            StringBuilder logInfo = new StringBuilder()
                    .append(System.lineSeparator())
                    .append("--- >>> execution command:[").append(command.getClass().getSimpleName()).append("]").append(" <<< ---")
                    .append(System.lineSeparator());
            log.info(logInfo.toString());
        }
        try {
            return command.execute(context);
        } finally {
            if (log.isInfoEnabled()) {
                sw.stop();
                StringBuilder logInfo = new StringBuilder()
                        .append(System.lineSeparator())
                        .append("--- -------------------------------------------------------------")
                        .append(System.lineSeparator())
                        .append("\texecution-command:[").append(command.getClass().getSimpleName()).append("]")
                        .append(System.lineSeparator())
                        .append("\ttime-cost:[").append(sw.getTotalTimeMillis()).append(" ms").append("]")
                        .append(System.lineSeparator())
                        .append("--- -------------------------------------------------------------");
                log.info(logInfo.toString());
            }
        }
    }
}
