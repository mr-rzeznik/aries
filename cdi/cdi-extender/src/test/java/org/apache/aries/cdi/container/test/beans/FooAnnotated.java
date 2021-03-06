/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.aries.cdi.container.test.beans;

import javax.inject.Inject;
import javax.inject.Named;

import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.cdi.annotations.SingleComponent;
import org.osgi.service.cdi.propertytypes.ServiceRanking;
import org.osgi.service.cdi.reference.BindObject;

@SingleComponent
@Named("foo.annotated")
@Service(Foo.class)
@ServiceRanking(12)
public class FooAnnotated implements Foo, Cloneable {

	@Inject
	void watchFoos(BindObject<Integer> numbers) {
		numbers.adding(number -> System.out.println("Added: " + number)
		).modified(number -> System.out.println("Updated: " + number)
		).removed(number -> System.out.println("Removed: " + number)
		).bind();
	}

	@Inject
	FooWithReferenceAndConfig fooWithReferenceAndConfig;

}
