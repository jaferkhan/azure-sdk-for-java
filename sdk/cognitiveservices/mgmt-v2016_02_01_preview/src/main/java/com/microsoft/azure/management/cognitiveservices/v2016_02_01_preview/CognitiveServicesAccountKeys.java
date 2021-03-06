/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cognitiveservices.v2016_02_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.cognitiveservices.v2016_02_01_preview.implementation.CognitiveServicesManager;
import com.microsoft.azure.management.cognitiveservices.v2016_02_01_preview.implementation.CognitiveServicesAccountKeysInner;

/**
 * Type representing CognitiveServicesAccountKeys.
 */
public interface CognitiveServicesAccountKeys extends HasInner<CognitiveServicesAccountKeysInner>, HasManager<CognitiveServicesManager> {
    /**
     * @return the key1 value.
     */
    String key1();

    /**
     * @return the key2 value.
     */
    String key2();

}
