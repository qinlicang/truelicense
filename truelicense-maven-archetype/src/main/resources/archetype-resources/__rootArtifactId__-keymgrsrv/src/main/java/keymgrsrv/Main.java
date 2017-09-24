/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package ${package}.keymgrsrv;

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

    private static final String BASE_URI = "http://localhost:9998/";

    public static void main(final String[] args) throws IOException {
        final ConsumerLicenseManagementService consumerLicenseManagementService = Incubator
                .wire(ConsumerLicenseManagementService.class)
                .bind(ConsumerLicenseManagementService::manager).to(LicenseManager::get)
                .breed();
        final ResourceConfig config = new ResourceConfig(ConsumerLicenseManagementServiceExceptionMapper.class)
                .register(consumerLicenseManagementService);
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:9998/"), config);

        out.printf("Server running at %s.\nHit enter to stop it...\n", BASE_URI);
        in.read();
        server.shutdownNow();
    }
}
