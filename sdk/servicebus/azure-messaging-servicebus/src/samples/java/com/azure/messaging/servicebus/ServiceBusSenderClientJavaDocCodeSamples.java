// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import com.azure.messaging.servicebus.models.CreateBatchOptions;

import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Contains code snippets when generating javadocs through doclets for {@link ServiceBusSenderClient}.
 */
public class ServiceBusSenderClientJavaDocCodeSamples {
    private final ServiceBusClientBuilder builder = new ServiceBusClientBuilder()
        .connectionString("fake-string");

    /**
     * Code snippet demonstrating how to create an {@link ServiceBusSenderClient}.
     */
    public void instantiate() {
        // BEGIN: com.azure.messaging.servicebus.servicebussenderclient.instantiation
        // The required parameter is a way to authenticate with Service Bus using credentials.
        // The connectionString provides a way to authenticate with Service Bus.
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
            .connectionString(
                "Endpoint={fully-qualified-namespace};SharedAccessKeyName={policy-name};SharedAccessKey={key}")
            .buildSenderClientBuilder()
            .entityName("queue-name")
            .buildClient();

        // END: com.azure.messaging.servicebus.servicebussenderclient.instantiation

        sender.close();
    }

    /**
     * Code snippet demonstrating how to send a batch to Service Bus queue or topic.
     *
     * @throws IllegalArgumentException if an message is too large.
     */
    public void sendBatch() {
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
            .connectionString("fake-string")
            .buildSenderClientBuilder()
            .buildClient();

        // BEGIN: com.azure.messaging.servicebus.servicebussenderclient.createBatch

        List<ServiceBusMessage> messages = Arrays.asList(new ServiceBusMessage("test-1".getBytes(UTF_8)),
            new ServiceBusMessage("test-2".getBytes(UTF_8)));

        final CreateBatchOptions options = new CreateBatchOptions().setMaximumSizeInBytes(10 * 1024);
        // Creating a batch without options set.
        ServiceBusMessageBatch batch = sender.createBatch(options);
        for (ServiceBusMessage message : messages) {
            if (batch.tryAdd(message)) {
                continue;
            }

            sender.send(batch);
        }
        // END: com.azure.messaging.servicebus.servicebussenderclient.createBatch

        sender.close();
    }

    /**
     * Code snippet demonstrating how to create a size-limited {@link ServiceBusMessageBatch} and send it.
     *
     * @throws IllegalArgumentException if an message is too large for an empty batch.
     */
    public void batchSizeLimited() {
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
            .connectionString(
                "Endpoint={fully-qualified-namespace};SharedAccessKeyName={policy-name};SharedAccessKey={key}")
            .buildSenderClientBuilder()
            .entityName("<QUEUE-NAME>")
            .buildClient();

        final ServiceBusMessage firstMessage = new ServiceBusMessage("message-1".getBytes(UTF_8));
        firstMessage.getProperties().put("telemetry", "latency");
        final ServiceBusMessage secondMessage = new ServiceBusMessage("message-2".getBytes(UTF_8));
        secondMessage.getProperties().put("telemetry", "cpu-temperature");
        final ServiceBusMessage thirdMessage = new ServiceBusMessage("message-3".getBytes(UTF_8));
        thirdMessage.getProperties().put("telemetry", "fps");

        // BEGIN: com.azure.messaging.servicebus.servicebussenderclient.createBatch#CreateBatchOptions-int


        final List<ServiceBusMessage> telemetryMessages = Arrays.asList(firstMessage, secondMessage, thirdMessage);

        // Setting `setMaximumSizeInBytes` when creating a batch, limits the size of that batch.
        // In this case, all the batches created with these options are limited to 256 bytes.
        final CreateBatchOptions options = new CreateBatchOptions()
            .setMaximumSizeInBytes(256);

        ServiceBusMessageBatch currentBatch = sender.createBatch(options);

        // For each telemetry message, we try to add it to the current batch.
        // When the batch is full, send it then create another batch to add more mesages to.
        for (ServiceBusMessage message : telemetryMessages) {
            if (!currentBatch.tryAdd(message)) {
                sender.send(currentBatch);
                currentBatch = sender.createBatch(options);

                // Add the message we couldn't before.
                if (!currentBatch.tryAdd(message)) {
                    throw new IllegalArgumentException("Message is too large for an empty batch.");
                }
            }
        }
        // END: com.azure.messaging.servicebus.servicebussenderclient.createBatch#CreateBatchOptions-int
    }
}
