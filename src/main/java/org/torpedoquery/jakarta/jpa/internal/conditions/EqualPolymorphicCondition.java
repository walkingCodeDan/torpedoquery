
/**
 * Copyright (C) 2011 Xavier Jodoin (xavier@jodoin.me)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author xjodoin
 * @version $Id: $Id
 */
package org.torpedoquery.jakarta.jpa.internal.conditions;

import org.torpedoquery.jakarta.jpa.internal.Selector;
public class EqualPolymorphicCondition<T> extends PolymorphicCondition<T> {

	/**
	 * <p>Constructor for EqualPolymorphicCondition.</p>
	 *
	 * @param selector a {@link org.torpedoquery.jakarta.jpa.internal.Selector} object.
	 * @param condition a {@link java.lang.Class} object.
	 */
	public EqualPolymorphicCondition(Selector selector, Class<? extends T> condition) {
		super(selector, condition);
	}

	/** {@inheritDoc} */
	@Override
	protected String getComparator() {
		return EqualCondition.EQUAL;
	}

}
