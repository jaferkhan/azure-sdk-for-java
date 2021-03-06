/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_09_01.implementation;

import com.microsoft.azure.management.network.v2019_09_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * Tap configuration in a Network Interface.
 */
@JsonFlatten
public class NetworkInterfaceTapConfigurationInner extends SubResource {
    /**
     * The reference of the Virtual Network Tap resource.
     */
    @JsonProperty(value = "properties.virtualNetworkTap")
    private VirtualNetworkTapInner virtualNetworkTap;

    /**
     * The provisioning state of the network interface tap configuration
     * resource. Possible values include: 'Succeeded', 'Updating', 'Deleting',
     * 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The name of the resource that is unique within a resource group. This
     * name can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Sub Resource type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get the reference of the Virtual Network Tap resource.
     *
     * @return the virtualNetworkTap value
     */
    public VirtualNetworkTapInner virtualNetworkTap() {
        return this.virtualNetworkTap;
    }

    /**
     * Set the reference of the Virtual Network Tap resource.
     *
     * @param virtualNetworkTap the virtualNetworkTap value to set
     * @return the NetworkInterfaceTapConfigurationInner object itself.
     */
    public NetworkInterfaceTapConfigurationInner withVirtualNetworkTap(VirtualNetworkTapInner virtualNetworkTap) {
        this.virtualNetworkTap = virtualNetworkTap;
        return this;
    }

    /**
     * Get the provisioning state of the network interface tap configuration resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @param name the name value to set
     * @return the NetworkInterfaceTapConfigurationInner object itself.
     */
    public NetworkInterfaceTapConfigurationInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get sub Resource type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}
