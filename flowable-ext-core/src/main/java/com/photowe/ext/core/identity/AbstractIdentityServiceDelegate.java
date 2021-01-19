/*
 * Copyright © 2020-2021 photowey (photowey@gmail.com)
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

package com.photowe.ext.core.identity;

import org.flowable.engine.IdentityService;
import org.flowable.idm.api.*;

import java.util.List;

/**
 * {@code AbstractIdentityServiceDelegate}
 *
 * @author photowey
 * @date 2021/01/19
 * @since 1.0.0
 */
public abstract class AbstractIdentityServiceDelegate implements IdentityService {

    public abstract IdentityService getIdentityService();

    @Override
    public User newUser(String userId) {
        return this.getIdentityService().newUser(userId);
    }

    @Override
    public void saveUser(User user) {
        this.getIdentityService().saveUser(user);
    }

    @Override
    public void updateUserPassword(User user) {
        this.getIdentityService().updateUserPassword(user);
    }

    @Override
    public UserQuery createUserQuery() {
        return this.getIdentityService().createUserQuery();
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        return this.getIdentityService().createNativeUserQuery();
    }

    @Override
    public void deleteUser(String userId) {
        this.getIdentityService().deleteUser(userId);
    }

    @Override
    public Group newGroup(String groupId) {
        return this.getIdentityService().newGroup(groupId);
    }

    @Override
    public GroupQuery createGroupQuery() {
        return this.getIdentityService().createGroupQuery();
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        return this.getIdentityService().createNativeGroupQuery();
    }

    @Override
    public List<Group> getPotentialStarterGroups(String processDefinitionId) {
        return this.getIdentityService().getPotentialStarterGroups(processDefinitionId);
    }

    @Override
    public List<User> getPotentialStarterUsers(String processDefinitionId) {
        return this.getIdentityService().getPotentialStarterUsers(processDefinitionId);
    }

    @Override
    public void saveGroup(Group group) {
        this.getIdentityService().saveGroup(group);
    }

    @Override
    public void deleteGroup(String groupId) {
        this.getIdentityService().deleteGroup(groupId);
    }

    @Override
    public void createMembership(String userId, String groupId) {
        this.getIdentityService().createMembership(userId, groupId);
    }

    @Override
    public void deleteMembership(String userId, String groupId) {
        this.getIdentityService().deleteMembership(userId, groupId);
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        return this.getIdentityService().checkPassword(userId, password);
    }

    @Override
    public void setAuthenticatedUserId(String authenticatedUserId) {
        this.getIdentityService().setAuthenticatedUserId(authenticatedUserId);
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        this.getIdentityService().setUserPicture(userId, picture);
    }

    @Override
    public Picture getUserPicture(String userId) {
        return this.getIdentityService().getUserPicture(userId);
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
        this.getIdentityService().setUserInfo(userId, key, value);
    }

    @Override
    public String getUserInfo(String userId, String key) {
        return this.getIdentityService().getUserInfo(userId, key);
    }

    @Override
    public List<String> getUserInfoKeys(String userId) {
        return this.getIdentityService().getUserInfoKeys(userId);
    }

    @Override
    public void deleteUserInfo(String userId, String key) {
        this.getIdentityService().deleteUserInfo(userId, key);
    }
}
