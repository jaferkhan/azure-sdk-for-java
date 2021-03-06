/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.notificationhubs.v2016_03_01.implementation;

import com.microsoft.azure.management.notificationhubs.v2016_03_01.NotificationHubNamespaceSharedAccessAuthorizationRuleResource;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.notificationhubs.v2016_03_01.SharedAccessAuthorizationRuleCreateOrUpdateParameters;
import java.util.Map;
import java.util.List;
import com.microsoft.azure.management.notificationhubs.v2016_03_01.AccessRights;
import com.microsoft.azure.management.notificationhubs.v2016_03_01.Sku;
import com.microsoft.azure.management.notificationhubs.v2016_03_01.SharedAccessAuthorizationRuleProperties;
import rx.functions.Func1;

class NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl extends CreatableUpdatableImpl<NotificationHubNamespaceSharedAccessAuthorizationRuleResource, SharedAccessAuthorizationRuleResourceInner, NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl> implements NotificationHubNamespaceSharedAccessAuthorizationRuleResource, NotificationHubNamespaceSharedAccessAuthorizationRuleResource.Definition, NotificationHubNamespaceSharedAccessAuthorizationRuleResource.Update {
    private final NotificationHubsManager manager;
    private String resourceGroupName;
    private String namespaceName;
    private String notificationHubName;
    private String authorizationRuleName;
    private SharedAccessAuthorizationRuleCreateOrUpdateParameters createOrUpdateParameter;

    NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl(String name, NotificationHubsManager manager) {
        super(name, new SharedAccessAuthorizationRuleResourceInner());
        this.manager = manager;
        // Set resource name
        this.authorizationRuleName = name;
        //
        this.createOrUpdateParameter = new SharedAccessAuthorizationRuleCreateOrUpdateParameters();
    }

    NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl(SharedAccessAuthorizationRuleResourceInner inner, NotificationHubsManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.authorizationRuleName = inner.name();
        // resource ancestor names
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.namespaceName = IdParsingUtils.getValueFromIdByName(inner.id(), "namespaces");
        this.notificationHubName = IdParsingUtils.getValueFromIdByName(inner.id(), "notificationHubs");
        this.authorizationRuleName = IdParsingUtils.getValueFromIdByName(inner.id(), "AuthorizationRules");
        //
        this.createOrUpdateParameter = new SharedAccessAuthorizationRuleCreateOrUpdateParameters();
    }

    @Override
    public NotificationHubsManager manager() {
        return this.manager;
    }

    @Override
    public Observable<NotificationHubNamespaceSharedAccessAuthorizationRuleResource> createResourceAsync() {
        NotificationHubsInner client = this.manager().inner().notificationHubs();
        return client.createOrUpdateAuthorizationRuleAsync(this.resourceGroupName, this.namespaceName, this.notificationHubName, this.authorizationRuleName, this.createOrUpdateParameter)
            .map(new Func1<SharedAccessAuthorizationRuleResourceInner, SharedAccessAuthorizationRuleResourceInner>() {
               @Override
               public SharedAccessAuthorizationRuleResourceInner call(SharedAccessAuthorizationRuleResourceInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<NotificationHubNamespaceSharedAccessAuthorizationRuleResource> updateResourceAsync() {
        NotificationHubsInner client = this.manager().inner().notificationHubs();
        return client.createOrUpdateAuthorizationRuleAsync(this.resourceGroupName, this.namespaceName, this.notificationHubName, this.authorizationRuleName, this.createOrUpdateParameter)
            .map(new Func1<SharedAccessAuthorizationRuleResourceInner, SharedAccessAuthorizationRuleResourceInner>() {
               @Override
               public SharedAccessAuthorizationRuleResourceInner call(SharedAccessAuthorizationRuleResourceInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<SharedAccessAuthorizationRuleResourceInner> getInnerAsync() {
        NotificationHubsInner client = this.manager().inner().notificationHubs();
        return client.getAuthorizationRuleAsync(this.resourceGroupName, this.namespaceName, this.notificationHubName, this.authorizationRuleName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new SharedAccessAuthorizationRuleCreateOrUpdateParameters();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public List<AccessRights> rights() {
        return this.inner().rights();
    }

    @Override
    public Sku sku() {
        return this.inner().sku();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl withExistingNotificationHub(String resourceGroupName, String namespaceName, String notificationHubName) {
        this.resourceGroupName = resourceGroupName;
        this.namespaceName = namespaceName;
        this.notificationHubName = notificationHubName;
        return this;
    }

    @Override
    public NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl withLocation(String location) {
        this.createOrUpdateParameter.withLocation(location);
        return this;
    }

    @Override
    public NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl withProperties(SharedAccessAuthorizationRuleProperties properties) {
        this.createOrUpdateParameter.withProperties(properties);
        return this;
    }

    @Override
    public NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl withSku(Sku sku) {
        this.createOrUpdateParameter.withSku(sku);
        return this;
    }

    @Override
    public NotificationHubNamespaceSharedAccessAuthorizationRuleResourceImpl withTags(Map<String, String> tags) {
        this.createOrUpdateParameter.withTags(tags);
        return this;
    }

}
