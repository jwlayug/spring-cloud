package org.springframework.cloud.config.java;

import org.springframework.cloud.config.AbstractCloudConfigTest;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.ApplicationContext;

public abstract class AbstractCloudJavaConfigTest<SC> extends AbstractCloudConfigTest<SC> {

	private Class<?> withServiceIdContextClassName;
	private Class<?> withoutServiceIdContextClassName;

	public AbstractCloudJavaConfigTest(Class<?> withServiceIdContextClassName,
			                           Class<?> withoutServiceIdContextClassName) {
		this.withServiceIdContextClassName = withServiceIdContextClassName;
		this.withoutServiceIdContextClassName = withoutServiceIdContextClassName;
	}
	
	protected Class<?> getWithServiceIdContextClassName() {
		return withServiceIdContextClassName;
	}
	
	protected Class<?> getWithoutServiceIdContextClassName() {
		return withoutServiceIdContextClassName;
	}

	@Override
	protected ApplicationContext getTestApplicationContextWithServiceId(ServiceInfo... serviceInfos) {
		return getTestApplicationContext(getWithServiceIdContextClassName(), serviceInfos);
	}

	@Override
	protected ApplicationContext getTestApplicationContextWithoutServiceId(ServiceInfo... serviceInfos) {
		return getTestApplicationContext(getWithoutServiceIdContextClassName(), serviceInfos);
	}

}
