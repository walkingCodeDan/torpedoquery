
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

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.ComparableFunction;
import org.torpedoquery.jakarta.jpa.Function;
import org.torpedoquery.jakarta.jpa.OnGoingCollectionCondition;
import org.torpedoquery.jakarta.jpa.OnGoingComparableCondition;
import org.torpedoquery.jakarta.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jakarta.jpa.OnGoingStringCondition;
import org.torpedoquery.jakarta.jpa.ValueOnGoingCondition;
import org.torpedoquery.jakarta.jpa.internal.Condition;
import org.torpedoquery.jakarta.jpa.internal.Parameter;
public class LogicalCondition<E> implements OnGoingLogicalCondition, Condition {

	private Condition condition;
	private final QueryBuilder<E> builder;

	/**
	 * <p>Constructor for LogicalCondition.</p>
	 *
	 * @param builder a {@link org.torpedoquery.jakarta.core.QueryBuilder} object.
	 * @param condition a {@link org.torpedoquery.jakarta.jpa.internal.Condition} object.
	 */
	public LogicalCondition(QueryBuilder<E> builder, Condition condition) {
		this.builder = builder;
		this.condition = condition;
	}

	/** {@inheritDoc} */
	@Override
	public <T1> ValueOnGoingCondition<T1> and(T1 property) {
		ValueOnGoingCondition<T1> right = ConditionHelper.createCondition(this);
		condition = new AndCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <T1> ValueOnGoingCondition<T1> or(T1 property) {
		ValueOnGoingCondition<T1> right = ConditionHelper.createCondition(this);
		condition = new OrCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> and(
			T property) {
		OnGoingComparableCondition<V> right = ConditionHelper.createCondition(this);
		condition = new AndCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> or(
			T property) {
		OnGoingComparableCondition<V> right = ConditionHelper.createCondition(this);
		condition = new OrCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public List<Parameter> getParameters() {
		return condition.getParameters();
	}

	/** {@inheritDoc} */
	@Override
	public String createQueryFragment(AtomicInteger incrementor) {
		return condition.createQueryFragment(incrementor);
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingLogicalCondition and(OnGoingLogicalCondition condition) {
		this.condition = new AndCondition(this.condition,
				new GroupingCondition((Condition) condition));
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingLogicalCondition or(OnGoingLogicalCondition condition) {
		this.condition = new OrCondition(this.condition, new GroupingCondition(
				(Condition) condition));
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> and(String property) {
		OnGoingStringCondition<String> right = ConditionHelper
				.<String, OnGoingStringCondition<String>> createCondition(this);
		condition = new AndCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> and(Function<String> function) {
		OnGoingStringCondition<String> right = ConditionHelper.createCondition(function, this);
		condition = new AndCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> or(String property) {
		OnGoingStringCondition<String> right = ConditionHelper.createCondition(this);
		condition = new OrCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> or(Function<String> function) {
		OnGoingStringCondition<String> right = ConditionHelper.createCondition(function, this);
		condition = new OrCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <T1> OnGoingCollectionCondition<T1> and(Collection<T1> object) {
		OnGoingCollectionCondition<T1> right = ConditionHelper.createCondition(this);
		condition = new AndCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <T1> OnGoingCollectionCondition<T1> or(Collection<T1> object) {
		OnGoingCollectionCondition<T1> right = ConditionHelper.createCondition(this);
		condition = new OrCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> and(ComparableFunction<T> function) {
		OnGoingComparableCondition<V> right = (OnGoingComparableCondition<V>) ConditionHelper.createCondition(function,this);
		condition = new AndCondition(condition, (Condition) right);
		return right;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> or(ComparableFunction<T> function) {
		OnGoingComparableCondition<V> right = (OnGoingComparableCondition<V>) ConditionHelper.createCondition(function,	this);
		condition = new OrCondition(condition, (Condition) right);
		return right;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>Getter for the field <code>builder</code>.</p>
	 */
	@Override
	public QueryBuilder<E> getBuilder() {
		return builder;
	}

}
