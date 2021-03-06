/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package ${package}.keymgrsrv;

import ${package}.keymgr.LicenseManager;
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
        final ResourceConfig rc = new ResourceConfig(ConsumerLicenseManagementServiceExceptionMapper.class)
                .register(new ConsumerLicenseManagementService(LicenseManager::get));
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        out.printf("Server running at %s.\nHit enter to stop it...\n", BASE_URI);
        in.read();
        server.shutdownNow();
    }
}
