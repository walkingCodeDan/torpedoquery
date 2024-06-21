
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

import java.util.concurrent.atomic.AtomicReference;

import org.torpedoquery.jakarta.core.QueryBuilderFactory;
import org.torpedoquery.jakarta.jpa.internal.utils.MultiClassLoaderProvider;
import org.torpedoquery.jakarta.jpa.internal.utils.ProxyFactoryFactory;
import org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler;
public final class TorpedoMagic {

	private static final ThreadLocal<TorpedoProxy> query = new ThreadLocal<>();
	private static AtomicReference<QueryBuilderFactory> factory = new AtomicReference<>(
			new DefaultQueryBuilderFactory());

	private static final ProxyFactoryFactory proxyFactoryFactory = new ProxyFactoryFactory(
			new MultiClassLoaderProvider());

	private TorpedoMagic() {
	}

	/**
	 * <p>
	 * Setter for the field <code>query</code>.
	 * </p>
	 *
	 * @param query a {@link org.torpedoquery.jakarta.jpa.internal.TorpedoProxy} object.
	 */
	public static void setQuery(TorpedoProxy query) {
		TorpedoMagic.query.set(query);
	}

	/**
	 * <p>
	 * getTorpedoMethodHandler.
	 * </p>
	 *
	 * @return a {@link org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler}
	 *         object.
	 * @param obj a {@link java.lang.Object} object.
	 */
	public static TorpedoMethodHandler getTorpedoMethodHandler(Object obj) {
		if (obj instanceof TorpedoProxy) {
			return ((TorpedoProxy) obj).getTorpedoMethodHandler();
		} else {
			return getTorpedoMethodHandler();
		}
	}

	/**
	 * <p>getTorpedoMethodHandler.</p>
	 *
	 * @return a {@link org.torpedoquery.jakarta.jpa.internal.utils.TorpedoMethodHandler} object.
	 */
	public static TorpedoMethodHandler getTorpedoMethodHandler() {
		TorpedoProxy internalQuery = query.get();
		if (internalQuery != null) {
			return internalQuery.getTorpedoMethodHandler();
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * getQueryBuilderFactory.
	 * </p>
	 *
	 * @return a {@link org.torpedoquery.jakarta.core.QueryBuilderFactory} object.
	 */
	public static QueryBuilderFactory getQueryBuilderFactory() {
		return factory.get();
	}

	/**
	 * <p>
	 * setup.
	 * </p>
	 *
	 * @param queryBuilderFactory a
	 *                            {@link org.torpedoquery.jakarta.core.QueryBuilderFactory}
	 *                            object.
	 */
	public static void setup(QueryBuilderFactory queryBuilderFactory) {
		factory.set(queryBuilderFactory);
	}

	/**
	 * <p>
	 * getProxyfactoryfactory.
	 * </p>
	 *
	 * @return a {@link org.torpedoquery.jakarta.jpa.internal.utils.ProxyFactoryFactory}
	 *         object.
	 */
	public static ProxyFactoryFactory getProxyfactoryfactory() {
		return proxyFactoryFactory;
	}

}
