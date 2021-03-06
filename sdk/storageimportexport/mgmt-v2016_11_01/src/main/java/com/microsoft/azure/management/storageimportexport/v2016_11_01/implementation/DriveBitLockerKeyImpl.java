/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storageimportexport.v2016_11_01.implementation;

import com.microsoft.azure.management.storageimportexport.v2016_11_01.DriveBitLockerKey;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;

class DriveBitLockerKeyImpl extends WrapperImpl<DriveBitLockerKeyInner> implements DriveBitLockerKey {
    private final StorageImportExportManager manager;
    DriveBitLockerKeyImpl(DriveBitLockerKeyInner inner, StorageImportExportManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public StorageImportExportManager manager() {
        return this.manager;
    }

    @Override
    public String bitLockerKey() {
        return this.inner().bitLockerKey();
    }

    @Override
    public String driveId() {
        return this.inner().driveId();
    }

}
