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
package net.derquinse.common.property;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

/**
 * Class for short-valued property descriptor.
 * @author Andres Rodriguez
 * @param <C> Containing type.
 */
public abstract class ShortMetaProperty<C> extends MetaProperty<C, Short> {
	/**
	 * Default constructor.
	 * @param name Property name.
	 * @param required True if the property is required.
	 * @param validity Validity predicate.
	 * @param defaultValue Default value for the property.
	 */
	protected ShortMetaProperty(String name, boolean required, @Nullable Predicate<? super Short> validity,
			@Nullable Short defaultValue) {
		super(name, required, validity, defaultValue);
	}

	/**
	 * Constructor.
	 * @param name Property name.
	 * @param required True if the property is required.
	 * @param validity Validity predicate.
	 */
	protected ShortMetaProperty(String name, boolean required, @Nullable Predicate<? super Short> validity) {
		super(name, required, validity);
	}

	/**
	 * Constructor.
	 * @param name Property name.
	 * @param required True if the property is required.
	 */
	protected ShortMetaProperty(String name, boolean required) {
		super(name, required);
	}
}