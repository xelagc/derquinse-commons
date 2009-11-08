/*
 * Copyright 2009 the original author or authors.
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

import com.google.common.base.Predicate;

/**
 * Abstract implementation for integer properties. The validity predicates may
 * assume the object to check is not {@code null} as nullity vs optionality
 * checking is performed before using the predicate.
 * @author Andres Rodriguez
 * @param <E> Enclosing type.
 */
public abstract class IntegerProperty<E> extends AbstractProperty<E, Integer> {

	/**
	 * Constructor.
	 * @param name Property name.
	 * @param optional Whether the property is optional.
	 * @param immutable Whether the property is immutable.
	 * @param predicate Validity predicate.
	 */
	protected IntegerProperty(String name, boolean optional, boolean immutable, Predicate<? super Integer> predicate) {
		super(name, optional, immutable, predicate);
	}

	/**
	 * Constructor.
	 * @param name Property name.
	 * @param optional Whether the property is optional.
	 * @param immutable Whether the property is immutable.
	 */
	IntegerProperty(String name, boolean optional, boolean immutable) {
		super(name, optional, immutable);
	}
}
