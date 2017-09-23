/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package ${package}.keymgrsvc;

import ${package}.keymgr.LicenseManager;
import global.namespace.neuron.di.java.*;
import java.io.IOException;
import static java.lang.System.*;
import java.net.URI;
import net.truelicense.jax.rs.*;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Christian Schlichtherle
 */
public class Main {

    public static void main(final String[] args) throws IOException {
        final ConsumerLicenseManagementService consumerLicenseManagementService = Incubator
                .wire(ConsumerLicenseManagementService.class)
                .bind(ConsumerLicenseManagementService::manager).to(LicenseManager::get)
                .breed();
        final ResourceConfig config = new ResourceConfig(ConsumerLicenseManagementServiceExceptionMapper.class)
                .register(consumerLicenseManagementService);
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:9998/"), config);
        server.start();

        out.println("Server running.");
        out.println("Visit: http://localhost:9998/license");
        out.println("Hit Enter to stop.");
        in.read();
        out.println("Stopping server...");
        server.shutdownNow();

        out.println("Server stopped.");
    }
}
