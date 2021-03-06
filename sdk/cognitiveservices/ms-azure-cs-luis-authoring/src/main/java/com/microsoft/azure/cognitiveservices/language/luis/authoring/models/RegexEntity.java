/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.authoring.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Regular Expression Entity Extractor.
 */
public class RegexEntity {
    /**
     * The name property.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The regexPattern property.
     */
    @JsonProperty(value = "regexPattern")
    private String regexPattern;

    /**
     * The roles property.
     */
    @JsonProperty(value = "roles")
    private List<String> roles;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the RegexEntity object itself.
     */
    public RegexEntity withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the regexPattern value.
     *
     * @return the regexPattern value
     */
    public String regexPattern() {
        return this.regexPattern;
    }

    /**
     * Set the regexPattern value.
     *
     * @param regexPattern the regexPattern value to set
     * @return the RegexEntity object itself.
     */
    public RegexEntity withRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
        return this;
    }

    /**
     * Get the roles value.
     *
     * @return the roles value
     */
    public List<String> roles() {
        return this.roles;
    }

    /**
     * Set the roles value.
     *
     * @param roles the roles value to set
     * @return the RegexEntity object itself.
     */
    public RegexEntity withRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

}
