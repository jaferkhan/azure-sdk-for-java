/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.datafactory.v2018_06_01.implementation.DatasetInner;

/**
 * Microsoft Azure Document Database Collection dataset.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = DocumentDbCollectionDataset.class)
@JsonTypeName("DocumentDbCollection")
@JsonFlatten
public class DocumentDbCollectionDataset extends DatasetInner {
    /**
     * Document Database collection name. Type: string (or Expression with
     * resultType string).
     */
    @JsonProperty(value = "typeProperties.collectionName", required = true)
    private Object collectionName;

    /**
     * Get document Database collection name. Type: string (or Expression with resultType string).
     *
     * @return the collectionName value
     */
    public Object collectionName() {
        return this.collectionName;
    }

    /**
     * Set document Database collection name. Type: string (or Expression with resultType string).
     *
     * @param collectionName the collectionName value to set
     * @return the DocumentDbCollectionDataset object itself.
     */
    public DocumentDbCollectionDataset withCollectionName(Object collectionName) {
        this.collectionName = collectionName;
        return this;
    }

}
