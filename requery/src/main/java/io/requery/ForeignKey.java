/*
 * Copyright 2016 requery.io
 *
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

package io.requery;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import io.requery.meta.Attribute;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Indicates that this field should be the foreign key for a reference to another type. Use
 * {@link Column} to define the name and other database attributes for the field.
 *
 * @see Column
 */
@Documented
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface ForeignKey {

    /**
     * @return action when the object is deleted, defaults to {@link ReferentialAction#CASCADE}
     * @see ReferentialAction
     */
    ReferentialAction delete() default ReferentialAction.CASCADE;

    /**
     * @return action when the object is updated, defaults to {@link ReferentialAction#CASCADE}
     * @see ReferentialAction
     */
    ReferentialAction update() default ReferentialAction.CASCADE;

    /**
     * @return column name in the foreign table this key references.
     * Defaults to the foreign table's primary key.
     */
    String referencedColumn() default "";

    /**
     * @return referenced entity type (optional).
     */
    Class<?> references() default void.class;

    /**
    * @return referenced attribute (optional)
    */
    String referencesAttribute() default "ID";
}
