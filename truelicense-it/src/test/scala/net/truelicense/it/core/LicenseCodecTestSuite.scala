/*
 * Copyright (C) 2005-2017 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package net.truelicense.it.core

/** @author Christian Schlichtherle */
abstract class LicenseCodecTestSuite
  extends CodecTestSuite { this: TestContext[_] =>

  final def artifact: AnyRef = license
}
