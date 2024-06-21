package org.torpedoquery.jakarta.jpa;

import static org.junit.Assert.assertEquals;
import static org.torpedoquery.jakarta.jpa.Torpedo.condition;
import static org.torpedoquery.jakarta.jpa.Torpedo.from;
import static org.torpedoquery.jakarta.jpa.Torpedo.select;
import static org.torpedoquery.jakarta.jpa.Torpedo.where;

import org.junit.Test;
import org.torpedoquery.jakarta.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jakarta.jpa.Query;
import org.torpedoquery.jakarta.jpa.test.bo.Entity;

public class EmptyConditionTest {

	@Test
	public void testEmptyConditionShouldNotAddWhereClause() {
		Entity from = from(Entity.class);
		OnGoingLogicalCondition emptyCondition = condition();
		Query<Entity> select = select(from);
		where(emptyCondition);
		assertEquals("select entity_0 from Entity entity_0", select.getQuery());
	}
	
	
	@Test
	public void testEmptyConditionShouldNotAddConditionOnAnd() {
		Entity from = from(Entity.class);
		OnGoingLogicalCondition emptyCondition = condition();
		Query<Entity> select = select(from);
		where(from.getCode()).eq("test").and(emptyCondition);
		assertEquals("select entity_0 from Entity entity_0 where entity_0.code = :code_1", select.getQuery());
	}
	
	@Test
	public void testEmptyConditionShouldAllowChain() {
		Entity from = from(Entity.class);
		OnGoingLogicalCondition emptyCondition = condition();
		Query<Entity> select = select(from);
		emptyCondition.and(from.getCode()).eq("test");
		where(emptyCondition);
		assertEquals("select entity_0 from Entity entity_0 where ( entity_0.code = :code_1 )", select.getQuery());
	}

}
