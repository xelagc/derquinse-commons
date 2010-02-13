/*
 * Copyright 2008-2010 the original author or authors.
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
package net.derquinse.common.property;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Type;

import net.derquinse.common.base.Types;

/**
 * Skeletal implementation of a type descriptors.
 * @author Andres Rodriguez
 * @param <T> Described type.
 */
public abstract class AbstractDescriptor<T> implements Descriptor<T> {
	/** The type. */
	private final Type type;
	/** The raw type. */
	private final Class<? super T> rawType;

	/** Constructor. */
	@SuppressWarnings("unchecked")
	protected AbstractDescriptor() {
		this.type = Types.getSuperclassTypeArgument(getClass());
		this.rawType = (Class<? super T>) Types.getRawType(this.type);
	}

	/**
	 * Constructor with a raw type.
	 * @param type Raw type.
	 */
	protected AbstractDescriptor(Class<T> type) {
		this.type = checkNotNull(type, "The type must be provided");
		this.rawType = type;
	}

	/*
	 * (non-Javadoc)
	 * @see net.derquinse.common.property.Descriptor#getType()
	 */
	public final Type getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * @see net.derquinse.common.property.Descriptor#getRawType()
	 */
	public Class<? super T> getRawType() {
		return rawType;
	}

	/**
	 * Returns whether the described type is a raw type.
	 * @return True if the described type is a raw type.
	 */
	public final boolean isRawType() {
		return type == rawType;
	}
}