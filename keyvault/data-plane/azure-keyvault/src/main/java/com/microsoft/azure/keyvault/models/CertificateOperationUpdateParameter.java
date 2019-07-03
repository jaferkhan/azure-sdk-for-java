// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator

package com.microsoft.azure.keyvault.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The certificate operation update parameters.
 */
public class CertificateOperationUpdateParameter {
    /**
     * Indicates if cancellation was requested on the certificate operation.
     */
    @JsonProperty(value = "cancellation_requested", required = true)
    private boolean cancellationRequested;

    /**
     * Get the cancellationRequested value.
     *
     * @return the cancellationRequested value
     */
    public boolean cancellationRequested() {
        return this.cancellationRequested;
    }

    /**
     * Set the cancellationRequested value.
     *
     * @param cancellationRequested the cancellationRequested value to set
     * @return the CertificateOperationUpdateParameter object itself.
     */
    public CertificateOperationUpdateParameter withCancellationRequested(boolean cancellationRequested) {
        this.cancellationRequested = cancellationRequested;
        return this;
    }

}