/*
 * Copyright (C) the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.derquinse.common.io;

import java.io.InputStream;
import java.nio.ByteBuffer;

import net.derquinse.common.base.NotInstantiable;

import com.google.common.io.InputSupplier;

/**
 * Provides utility methods for working with byte arrays and I/O streams.
 * <p>
 * All method parameters must be non-null unless documented otherwise.
 * @author Andres Rodriguez
 */
public final class DerquinseByteStreams extends NotInstantiable {
	/** Not instantiable. */
	private DerquinseByteStreams() {
	}

	/**
	 * Returns a factory that will supply instances of {@link InputStream} that read from an sliced
	 * view of the given byte buffer.
	 * @param b The input buffer.
	 * @return The requested factory.
	 */
	public static InputSupplier<InputStream> newInputStreamSupplier(ByteBuffer b) {
		return new ByteBufferInputStreamSupplier(b);
	}
}
