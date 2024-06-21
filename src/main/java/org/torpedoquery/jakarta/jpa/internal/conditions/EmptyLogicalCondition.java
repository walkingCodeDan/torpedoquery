package org.torpedoquery.jakarta.jpa.internal.conditions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.ComparableFunction;
import org.torpedoquery.jakarta.jpa.Function;
import org.torpedoquery.jakarta.jpa.OnGoingCollectionCondition;
import org.torpedoquery.jakarta.jpa.OnGoingComparableCondition;
import org.torpedoquery.jakarta.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jakarta.jpa.OnGoingStringCondition;
import org.torpedoquery.jakarta.jpa.Torpedo;
import org.torpedoquery.jakarta.jpa.ValueOnGoingCondition;
import org.torpedoquery.jakarta.jpa.internal.Condition;
import org.torpedoquery.jakarta.jpa.internal.Parameter;

/**
 * <p>EmptyLogicalCondition class.</p>
 *
 * @author xjodoin
 * @version $Id: $Id
 */
public class EmptyLogicalCondition implements OnGoingLogicalCondition, Condition {

	private Condition delegate;
	
	/** {@inheritDoc} */
	@Override
	public <T> ValueOnGoingCondition<T> and(T property) {
		ValueOnGoingCondition<T> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> and(T property) {
		OnGoingComparableCondition<V> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <T> ValueOnGoingCondition<T> or(T property) {
		ValueOnGoingCondition<T> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> or(T property) {
		OnGoingComparableCondition<V> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> and(ComparableFunction<T> property) {
		OnGoingComparableCondition<V> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> or(ComparableFunction<T> property) {
		OnGoingComparableCondition<V> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <T> OnGoingCollectionCondition<T> and(Collection<T> object) {
		OnGoingCollectionCondition<T> condition = Torpedo.condition(object);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public <T> OnGoingCollectionCondition<T> or(Collection<T> object) {
		OnGoingCollectionCondition<T> condition = Torpedo.condition(object);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> and(String property) {
		OnGoingStringCondition<String> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> and(Function<String> function) {
		OnGoingStringCondition<String> condition = Torpedo.condition(function);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> or(String property) {
		OnGoingStringCondition<String> condition = Torpedo.condition(property);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingStringCondition<String> or(Function<String> function) {
		OnGoingStringCondition<String> condition = Torpedo.condition(function);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingLogicalCondition and(OnGoingLogicalCondition param) {
		OnGoingLogicalCondition condition = Torpedo.condition(param);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public OnGoingLogicalCondition or(OnGoingLogicalCondition param) {
		OnGoingLogicalCondition condition = Torpedo.condition(param);
		delegate = (Condition) condition;
		return condition;
	}

	/** {@inheritDoc} */
	@Override
	public String createQueryFragment(AtomicInteger incrementor) {
		if(delegate != null) {
			return delegate.createQueryFragment(incrementor);
		}else {
			return "";	
		}
		
	}

	/** {@inheritDoc} */
	@Override
	public List<Parameter> getParameters() {
		if(delegate != null) {
			return delegate.getParameters();
		}
		else {
			return Collections.emptyList();
		}
		
	}
	
	/** {@inheritDoc} */
	@Override
	public <T> QueryBuilder<T> getBuilder() {
		if(delegate != null) {
			return delegate.getBuilder();
		}
		else {
			return null;
		}
	}

}
