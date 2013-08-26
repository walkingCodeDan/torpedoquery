/**
 *   Copyright Xavier Jodoin xjodoin@torpedoquery.org
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.torpedoquery.jpa.internal.conditions;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.torpedoquery.jpa.internal.Condition;
import org.torpedoquery.jpa.internal.Parameter;

public class GroupingCondition implements Condition {

	private final Condition condition;

	public GroupingCondition(Condition condition) {
		this.condition = condition;
	}

	@Override
	public String createQueryFragment(AtomicInteger incrementor) {
		return "( " + condition.createQueryFragment(incrementor) + " )";
	}

	@Override
	public List<Parameter> getParameters() {
		return condition.getParameters();
	}

}
