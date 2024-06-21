
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
import org.torpedoquery.jakarta.jpa.OnGoingCondition;
import org.torpedoquery.jakarta.jpa.internal.MethodCall;
import org.torpedoquery.jakarta.jpa.internal.QueryConfigurator;
import org.torpedoquery.jakarta.jpa.internal.Selector;
import org.torpedoquery.jakarta.jpa.internal.TorpedoProxy;
import org.torpedoquery.jakarta.jpa.internal.conditions.ConditionBuilder;
import org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition;
import org.torpedoquery.jakarta.jpa.internal.utils.WhereQueryConfigurator;
public class WhereClauseHandler<T, E extends OnGoingCondition<T>> extends AbstractCallHandler<E>
		implements QueryHandler<E>, ValueHandler<E> {

	private final LogicalCondition logicalCondition;
	private final QueryConfigurator<T> configurator;
	private final Object param;

	/**
	 * <p>
	 * Constructor for WhereClauseHandler.
	 * </p>
	 *
	 * @param param
	 *            a {@link java.lang.Object} object.
	 */
	public WhereClauseHandler(Object param) {
		this(param, null, new WhereQueryConfigurator<T>());
	}

	/**
	 * <p>
	 * Constructor for WhereClauseHandler.
	 * </p>
	 *
	 * @param param
	 *            a {@link java.lang.Object} object.
	 * @param configurator
	 *            a {@link org.torpedoquery.jakarta.jpa.internal.QueryConfigurator}
	 *            object.
	 */
	public WhereClauseHandler(Object param, QueryConfigurator<T> configurator) {
		this(param, null, configurator);
	}

	/**
	 * <p>
	 * Constructor for WhereClauseHandler.
	 * </p>
	 *
	 * @param param
	 *            a {@link java.lang.Object} object.
	 * @param logicalCondition
	 *            a
	 *            {@link org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition}
	 *            object.
	 * @param configurator
	 *            a {@link org.torpedoquery.jakarta.jpa.internal.QueryConfigurator}
	 *            object.
	 */
	public WhereClauseHandler(Object param, LogicalCondition logicalCondition, QueryConfigurator<T> configurator) {
		this.param = param;
		this.logicalCondition = logicalCondition;
		this.configurator = configurator;
	}

	/** {@inheritDoc} */
	@Override
	public E handleCall(Map<Object, QueryBuilder<?>> proxyQueryBuilders, Deque<MethodCall> methodCalls) {

		return handleValue(this, proxyQueryBuilders, methodCalls.iterator(), param);
	}

	/** {@inheritDoc} */
	@Override
	public E handle(TorpedoProxy proxy, QueryBuilder queryBuilder, Selector selector) {
		
		final ConditionBuilder<T> whereClause = logicalCondition != null
				? new ConditionBuilder<>(logicalCondition, selector) : new ConditionBuilder<>(queryBuilder, selector);

		configurator.configure(queryBuilder, whereClause);

		return (E) whereClause;
	}
}
