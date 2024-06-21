
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
package org.torpedoquery.jakarta.jpa.internal.query;

import java.util.List;

import org.torpedoquery.jakarta.jpa.Query;
public class SubqueryValueParameters<T> extends SelectorParameter<T> {

    private final Query<T> value;

    /**
     * <p>Constructor for SubqueryValueParameters.</p>
     *
     * @param selector a {@link org.torpedoquery.jakarta.jpa.Query} object.
     */
    public SubqueryValueParameters(Query<T> selector) {
        super(selector);
        this.value = selector;
    }

    /**
     * <p>getParameters.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<ValueParameter<?>> getParameters() {
        return value.getValueParameters();
    }

}