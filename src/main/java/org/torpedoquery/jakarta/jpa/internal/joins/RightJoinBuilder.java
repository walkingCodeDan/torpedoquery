package org.torpedoquery.jakarta.jpa.internal.joins;

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.internal.Join;
import org.torpedoquery.jakarta.jpa.internal.conditions.LogicalCondition;
import org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler;

/**
 * <p>RightJoinBuilder class.</p>
 *
 * @author xjodoin
 * @version $Id: $Id
 */
public class RightJoinBuilder<T> extends AbstractJoinBuilder<T>{

	private Class<T> queryClass;
	private TorpedoMethodHandler methodHandler;

	/**
	 * <p>Constructor for RightJoinBuilder.</p>
	 *
	 * @param queryClass a {@link java.lang.Class} object.
	 * @param torpedoMethodHandler a {@link org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler} object.
	 */
	public RightJoinBuilder(Class<T> queryClass,TorpedoMethodHandler torpedoMethodHandler) {
		super(queryClass, torpedoMethodHandler);
	}
	
	/** {@inheritDoc} */
	@Override
	protected Join createJoin(QueryBuilder queryBuilder, LogicalCondition joinCondition) {
		return new RightJoin(queryBuilder, joinCondition);
	}

}
