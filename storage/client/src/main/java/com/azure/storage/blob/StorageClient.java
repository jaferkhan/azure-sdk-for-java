// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob;

import com.azure.core.credentials.TokenCredential;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.VoidResponse;
import com.azure.core.util.Context;
import com.azure.storage.blob.models.ContainerItem;
import com.azure.storage.blob.models.StorageServiceProperties;
import com.azure.storage.blob.models.StorageServiceStats;
import com.azure.storage.blob.models.UserDelegationKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URL;
import java.time.Duration;
import java.time.OffsetDateTime;

/**
 * Client to a storage account. It may only be instantiated through a {@link StorageClientBuilder}.
 * This class does not hold any state about a particular storage account but is
 * instead a convenient way of sending off appropriate requests to the resource on the service.
 * It may also be used to construct URLs to blobs and containers.
 *
 * <p>
 * This client contains operations on a blob. Operations on a container are available on {@link ContainerClient}
 * through {@link #getContainerClient(String)}, and operations on a blob are available on {@link BlobClient}.
 *
 * <p>
 * Please see <a href=https://docs.microsoft.com/en-us/azure/storage/blobs/storage-blobs-introduction>here</a> for more
 * information on containers.
 */
public final class StorageClient {

    private StorageAsyncClient storageAsyncClient;

    /**
     * Package-private constructor for use by {@link StorageClientBuilder}.
     * @param storageAsyncClient the async storage account client
     */
    StorageClient(StorageAsyncClient storageAsyncClient) {
        this.storageAsyncClient = storageAsyncClient;
    }

    /**
     * Static method for getting a new builder for this class.
     *
     * @return
     *      A new {@link StorageClientBuilder} instance.
     */
    public static StorageClientBuilder storageClientBuilder() {
        return new StorageClientBuilder();
    }

    /**
     * Initializes a {@link ContainerClient} object pointing to the specified container. This method does not create a
     * container. It simply constructs the URL to the container and offers access to methods relevant to containers.
     *
     * @param containerName
     *     The name of the container to point to.
     * @return
     *     A {@link ContainerClient} object pointing to the specified container
     */
    public ContainerClient getContainerClient(String containerName) {
        return new ContainerClient(storageAsyncClient.getContainerAsyncClient(containerName));
    }

    /**
     * Gets the URL of the storage account represented by this client.
     * @return the URL.
     */
    public URL getAccountUrl() {
        return storageAsyncClient.getAccountUrl();
    }

    /**
     * Returns a lazy loaded list of containers in this account. The returned {@link Iterable} can be iterated
     * through while new items are automatically retrieved as needed. For more information, see
     * the <a href="https://docs.microsoft.com/rest/api/storageservices/list-containers2">Azure Docs</a>.
     *
     * @return
     *      The list of containers.
     */
    public Iterable<ContainerItem> listContainers() {
        return this.listContainers(new ListContainersOptions(), null);
    }

    /**
     * Returns a lazy loaded list of containers in this account. The returned {@link Iterable} can be iterated
     * through while new items are automatically retrieved as needed. For more information, see
     * the <a href="https://docs.microsoft.com/rest/api/storageservices/list-containers2">Azure Docs</a>.
     *
     * @param options
     *         A {@link ListContainersOptions} which specifies what data should be returned by the service.
     * @param timeout
     *         An optional timeout value beyond which a {@link RuntimeException} will be raised.
     *
     * @return
     *      The list of containers.
     */
    public Iterable<ContainerItem> listContainers(ListContainersOptions options, Duration timeout) {
        Flux<ContainerItem> response = storageAsyncClient.listContainers(options, null);

        return timeout == null ?
            response.toIterable():
            response.timeout(timeout).toIterable();
    }

    /**
     * Gets the properties of a storage account’s Blob service. For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-service-properties">Azure Docs</a>.
     *
     * @return
     *      The storage account properties.
     */
    public Response<StorageServiceProperties> getProperties() {
        return this.getProperties(null, null);
    }

    /**
     * Gets the properties of a storage account’s Blob service. For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-service-properties">Azure Docs</a>.
     *
     * @param timeout
     *         An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context
     *         {@code Context} offers a means of passing arbitrary data (key/value pairs) to an
     *         {@link HttpPipeline}'s policy objects. Most applications do not need to pass
     *         arbitrary data to the pipeline and can pass {@code Context.NONE} or {@code null}. Each context object is
     *         immutable. The {@code withContext} with data method creates a new {@code Context} object that refers to
     *         its parent, forming a linked list.
     *
     * @return
     *      The storage account properties.
     */
    public Response<StorageServiceProperties> getProperties(Duration timeout, Context context) {

        Mono<Response<StorageServiceProperties>> response = storageAsyncClient.getProperties(context);

        return Utility.blockWithOptionalTimeout(response, timeout);
    }

    /**
     * Sets properties for a storage account's Blob service endpoint. For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/set-blob-service-properties">Azure Docs</a>.
     * Note that setting the default service version has no effect when using this client because this client explicitly
     * sets the version header on each request, overriding the default.
     *
     * @param properties
     *         Configures the service.
     *
     * @return
     *      The storage account properties.
     */
    public VoidResponse setProperties(StorageServiceProperties properties) {
        return this.setProperties(properties, null, null);
    }

    /**
     * Sets properties for a storage account's Blob service endpoint. For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/set-blob-service-properties">Azure Docs</a>.
     * Note that setting the default service version has no effect when using this client because this client explicitly
     * sets the version header on each request, overriding the default.
     *
     * @param properties
     *         Configures the service.
     * @param timeout
     *         An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context
     *         {@code Context} offers a means of passing arbitrary data (key/value pairs) to an
     *         {@link HttpPipeline}'s policy objects. Most applications do not need to pass
     *         arbitrary data to the pipeline and can pass {@code Context.NONE} or {@code null}. Each context object is
     *         immutable. The {@code withContext} with data method creates a new {@code Context} object that refers to
     *         its parent, forming a linked list.
     *
     * @return
     *      The storage account properties.
     */
    public VoidResponse setProperties(StorageServiceProperties properties, Duration timeout, Context context) {
        Mono<VoidResponse> response = storageAsyncClient.setProperties(properties, context);

        return Utility.blockWithOptionalTimeout(response, timeout);
    }

    /**
     * Gets a user delegation key for use with this account's blob storage.
     * Note: This method call is only valid when using {@link TokenCredential} in this object's {@link HttpPipeline}.
     *
     * @param start
     *         Start time for the key's validity. Null indicates immediate start.
     * @param expiry
     *         Expiration of the key's validity.
     *
     * @return
     *      The user delegation key.
     */
    public Response<UserDelegationKey> getUserDelegationKey(OffsetDateTime start, OffsetDateTime expiry) {
        return this.getUserDelegationKey(start, expiry, null, null);
    }

    /**
     * Gets a user delegation key for use with this account's blob storage.
     * Note: This method call is only valid when using {@link TokenCredential} in this object's {@link HttpPipeline}.
     *
     * @param start
     *         Start time for the key's validity. Null indicates immediate start.
     * @param expiry
     *         Expiration of the key's validity.
     * @param timeout
     *         An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context
     *         {@code Context} offers a means of passing arbitrary data (key/value pairs) to an
     *         {@link HttpPipeline}'s policy objects. Most applications do not need to pass
     *         arbitrary data to the pipeline and can pass {@code Context.NONE} or {@code null}. Each context object is
     *         immutable. The {@code withContext} with data method creates a new {@code Context} object that refers to
     *         its parent, forming a linked list.
     *
     * @return
     *      The user delegation key.
     */
    public Response<UserDelegationKey> getUserDelegationKey(OffsetDateTime start, OffsetDateTime expiry,
            Duration timeout, Context context) {
        Mono<Response<UserDelegationKey>> response = storageAsyncClient.getUserDelegationKey(start, expiry, context);

        return Utility.blockWithOptionalTimeout(response, timeout);
    }

    /**
     * Retrieves statistics related to replication for the Blob service. It is only available on the secondary
     * location endpoint when read-access geo-redundant replication is enabled for the storage account. For more
     * information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-service-stats">Azure Docs</a>.
     *
     * @return
     *      The storage account statistics.
     */
    public Response<StorageServiceStats> getStatistics() {
        return this.getStatistics(null, null);
    }

    /**
     * Retrieves statistics related to replication for the Blob service. It is only available on the secondary
     * location endpoint when read-access geo-redundant replication is enabled for the storage account. For more
     * information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-service-stats">Azure Docs</a>.
     *
     * @param timeout
     *         An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context
     *         {@code Context} offers a means of passing arbitrary data (key/value pairs) to an
     *         {@link HttpPipeline}'s policy objects. Most applications do not need to pass
     *         arbitrary data to the pipeline and can pass {@code Context.NONE} or {@code null}. Each context object is
     *         immutable. The {@code withContext} with data method creates a new {@code Context} object that refers to
     *         its parent, forming a linked list.
     *
     * @return
     *      The storage account statistics.
     */
    public Response<StorageServiceStats> getStatistics(Duration timeout, Context context) {
        Mono<Response<StorageServiceStats>> response = storageAsyncClient.getStatistics(context);

        return Utility.blockWithOptionalTimeout(response, timeout);
    }

    /**
     * Returns the sku name and account kind for the account. For more information, please see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-account-information">Azure Docs</a>.
     *
     * @return
     *      The storage account info.
     */
    public Response<StorageAccountInfo> getAccountInfo() {
        return this.getAccountInfo(null, null);
    }

    /**
     * Returns the sku name and account kind for the account. For more information, please see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-account-information">Azure Docs</a>.
     *
     * @param timeout
     *         An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context
     *         {@code Context} offers a means of passing arbitrary data (key/value pairs) to an
     *         {@link HttpPipeline}'s policy objects. Most applications do not need to pass
     *         arbitrary data to the pipeline and can pass {@code Context.NONE} or {@code null}. Each context object is
     *         immutable. The {@code withContext} with data method creates a new {@code Context} object that refers to
     *         its parent, forming a linked list.
     *
     * @return
     *      The storage account info.
     */
    public Response<StorageAccountInfo> getAccountInfo(Duration timeout, Context context) {
        Mono<Response<StorageAccountInfo>> response = storageAsyncClient.getAccountInfo(context);

        return Utility.blockWithOptionalTimeout(response, timeout);
    }
}