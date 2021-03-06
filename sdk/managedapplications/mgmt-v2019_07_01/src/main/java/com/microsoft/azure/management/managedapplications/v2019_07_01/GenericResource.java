/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.managedapplications.v2019_07_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * Resource information.
 */
@SkipParentValidation
public class GenericResource extends Resource {
    /**
     * ID of the resource that manages this resource.
     */
    @JsonProperty(value = "managedBy")
    private String managedBy;

    /**
     * The SKU of the resource.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /**
     * Get iD of the resource that manages this resource.
     *
     * @return the managedBy value
     */
    public String managedBy() {
        return this.managedBy;
    }

    /**
     * Set iD of the resource that manages this resource.
     *
     * @param managedBy the managedBy value to set
     * @return the GenericResource object itself.
     */
    public GenericResource withManagedBy(String managedBy) {
        this.managedBy = managedBy;
        return this;
    }

    /**
     * Get the SKU of the resource.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the SKU of the resource.
     *
     * @param sku the sku value to set
     * @return the GenericResource object itself.
     */
    public GenericResource withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

}
