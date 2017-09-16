/**************************************************************
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 *************************************************************/

package com.sun.star.sdbcx.comp.postgresql.sdbcx.descriptors;

import com.sun.star.beans.XPropertySet;
import com.sun.star.sdbc.SQLException;
import com.sun.star.sdbcx.comp.postgresql.util.DbTools;

public class SdbcxKeyDescriptorContainer extends SdbcxDescriptorContainer {
    public SdbcxKeyDescriptorContainer(Object lock, boolean isCaseSensitive) {
        super(lock, isCaseSensitive);
    }
    
    @Override
    protected XPropertySet createDescriptor() {
        return SdbcxKeyDescriptor.create(isCaseSensitive());
    }
    
    @Override
    protected XPropertySet appendObject(String _rForName, XPropertySet descriptor) throws SQLException {
        XPropertySet newDescriptor = cloneDescriptor(descriptor);
        DbTools.cloneDescriptorColumns(descriptor, newDescriptor);
        return newDescriptor;
    }
}