/*
 * Copyright (C) 2005-2017 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package net.truelicense.api.passwd;

/**
 * A container for a destroyable password.
 *
 * @see PasswordProtection
 * @author Christian Schlichtherle
 */
public interface Password extends AutoCloseable {

    /** Returns the shared array of password characters. */
    char[] characters();

    /** Wipes the shared array of password characters. */
    void close();
}
