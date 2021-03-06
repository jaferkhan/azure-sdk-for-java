/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.authorization.v2018_09_01_preview.implementation;

import com.microsoft.azure.management.authorization.v2018_09_01_preview.ClassicAdministrator;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import rx.Observable;

class ClassicAdministratorImpl extends WrapperImpl<ClassicAdministratorInner> implements ClassicAdministrator {
    private final AuthorizationManager manager;

    ClassicAdministratorImpl(ClassicAdministratorInner inner,  AuthorizationManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public AuthorizationManager manager() {
        return this.manager;
    }



    @Override
    public String emailAddress() {
        return this.inner().emailAddress();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String role() {
        return this.inner().role();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
