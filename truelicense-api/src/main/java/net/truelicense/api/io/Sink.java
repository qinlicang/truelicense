/*
 * Copyright (C) 2005-2017 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package net.truelicense.api.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * A factory for {@link OutputStream}s.
 *
 * @see    Source
 * @author Christian Schlichtherle
 */
public interface Sink {

    /** Returns a new output stream for writing data to this sink. */
    OutputStream output() throws IOException;
}
