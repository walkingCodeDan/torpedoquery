
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

import org.torpedoquery.jakarta.jpa.Function;
import org.torpedoquery.jakarta.jpa.OnGoingCondition;
import org.torpedoquery.jakarta.jpa.internal.Condition;
import org.torpedoquery.jakarta.jpa.internal.TorpedoMagic;
import org.torpedoquery.jakarta.jpa.internal.handlers.WhereClauseHandler;
import org.torpedoquery.jakarta.jpa.internal.utils.DoNothingQueryConfigurator;
import org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler;
public final class ConditionHelper {

	private ConditionHelper() {
	}

	/**
	 * <p>createCondition.</p>
	 *
	 * @param condition a {@link org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition} object.
	 * @param <T> a T object.
	 * @return a E object.
	 * @param <E> a E object.
	 */
	public static <T, E extends OnGoingCondition<T>> E createCondition(LogicalCondition condition) {
		return ConditionHelper.<T, E> createCondition(null, condition);
	}

	/**
	 * <p>createCondition.</p>
	 *
	 * @param function a {@link org.torpedoquery.jakarta.jpa.Function} object.
	 * @param condition a {@link org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition} object.
	 * @param <T> a T object.
	 * @return a E object.
	 * @param <E> a E object.
	 */
	public static <T, E extends OnGoingCondition<T>> E createCondition(Function<T> function, LogicalCondition condition) {
		TorpedoMethodHandler fjpaMethodHandler = TorpedoMagic.getTorpedoMethodHandler();
		WhereClauseHandler<T, E> whereClauseHandler = new WhereClauseHandler<>(function, condition, new DoNothingQueryConfigurator<>());
		return fjpaMethodHandler.handle(whereClauseHandler);
	}
	
	
	/**
	 * <p>getConditionClause.</p>
	 *
	 * @param conditionBuilder a {@link org.torpedoquery.jakarta.jpa.internal.conditions.ConditionBuilder} object.
	 * @return a {@link org.torpedoquery.jakarta.jpa.internal.Condition} object.
	 */
	public static Condition getConditionClause(ConditionBuilder<?> conditionBuilder) {
		if (conditionBuilder != null) {
			return conditionBuilder.getLogicalCondition() != null ? conditionBuilder.getLogicalCondition() : conditionBuilder;
		}
		return null;
	}

}
