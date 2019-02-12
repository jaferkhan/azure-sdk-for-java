/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlab;

import java.util.List;
import com.microsoft.azure.management.devtestlab.implementation.ArtifactInstallPropertiesInner;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body for applying artifacts to a virtual machine.
 */
public class ApplyArtifactsRequest {
    /**
     * The list of artifacts to apply.
     */
    @JsonProperty(value = "artifacts")
    private List<ArtifactInstallPropertiesInner> artifacts;

    /**
     * Get the artifacts value.
     *
     * @return the artifacts value
     */
    public List<ArtifactInstallPropertiesInner> artifacts() {
        return this.artifacts;
    }

    /**
     * Set the artifacts value.
     *
     * @param artifacts the artifacts value to set
     * @return the ApplyArtifactsRequest object itself.
     */
    public ApplyArtifactsRequest withArtifacts(List<ArtifactInstallPropertiesInner> artifacts) {
        this.artifacts = artifacts;
        return this;
    }

}