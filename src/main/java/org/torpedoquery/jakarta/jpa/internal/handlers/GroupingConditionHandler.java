
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
package org.torpedoquery.jakarta.jpa.internal.handlers;

import java.util.Deque;
import java.util.Map;

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jakarta.jpa.internal.Condition;
import org.torpedoquery.jakarta.jpa.internal.MethodCall;
import org.torpedoquery.jakarta.jpa.internal.QueryConfigurator;
import org.torpedoquery.jakarta.jpa.internal.conditions.ConditionBuilder;
import org.torpedoquery.jakarta.jpa.internal.conditions.GroupingCondition;
import org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition;
public class GroupingConditionHandler<T> implements QueryHandler<OnGoingLogicalCondition> {

	private final Condition condition;
	private final QueryConfigurator<T> configurator;

	/**
	 * <p>
	 * Constructor for GroupingConditionHandler.
	 * </p>
	 *
	 * @param configurator
	 *            a {@link org.torpedoquery.jakarta.jpa.internal.QueryConfigurator}
	 *            object.
	 * @param condition
	 *            a {@link org.torpedoquery.jakarta.jpa.OnGoingLogicalCondition} object.
	 */
	public GroupingConditionHandler(QueryConfigurator<T> configurator, Condition condition) {
		this.configurator = configurator;
		this.condition = condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingLogicalCondition handleCall(Map<Object, QueryBuilder<?>> proxyQueryBuilders,
			Deque<MethodCall> methods) {
		QueryBuilder<T> builder = condition.getBuilder();
		if (builder != null) {
			GroupingCondition groupingCondition = new GroupingCondition(condition);
			LogicalCondition newLogicalCondition = new LogicalCondition(builder,groupingCondition);
			configurator.configure(builder, new ConditionBuilder<T>(newLogicalCondition, null));
			return newLogicalCondition;
		}
		else {
			return (OnGoingLogicalCondition) condition;
		}

	}
}
