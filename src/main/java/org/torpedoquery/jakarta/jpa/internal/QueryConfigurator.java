
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
package org.torpedoquery.jakarta.jpa.internal;

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.internal.conditions.ConditionBuilder;
public interface QueryConfigurator<T> {
	/**
	 * <p>configure.</p>
	 *
	 * @param builder a {@link org.torpedoquery.jakarta.core.QueryBuilder} object.
	 * @param condition a {@link org.torpedoquery.jakarta.jpa.internal.conditions.ConditionBuilder} object.
	 */
	void configure(QueryBuilder<T> builder, ConditionBuilder<T> condition);
}
