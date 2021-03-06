/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.extension.jdbc.dialect;

import org.seasar.extension.jdbc.SelectForUpdateType;
import org.seasar.framework.util.tiger.Pair;

/**
 * PostgreSQL8.1用の方言をあつかうクラスです。
 * 
 * @author koichik
 */
public class Postgre81Dialect extends PostgreDialect {

    @Override
    public boolean supportsForUpdate(final SelectForUpdateType type,
            boolean withTarget) {
        return type != SelectForUpdateType.WAIT;
    }

    @Override
    public String getForUpdateString(final SelectForUpdateType type,
            final int waitSeconds, final Pair<String, String>... aliases) {
        final String sql = super.getForUpdateString(type, waitSeconds, aliases);
        return type == SelectForUpdateType.NOWAIT ? sql + " nowait" : sql;
    }

}
