package org.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import jakarta.inject.Inject;

@RunWith(Arquillian.class)
public class ArquillianTest {

	@Inject
	TestEjbBean testEjbBean;

	@Deployment()
	@TargetsContainer("domain1")
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(TestEjbBean.class);
	}

	@Test
	public void testEjb() {
		testEjbBean.callVoid();
		Assert.assertTrue(true);
	}
}
