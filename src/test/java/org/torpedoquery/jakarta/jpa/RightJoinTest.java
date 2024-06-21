package org.torpedoquery.jakarta.jpa;

import org.junit.Test;
import org.torpedoquery.jakarta.jpa.Query;
import org.torpedoquery.jakarta.jpa.test.bo.Entity;
import org.torpedoquery.jakarta.jpa.test.bo.Entity2;

import static org.junit.Assert.*;
import static org.torpedoquery.jakarta.jpa.Torpedo.*;

public class RightJoinTest {

	@Test
	public void testJoinOnTwoEntityField() {
		Entity from = from(Entity.class);
		Entity2 entity2 = rightJoin(Entity2.class).on(query2 -> {
			return condition(query2.getCode()).eq(from.getCode());
		});
		
		Query<Entity> select = select(from);
		String query = select.getQuery();
		assertEquals("select entity_0 from Entity entity_0 right join Entity2 entity2_1 on entity2_1.code = entity_0.code", query);
	}
	
	@Test
	public void testJoinOnTwoEntityFieldWithConditon() {
		Entity from = from(Entity.class);
		Entity2 entity2 = rightJoin(Entity2.class).on(query2 -> {
			return condition(query2.getCode()).eq(from.getCode());
		});
		
		where(entity2.getCode()).eq("test");
		
		Query<Entity> select = select(from);
		String query = select.getQuery();
		assertEquals("select entity_0 from Entity entity_0 right join Entity2 entity2_1 on entity2_1.code = entity_0.code where entity2_1.code = :code_2", query);
		assertEquals(select.getParameters().get("code_2"), "test");
	}
	
	
}
