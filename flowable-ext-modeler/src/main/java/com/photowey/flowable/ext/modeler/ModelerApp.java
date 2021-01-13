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

package com.photowey.flowable.ext.modeler;

import com.photowey.flowable.ext.modeler.annotation.EnableFlowableModeler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * {@code ModelerApp}
 *
 * @author photowey
 * @date 2021/01/12
 * @since 1.0.0
 */
@EnableFlowableModeler
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ModelerApp {

    private static final Logger log = LoggerFactory.getLogger(ModelerApp.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ModelerApp.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");
        String host = InetAddress.getLocalHost().getHostAddress();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application: '{}' is running! Access URLs:\n\t" +
                        "Index: \t\t{}://{}:{}{}\n\t" +
                        "Profile(s): dev\n----------------------------------------------------------\n",
                // Application
                "Modeler",
                // Index
                "http", host, port, "/index.html"
        );
    }
}

