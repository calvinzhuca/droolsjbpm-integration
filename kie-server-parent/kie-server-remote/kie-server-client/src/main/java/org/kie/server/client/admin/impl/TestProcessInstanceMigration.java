/*
 * Copyright 2018 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.server.client.admin.impl;

import org.kie.server.api.model.admin.MigrationReportInstance;
import org.kie.server.client.impl.KieServicesClientImpl;
import org.kie.server.client.impl.KieServicesConfigurationImpl;

/**
 *
 * @author czhu
 */
public class TestProcessInstanceMigration {
    
    public static void main (String[] args){
        
        String url = System.getenv("TEST_URL");
        String username = System.getenv("TEST_USER");
        String password = System.getenv("TEST_PASSWORD");
        KieServicesConfigurationImpl config = new KieServicesConfigurationImpl(url,username,password);
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!url: " + url);
        

        ProcessAdminServicesClientImpl client = new ProcessAdminServicesClientImpl(config);
        KieServicesClientImpl kieServicesClientImpl = new KieServicesClientImpl(config);
        client.setOwner(kieServicesClientImpl);
        
        String containerId = System.getenv("TEST_CONTAINER_ID");
        Long processInstanceId = new Long(System.getenv("TEST_PROCESS_INSTANCE_ID"));
        String targetContainerId =System.getenv("TEST_TARGET_CONTAINER_ID");
        String targetProcessId = System.getenv("TEST_TARGET_PROCESS_ID");
        MigrationReportInstance report = client.migrateProcessInstance(containerId, processInstanceId, targetContainerId, targetProcessId);
        System.out.println(report.toString());
    }
    
}
