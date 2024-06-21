package org.torpedoquery.jakarta.jpa.internal.joins;

import java.util.function.Function;

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.JoinBuilder;
import org.torpedoquery.jakarta.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jakarta.jpa.internal.Join;
import org.torpedoquery.jakarta.jpa.internal.TorpedoMagic;
import org.torpedoquery.jakarta.jpa.internal.TorpedoProxy;
import org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition;
import org.torpedoquery.jakarta.jpa.internal.query.DefaultQueryBuilder;
import org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler;

/**
 * <p>Abstract AbstractJoinBuilder class.</p>
 *
 * @author xjodoin
 * @version $Id: $Id
 */
public abstract class AbstractJoinBuilder<T> implements JoinBuilder<T> {

	private Class<T> queryClass;
	private TorpedoMethodHandler methodHandler;

	/**
	 * <p>Constructor for AbstractJoinBuilder.</p>
	 *
	 * @param queryClass a {@link java.lang.Class} object.
	 * @param torpedoMethodHandler a {@link org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler} object.
	 */
	public AbstractJoinBuilder(Class<T> queryClass,TorpedoMethodHandler torpedoMethodHandler) {
		this.queryClass = queryClass;
		methodHandler = torpedoMethodHandler;
	}
	
	/** {@inheritDoc} */
	@Override
	public T on(Function<T, OnGoingLogicalCondition> onBuilder) {
		T join = TorpedoMagic.getProxyfactoryfactory().createProxy(methodHandler,queryClass, TorpedoProxy.class);
		final QueryBuilder queryBuilder = methodHandler.addQueryBuilder(join, new DefaultQueryBuilder(queryClass));
		LogicalCondition joinCondition = (LogicalCondition) onBuilder.apply(join);
		methodHandler.getRoot().addJoin(createJoin(queryBuilder, joinCondition));
		return join;
	}

	/**
	 * <p>createJoin.</p>
	 *
	 * @param queryBuilder a {@link org.torpedoquery.jakarta.core.QueryBuilder} object.
	 * @param joinCondition a {@link org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition} object.
	 * @return a {@link org.torpedoquery.jakarta.jpa.internal.Join} object.
	 */
	protected abstract Join createJoin(final QueryBuilder queryBuilder, LogicalCondition joinCondition);

}
