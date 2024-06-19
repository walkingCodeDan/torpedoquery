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
 */
package org.torpedoquery.jpa.internal.utils;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.torpedoquery.jpa.internal.TorpedoMagic;
import org.torpedoquery.jpa.internal.TorpedoProxy;
import org.torpedoquery.jpa.internal.query.DefaultQueryBuilder;
import org.torpedoquery.jpa.test.bo.Entity;

public class ProxyFactoryFactoryTest
{
	/**
	 * <p>
	 * test_factoryMustUseClassCache.
	 * </p>
	 */
	@Test
	public void test_factoryMustUseClassCache()
	{
		ProxyFactoryFactory proxyFactoryFactory = TorpedoMagic.getProxyfactoryfactory();
		TorpedoMethodHandler torpedoMethodHandler = new TorpedoMethodHandler(new DefaultQueryBuilder<Entity>(Entity.class));
		Entity createProxy = proxyFactoryFactory.createProxy(torpedoMethodHandler, Entity.class, TorpedoProxy.class);

		Entity createProxy2 = proxyFactoryFactory.createProxy(torpedoMethodHandler, Entity.class, TorpedoProxy.class);

		assertSame(createProxy.getClass(), createProxy2.getClass());
	}

}
