
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

import org.torpedoquery.jakarta.core.QueryBuilder;
import org.torpedoquery.jakarta.jpa.internal.Join;
import org.torpedoquery.jakarta.jpa.internal.joins.RightJoin;
import org.torpedoquery.jakarta.jpa.internal.utils.ProxyFactoryFactory;
import org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler;
public class RightJoinHandler<T> extends JoinHandler<T> {
	/**
	 * <p>Constructor for RightJoinHandler.</p>
	 *
	 * @param methodHandler a {@link org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler} object.
	 */
	public RightJoinHandler(TorpedoMethodHandler methodHandler) {
		super(methodHandler);
	}

	/**
	 * <p>Constructor for RightJoinHandler.</p>
	 *
	 * @param fjpaMethodHandler a {@link org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler} object.
	 * @param realType a {@link java.lang.Class} object.
	 */
	public RightJoinHandler(TorpedoMethodHandler fjpaMethodHandler, Class<T> realType) {
		super(fjpaMethodHandler, realType);
	}

	/** {@inheritDoc} */
	@Override
	protected Join createJoin(QueryBuilder queryBuilder, String fieldName) {
		return new RightJoin(queryBuilder, fieldName);
	}
}
